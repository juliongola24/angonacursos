package com.angonurse.anapp.util

import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.FileProvider
import com.angonurse.anapp.R
import com.google.gson.Gson
import java.io.File
import java.net.HttpURLConnection
import java.net.URL

/**
 * Verifica se existe uma nova versão do app e oferece download + instalação automática.
 *
 * JSON remoto esperado (version-anapp.json):
 * {
 *   "versionCode": 2,
 *   "versionName": "1.1.0",
 *   "releaseNotes": "Correcções e melhorias."
 * }
 */
object UpdateChecker {

    private const val VERSION_URL = "https://angonurse.vercel.app/downloads/version-anapp.json"
    private const val APK_URL = "https://angonurse.vercel.app/downloads/analises-clinicas-materias.apk"
    private const val APK_FILE_NAME = "analises-clinicas-materias.apk"

    private data class RemoteVersion(
        val versionCode: Int = 0,
        val versionName: String = "",
        val releaseNotes: String = ""
    )

    /** Chama no onCreate da MainActivity (ou onde preferir). */
    fun check(context: Context) {
        Thread {
            try {
                val json = fetchJson(VERSION_URL) ?: return@Thread
                val remote = Gson().fromJson(json, RemoteVersion::class.java)
                val currentCode = context.packageManager
                    .getPackageInfo(context.packageName, 0)
                    .let {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) it.longVersionCode.toInt()
                        else @Suppress("DEPRECATION") it.versionCode
                    }

                if (remote.versionCode > currentCode) {
                    (context as? androidx.appcompat.app.AppCompatActivity)?.runOnUiThread {
                        showUpdateDialog(context, remote)
                    }
                }
            } catch (_: Exception) {
                // Silencioso — sem rede ou erro no JSON
            }
        }.start()
    }

    /** Verificação manual — mostra feedback ao utilizador mesmo se estiver actualizado. */
    fun checkManual(context: Context) {
        Toast.makeText(context, "A verificar actualizações…", Toast.LENGTH_SHORT).show()
        Thread {
            try {
                val json = fetchJson(VERSION_URL)
                val activity = context as? androidx.appcompat.app.AppCompatActivity ?: return@Thread

                if (json == null) {
                    activity.runOnUiThread {
                        Toast.makeText(context, "Não foi possível verificar. Verifique a sua conexão.", Toast.LENGTH_LONG).show()
                    }
                    return@Thread
                }

                val remote = Gson().fromJson(json, RemoteVersion::class.java)
                val currentCode = context.packageManager
                    .getPackageInfo(context.packageName, 0)
                    .let {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) it.longVersionCode.toInt()
                        else @Suppress("DEPRECATION") it.versionCode
                    }

                activity.runOnUiThread {
                    if (remote.versionCode > currentCode) {
                        showUpdateDialog(context, remote)
                    } else {
                        Toast.makeText(context, "✅ O app já está actualizado!", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (_: Exception) {
                (context as? androidx.appcompat.app.AppCompatActivity)?.runOnUiThread {
                    Toast.makeText(context, "Erro ao verificar actualizações.", Toast.LENGTH_SHORT).show()
                }
            }
        }.start()
    }

    private fun fetchJson(url: String): String? {
        val conn = URL(url).openConnection() as HttpURLConnection
        conn.connectTimeout = 8_000
        conn.readTimeout = 8_000
        return try {
            if (conn.responseCode == 200) conn.inputStream.bufferedReader().readText() else null
        } finally {
            conn.disconnect()
        }
    }

    private fun showUpdateDialog(context: Context, remote: RemoteVersion) {
        AlertDialog.Builder(context)
            .setTitle("Nova versão disponível (${remote.versionName})")
            .setMessage(remote.releaseNotes.ifBlank { "Uma nova versão do app está disponível. Deseja actualizar agora?" })
            .setPositiveButton("Actualizar") { _, _ -> downloadApk(context) }
            .setNegativeButton("Depois", null)
            .setCancelable(true)
            .show()
    }

    private fun downloadApk(context: Context) {
        Toast.makeText(context, "A transferir actualização…", Toast.LENGTH_SHORT).show()

        // Remove APK antigo se existir
        val destFile = File(context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), APK_FILE_NAME)
        if (destFile.exists()) destFile.delete()

        val request = DownloadManager.Request(Uri.parse(APK_URL))
            .setTitle("Actualização AngoNurse")
            .setDescription("A transferir nova versão…")
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            .setDestinationInExternalFilesDir(context, Environment.DIRECTORY_DOWNLOADS, APK_FILE_NAME)
            .setAllowedOverMetered(true)
            .setAllowedOverRoaming(true)

        val dm = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        val downloadId = dm.enqueue(request)

        // Escuta conclusão do download
        val receiver = object : BroadcastReceiver() {
            override fun onReceive(ctx: Context, intent: Intent) {
                val id = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1)
                if (id == downloadId) {
                    ctx.unregisterReceiver(this)
                    installApk(ctx)
                }
            }
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            context.registerReceiver(receiver, IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE), Context.RECEIVER_EXPORTED)
        } else {
            context.registerReceiver(receiver, IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE))
        }
    }

    private fun installApk(context: Context) {
        val file = File(context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), APK_FILE_NAME)
        if (!file.exists()) {
            Toast.makeText(context, "Ficheiro não encontrado.", Toast.LENGTH_SHORT).show()
            return
        }

        val uri = FileProvider.getUriForFile(context, "${context.packageName}.fileprovider", file)
        val intent = Intent(Intent.ACTION_VIEW).apply {
            setDataAndType(uri, "application/vnd.android.package-archive")
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        context.startActivity(intent)
    }
}
