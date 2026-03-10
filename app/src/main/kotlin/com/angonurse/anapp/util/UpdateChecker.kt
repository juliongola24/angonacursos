package com.angonurse.anapp.util

import android.app.Activity
import android.app.AlertDialog
import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StyleSpan
import android.util.TypedValue
import android.view.Gravity
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import kotlinx.coroutines.*
import org.json.JSONObject
import java.io.File
import java.net.URL

class UpdateChecker(private val activity: Activity) {

    companion object {
        private const val VERSION_URL = "https://angonurse.vercel.app/downloads/version-anapp.json"
    }

    fun checkForUpdate(manual: Boolean = false) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val json = URL(VERSION_URL).readText()
                val obj = JSONObject(json)
                val latestVersion = obj.getString("latest_version")
                val downloadUrl = obj.getString("download_url")
                val changelog = obj.optString("changelog", "")
                val forced = obj.optBoolean("forced", false)

                val currentVersion = getCurrentVersion()
                if (isNewerVersion(latestVersion, currentVersion)) {
                    withContext(Dispatchers.Main) {
                        showUpdateDialog(latestVersion, downloadUrl, changelog, forced)
                    }
                } else if (manual) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(activity, "Já possui a versão mais recente.", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: Exception) {
                if (manual) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(activity, "Erro ao verificar actualização.", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    private fun getCurrentVersion(): String {
        return try {
            val pInfo = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                activity.packageManager.getPackageInfo(activity.packageName, PackageManager.PackageInfoFlags.of(0))
            } else {
                @Suppress("DEPRECATION")
                activity.packageManager.getPackageInfo(activity.packageName, 0)
            }
            pInfo.versionName ?: "0.0.0"
        } catch (_: Exception) {
            "0.0.0"
        }
    }

    private fun isNewerVersion(latest: String, current: String): Boolean {
        val latestParts = latest.split(".").map { it.toIntOrNull() ?: 0 }
        val currentParts = current.split(".").map { it.toIntOrNull() ?: 0 }
        for (i in 0 until maxOf(latestParts.size, currentParts.size)) {
            val l = latestParts.getOrElse(i) { 0 }
            val c = currentParts.getOrElse(i) { 0 }
            if (l > c) return true
            if (l < c) return false
        }
        return false
    }

    private fun showUpdateDialog(version: String, url: String, changelog: String, forced: Boolean) {
        val dp = { value: Int ->
            TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value.toFloat(), activity.resources.displayMetrics).toInt()
        }

        val container = LinearLayout(activity).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(dp(24), dp(20), dp(24), dp(20))
            gravity = Gravity.CENTER_HORIZONTAL
        }

        // Logo
        try {
            val logo = ImageView(activity).apply {
                setImageResource(activity.applicationInfo.icon)
                layoutParams = LinearLayout.LayoutParams(dp(72), dp(72)).apply {
                    bottomMargin = dp(16)
                    gravity = Gravity.CENTER_HORIZONTAL
                }
            }
            container.addView(logo)
        } catch (_: Exception) {}

