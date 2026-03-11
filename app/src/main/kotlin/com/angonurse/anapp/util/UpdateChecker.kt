package com.angonurse.anapp.util

import android.app.Activity
import android.app.AlertDialog
import android.app.DownloadManager
import android.content.*
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.util.TypedValue
import android.view.Gravity
import android.widget.*
import androidx.core.content.FileProvider
import kotlinx.coroutines.*
import org.json.JSONObject
import java.io.File
import java.net.URL

class UpdateChecker(private val activity: Activity) {

    companion object {
        private const val VERSION_URL =
            "https://angonurse.vercel.app/downloads/anapp-update.json"
    }

    private var downloadId: Long = -1

    fun checkForUpdate(manual: Boolean = false) {

        CoroutineScope(Dispatchers.IO).launch {

            try {

                val json = URL(VERSION_URL).readText()

                val obj = JSONObject(json)

                val latestVersion = obj.getString("latest_version")

                val downloadUrl = obj.getString("download_url")

                val currentVersion =
                    activity.packageManager.getPackageInfo(activity.packageName, 0).versionName

                if (latestVersion != currentVersion) {

                    withContext(Dispatchers.Main) {

                        showUpdateDialog(latestVersion, downloadUrl)

                    }

                } else if (manual) {

                    withContext(Dispatchers.Main) {

                        Toast.makeText(
                            activity,
                            "Já possui a versão mais recente.",
                            Toast.LENGTH_SHORT
                        ).show()

                    }
                }

            } catch (e: Exception) {

                if (manual) {

                    withContext(Dispatchers.Main) {

                        Toast.makeText(
                            activity,
                            "Erro ao verificar actualização.",
                            Toast.LENGTH_SHORT
                        ).show()

                    }
                }
            }
        }
    }

    private fun showUpdateDialog(version: String, url: String) {

        AlertDialog.Builder(activity)
            .setTitle("Nova versão disponível")
            .setMessage("Existe uma nova versão do aplicativo.\n\nVersão: $version")
            .setPositiveButton("Actualizar") { _, _ ->

                startDownload(url, version)

            }
            .setNegativeButton("Mais tarde", null)
            .show()
    }

    private fun startDownload(url: String, version: String) {

        val fileName = "anapp-$version.apk"

        val progressLayout = LinearLayout(activity).apply {

            orientation = LinearLayout.VERTICAL

            setPadding(40, 40, 40, 40)

            gravity = Gravity.CENTER
        }

        val progressBar =
            ProgressBar(activity, null, android.R.attr.progressBarStyleHorizontal)

        val progressText = TextView(activity)

        val progressSize = TextView(activity)

        progressLayout.addView(progressBar)

        progressLayout.addView(progressText)

        progressLayout.addView(progressSize)

        val dialog = AlertDialog.Builder(activity)
            .setTitle("Transferindo atualização")
            .setView(progressLayout)
            .setCancelable(false)
            .setNegativeButton("Cancelar") { _, _ ->

                val dm =
                    activity.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager

                dm.remove(downloadId)

            }
            .create()

        dialog.show()

        val request = DownloadManager.Request(Uri.parse(url))

        request.setTitle("Atualização AnApp")

        request.setDescription("Transferindo nova versão")

        request.setDestinationInExternalPublicDir(
            Environment.DIRECTORY_DOWNLOADS,
            fileName
        )

        request.setNotificationVisibility(
            DownloadManager.Request.VISIBILITY_VISIBLE
        )

        val dm = activity.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager

        downloadId = dm.enqueue(request)

        CoroutineScope(Dispatchers.IO).launch {

            var downloading = true

            while (downloading) {

                val query = DownloadManager.Query().setFilterById(downloadId)

                val cursor = dm.query(query)

                if (cursor != null && cursor.moveToFirst()) {

                    val downloaded =
                        cursor.getLong(cursor.getColumnIndexOrThrow(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR))

                    val total =
                        cursor.getLong(cursor.getColumnIndexOrThrow(DownloadManager.COLUMN_TOTAL_SIZE_BYTES))

                    val status =
                        cursor.getInt(cursor.getColumnIndexOrThrow(DownloadManager.COLUMN_STATUS))

                    if (total > 0) {

                        val progress = (downloaded * 100 / total).toInt()

                        val downloadedMB = downloaded / (1024 * 1024)

                        val totalMB = total / (1024 * 1024)

                        withContext(Dispatchers.Main) {

                            progressBar.progress = progress

                            progressText.text = "Progresso: $progress%"

                            progressSize.text =
                                "$downloadedMB MB / $totalMB MB"
                        }
                    }

                    if (status == DownloadManager.STATUS_SUCCESSFUL) {

                        downloading = false

                        withContext(Dispatchers.Main) {

                            dialog.dismiss()

                            installApk(fileName)

                        }
                    }

                    if (status == DownloadManager.STATUS_FAILED) {

                        downloading = false

                        withContext(Dispatchers.Main) {

                            dialog.dismiss()

                            Toast.makeText(
                                activity,
                                "Falha no download.",
                                Toast.LENGTH_LONG
                            ).show()

                        }
                    }

                    cursor.close()
                }

                delay(800)
            }
        }
    }

    private fun installApk(fileName: String) {

        val file = File(
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
            fileName
        )

        val uri = FileProvider.getUriForFile(
            activity,
            "${activity.packageName}.fileprovider",
            file
        )

        val intent = Intent(Intent.ACTION_VIEW)

        intent.setDataAndType(
            uri,
            "application/vnd.android.package-archive"
        )

        intent.flags =
            Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_ACTIVITY_NEW_TASK

        activity.startActivity(intent)
    }
}