        // Title
        val title = TextView(activity).apply {
            text = "Nova Versão Disponível"
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)
            setTypeface(typeface, Typeface.BOLD)
            gravity = Gravity.CENTER
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply { bottomMargin = dp(8) }
        }
        container.addView(title)

        // Version info
        val versionText = TextView(activity).apply {
            val spannable = SpannableString("Versão $version disponível para download")
            spannable.setSpan(StyleSpan(Typeface.BOLD), 7, 7 + version.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            text = spannable
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 14f)
            gravity = Gravity.CENTER
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply { bottomMargin = dp(16) }
        }
        container.addView(versionText)

        // Changelog
        if (changelog.isNotBlank()) {
            val changelogTitle = TextView(activity).apply {
                text = "O que há de novo:"
                setTextSize(TypedValue.COMPLEX_UNIT_SP, 15f)
                setTypeface(typeface, Typeface.BOLD)
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply { bottomMargin = dp(6) }
            }
            container.addView(changelogTitle)

            val changelogBody = TextView(activity).apply {
                text = changelog
                setTextSize(TypedValue.COMPLEX_UNIT_SP, 13f)
                lineSpacingExtra = 4f
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply { bottomMargin = dp(16) }
            }
            container.addView(changelogBody)
        }

        val scrollView = ScrollView(activity).apply {
            addView(container)
        }

        val dialog = AlertDialog.Builder(activity)
            .setView(scrollView)
            .setCancelable(!forced)
            .create()

        // Buttons
        val btnLayout = LinearLayout(activity).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.END
            setPadding(dp(16), 0, dp(16), dp(16))
        }

        if (!forced) {
            val btnLater = Button(activity).apply {
                text = "Mais Tarde"
                setOnClickListener { dialog.dismiss() }
            }
            btnLayout.addView(btnLater)
        }

        val btnUpdate = Button(activity).apply {
            text = "Actualizar Agora"
            setOnClickListener {
                dialog.dismiss()
                startDownload(url, version)
            }
        }

        val accent = try {
            val tv = TypedValue()
            activity.theme.resolveAttribute(com.google.android.material.R.attr.colorPrimary, tv, true)
            tv.data
        } catch (_: Exception) { Color.parseColor("#6C3AED") }

        val bg = GradientDrawable().apply {
            setColor(accent)
            cornerRadius = dp(8).toFloat()
        }
        btnUpdate.background = bg
        btnUpdate.setTextColor(Color.WHITE)

        btnLayout.addView(btnUpdate)
        container.addView(btnLayout)

        dialog.show()
    }

    private fun startDownload(url: String, version: String) {
        val dp = { value: Int ->
            TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value.toFloat(), activity.resources.displayMetrics).toInt()
        }

        val fileName = "anapp-$version.apk"

        // Progress dialog
        val progressLayout = LinearLayout(activity).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(dp(24), dp(20), dp(24), dp(20))
            gravity = Gravity.CENTER
        }

        val progressBar = ProgressBar(activity, null, android.R.attr.progressBarStyleHorizontal).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply { bottomMargin = dp(12) }
            max = 100
        }
        progressLayout.addView(progressBar)

        val progressText = TextView(activity).apply {
            text = "A transferir... 0%"
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 14f)
            gravity = Gravity.CENTER
        }
        progressLayout.addView(progressText)

        val progressPercent = TextView(activity).apply {
            text = ""
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f)
            gravity = Gravity.CENTER
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply { topMargin = dp(4) }
        }
        progressLayout.addView(progressPercent)

        val progressDialog = AlertDialog.Builder(activity)
            .setTitle("A transferir actualização")
            .setView(progressLayout)
            .setCancelable(false)
            .create()
        progressDialog.show()

        // Download
        val request = DownloadManager.Request(Uri.parse(url)).apply {
            setTitle("Actualização AnApp $version")
            setDescription("A transferir a nova versão...")
            setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, fileName)
            setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
        }

        val dm = activity.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        val downloadId = dm.enqueue(request)

        // Monitor progress
        CoroutineScope(Dispatchers.IO).launch {
            var downloading = true
            while (downloading) {
                val query = DownloadManager.Query().setFilterById(downloadId)
                val cursor = dm.query(query)
                if (cursor.moveToFirst()) {
                    val bytesIdx = cursor.getColumnIndex(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR)
                    val totalIdx = cursor.getColumnIndex(DownloadManager.COLUMN_TOTAL_SIZE_BYTES)
                    val statusIdx = cursor.getColumnIndex(DownloadManager.COLUMN_STATUS)

                    if (bytesIdx >= 0 && totalIdx >= 0 && statusIdx >= 0) {
                        val bytesDownloaded = cursor.getLong(bytesIdx)
                        val totalBytes = cursor.getLong(totalIdx)
                        val status = cursor.getInt(statusIdx)

                        if (totalBytes > 0) {
                            val progress = ((bytesDownloaded * 100) / totalBytes).toInt()
                            val downloadedMB = bytesDownloaded / (1024.0 * 1024.0)
                            val totalMB = totalBytes / (1024.0 * 1024.0)

                            withContext(Dispatchers.Main) {
                                progressBar.progress = progress
                                progressText.text = "A transferir... $progress%"
                                progressPercent.text = String.format("%.1f MB / %.1f MB", downloadedMB, totalMB)
                            }
                        }

                        if (status == DownloadManager.STATUS_SUCCESSFUL || status == DownloadManager.STATUS_FAILED) {
                            downloading = false
                        }
                    } else {
                        downloading = false
                    }
                }
                cursor.close()
                delay(500)
            }

            withContext(Dispatchers.Main) {
                progressDialog.dismiss()
            }
        }

        // Install when complete
        val receiver = object : BroadcastReceiver() {
            override fun onReceive(ctx: Context?, intent: Intent?) {
                val id = intent?.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1) ?: return
                if (id != downloadId) return

                activity.unregisterReceiver(this)

                val file = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), fileName)
                if (file.exists()) {
                    val uri = FileProvider.getUriForFile(activity, "${activity.packageName}.fileprovider", file)
                    val install = Intent(Intent.ACTION_VIEW).apply {
                        setDataAndType(uri, "application/vnd.android.package-archive")
                        addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    }
                    activity.startActivity(install)
                }
            }
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            activity.registerReceiver(receiver, IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE), Context.RECEIVER_EXPORTED)
        } else {
            @Suppress("UnspecifiedRegisterReceiverFlag")
            activity.registerReceiver(receiver, IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE))
        }
    }
}
