package com.angonurse.anapp.util

import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Color
import android.graphics.Typeface
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.view.Gravity
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import com.angonurse.anapp.R
import com.google.android.material.button.MaterialButton
import com.google.gson.Gson
import java.io.File
import java.net.HttpURLConnection
import java.net.URL

/**
 * Verifica actualizações com JSON dinâmico e diálogos personalizados.
 *
 * JSON remoto esperado:
 * {
 *   "version": "1.0.0",
 *   "changelog": "Correções de bugs e melhorias...",
 *   "force": false,
 *   "min_supported": "1.0.0",
 *   "apk_url": "https://angonurse.vercel.app/downloads/angonurse-anapp.apk"
 * }
 */
object UpdateChecker {

    private const val VERSION_URL = "https://angonurse.vercel.app/downloads/version-anapp.json"

    private data class RemoteConfig(
        val version: String = "1.0.0",
        val changelog: String = "",
        val force: Boolean = false,
        val min_supported: String = "1.0.0",
        val apk_url: String = ""
    )

    /** Verificação automática (silenciosa se estiver actualizado). */
    fun check(context: Context) {
        Thread {
            try {
                val json = fetchJson(VERSION_URL) ?: return@Thread
                val remote = Gson().fromJson(json, RemoteConfig::class.java)
                val currentVersion = getAppVersion(context)

                val needsUpdate = compareVersions(remote.version, currentVersion) > 0
                val unsupported = compareVersions(remote.min_supported, currentVersion) > 0

                if (needsUpdate || unsupported) {
                    (context as? androidx.appcompat.app.AppCompatActivity)?.runOnUiThread {
                        showUpdateDialog(context, remote, forceUpdate = unsupported || remote.force)
                    }
                }
            } catch (_: Exception) { }
        }.start()
    }

    /** Verificação manual — sempre mostra feedback. */
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

                val remote = Gson().fromJson(json, RemoteConfig::class.java)
                val currentVersion = getAppVersion(context)
                val needsUpdate = compareVersions(remote.version, currentVersion) > 0
                val unsupported = compareVersions(remote.min_supported, currentVersion) > 0

                activity.runOnUiThread {
                    if (needsUpdate || unsupported) {
                        showUpdateDialog(context, remote, forceUpdate = unsupported || remote.force)
                    } else {
                        showUpToDateDialog(context, currentVersion)
                    }
                }
            } catch (_: Exception) {
                (context as? androidx.appcompat.app.AppCompatActivity)?.runOnUiThread {
                    Toast.makeText(context, "Erro ao verificar actualizações.", Toast.LENGTH_SHORT).show()
                }
            }
        }.start()
    }

    // ── Diálogos personalizados ──────────────────────────────────────────

    private fun showUpdateDialog(context: Context, remote: RemoteConfig, forceUpdate: Boolean) {
        val dp = context.resources.displayMetrics.density

        val root = LinearLayout(context).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER_HORIZONTAL
            setPadding((24 * dp).toInt(), (24 * dp).toInt(), (24 * dp).toInt(), (16 * dp).toInt())
        }

        // Ícone do app
        val icon = ImageView(context).apply {
            setImageResource(R.mipmap.ic_launcher_foreground)
            layoutParams = LinearLayout.LayoutParams((80 * dp).toInt(), (80 * dp).toInt()).apply {
                gravity = Gravity.CENTER_HORIZONTAL
                bottomMargin = (12 * dp).toInt()
            }
        }
        root.addView(icon)

        // Badge da versão
        val badge = TextView(context).apply {
            text = "v${remote.version}"
            setTextColor(Color.WHITE)
            setBackgroundColor(ContextCompat.getColor(context, R.color.primary))
            setPadding((12 * dp).toInt(), (4 * dp).toInt(), (12 * dp).toInt(), (4 * dp).toInt())
            textSize = 12f
            typeface = Typeface.DEFAULT_BOLD
            gravity = Gravity.CENTER
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.CENTER_HORIZONTAL
                bottomMargin = (16 * dp).toInt()
            }
        }
        root.addView(badge)

        // Título
        val title = TextView(context).apply {
            text = if (forceUpdate) "Actualização Obrigatória" else "Nova Versão Disponível"
            textSize = 20f
            typeface = Typeface.DEFAULT_BOLD
            gravity = Gravity.CENTER
            setTextColor(ContextCompat.getColor(context, R.color.text_primary))
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply { bottomMargin = (8 * dp).toInt() }
        }
        root.addView(title)

        // Subtítulo
        if (forceUpdate) {
            val sub = TextView(context).apply {
                text = "Esta versão já não é suportada.\nPor favor, actualize para continuar a utilizar o app."
                textSize = 14f
                gravity = Gravity.CENTER
                setTextColor(ContextCompat.getColor(context, R.color.text_secondary))
                layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                ).apply { bottomMargin = (16 * dp).toInt() }
            }
            root.addView(sub)
        }

        // Changelog
        if (remote.changelog.isNotBlank()) {
            val changelogLabel = TextView(context).apply {
                text = "Novidades:"
                textSize = 14f
                typeface = Typeface.DEFAULT_BOLD
                setTextColor(ContextCompat.getColor(context, R.color.text_primary))
                layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                ).apply { bottomMargin = (4 * dp).toInt() }
            }
            root.addView(changelogLabel)

            val scroll = ScrollView(context).apply {
                layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    (120 * dp).toInt()
                ).apply { bottomMargin = (16 * dp).toInt() }
            }
            val changelogText = TextView(context).apply {
                text = remote.changelog
                textSize = 13f
                setTextColor(ContextCompat.getColor(context, R.color.text_secondary))
                lineSpacingExtra = 4f
            }
            scroll.addView(changelogText)
            root.addView(scroll)
        }

        // Botão Actualizar
        val btnUpdate = MaterialButton(context).apply {
            text = "Actualizar Agora"
            setBackgroundColor(ContextCompat.getColor(context, R.color.primary))
            setTextColor(Color.WHITE)
            cornerRadius = (12 * dp).toInt()
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply { bottomMargin = (8 * dp).toInt() }
        }
        root.addView(btnUpdate)

        val dialog = AlertDialog.Builder(context)
            .setView(root)
            .setCancelable(!forceUpdate)
            .create()

        btnUpdate.setOnClickListener {
            dialog.dismiss()
            downloadApk(context, remote.apk_url)
        }

        // Botão "Depois" só se não for forçado
        if (!forceUpdate) {
            val btnLater = MaterialButton(context, null, com.google.android.material.R.attr.materialButtonOutlinedStyle).apply {
                text = "Mais Tarde"
                setTextColor(ContextCompat.getColor(context, R.color.text_secondary))
                cornerRadius = (12 * dp).toInt()
                layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
            }
            root.addView(btnLater)
            btnLater.setOnClickListener { dialog.dismiss() }
        }

        dialog.show()
    }

    private fun showUpToDateDialog(context: Context, currentVersion: String) {
        val dp = context.resources.displayMetrics.density

        val root = LinearLayout(context).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER_HORIZONTAL
            setPadding((24 * dp).toInt(), (24 * dp).toInt(), (24 * dp).toInt(), (24 * dp).toInt())
        }

        val icon = ImageView(context).apply {
            setImageResource(R.mipmap.ic_launcher_foreground)
            layoutParams = LinearLayout.LayoutParams((80 * dp).toInt(), (80 * dp).toInt()).apply {
                gravity = Gravity.CENTER_HORIZONTAL
                bottomMargin = (12 * dp).toInt()
            }
        }
        root.addView(icon)

        val checkIcon = TextView(context).apply {
            text = "✅"
            textSize = 32f
            gravity = Gravity.CENTER
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.CENTER_HORIZONTAL
                bottomMargin = (12 * dp).toInt()
            }
        }
        root.addView(checkIcon)

        val title = TextView(context).apply {
            text = "App Actualizado!"
            textSize = 20f
            typeface = Typeface.DEFAULT_BOLD
            gravity = Gravity.CENTER
            setTextColor(ContextCompat.getColor(context, R.color.text_primary))
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply { bottomMargin = (8 * dp).toInt() }
        }
        root.addView(title)

        val desc = TextView(context).apply {
            text = "Está a utilizar a versão mais recente (v$currentVersion).\nNenhuma actualização disponível."
            textSize = 14f
            gravity = Gravity.CENTER
            setTextColor(ContextCompat.getColor(context, R.color.text_secondary))
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply { bottomMargin = (20 * dp).toInt() }
        }
        root.addView(desc)

        val btnOk = MaterialButton(context).apply {
            text = "OK"
            setBackgroundColor(ContextCompat.getColor(context, R.color.primary))
            setTextColor(Color.WHITE)
            cornerRadius = (12 * dp).toInt()
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }
        root.addView(btnOk)

        val dialog = AlertDialog.Builder(context)
            .setView(root)
            .setCancelable(true)
            .create()

        btnOk.setOnClickListener { dialog.dismiss() }
        dialog.show()
    }

    // ── Utilitários ──────────────────────────────────────────────────────

    private fun getAppVersion(context: Context): String {
        return try {
            context.packageManager.getPackageInfo(context.packageName, 0).versionName ?: "1.0.0"
        } catch (_: Exception) { "1.0.0" }
    }

    /** Compara versões semânticas (ex: "1.2.3" vs "1.3.0"). Retorna >0 se a > b. */
    private fun compareVersions(a: String, b: String): Int {
        val pa = a.split(".").map { it.toIntOrNull() ?: 0 }
        val pb = b.split(".").map { it.toIntOrNull() ?: 0 }
        val len = maxOf(pa.size, pb.size)
        for (i in 0 until len) {
            val va = pa.getOrElse(i) { 0 }
            val vb = pb.getOrElse(i) { 0 }
            if (va != vb) return va - vb
        }
        return 0
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

    private var progressDialog: AlertDialog? = null
    private var progressBar: ProgressBar? = null
    private var progressText: TextView? = null
    private var progressPercent: TextView? = null

    private fun showDownloadProgress(context: Context) {
        val dp = context.resources.displayMetrics.density

        val root = LinearLayout(context).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER_HORIZONTAL
            setPadding((24 * dp).toInt(), (24 * dp).toInt(), (24 * dp).toInt(), (24 * dp).toInt())
        }

        val icon = ImageView(context).apply {
            setImageResource(R.mipmap.ic_launcher_foreground)
            layoutParams = LinearLayout.LayoutParams((64 * dp).toInt(), (64 * dp).toInt()).apply {
                gravity = Gravity.CENTER_HORIZONTAL
                bottomMargin = (12 * dp).toInt()
            }
        }
        root.addView(icon)

        val title = TextView(context).apply {
            text = "A Transferir Actualização"
            textSize = 18f
            typeface = Typeface.DEFAULT_BOLD
            gravity = Gravity.CENTER
            setTextColor(ContextCompat.getColor(context, R.color.text_primary))
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply { bottomMargin = (4 * dp).toInt() }
        }
        root.addView(title)

        val subtitle = TextView(context).apply {
            text = "Por favor, aguarde…"
            textSize = 13f
            gravity = Gravity.CENTER
            setTextColor(ContextCompat.getColor(context, R.color.text_secondary))
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply { bottomMargin = (20 * dp).toInt() }
        }
        root.addView(subtitle)

        progressPercent = TextView(context).apply {
            text = "0%"
            textSize = 28f
            typeface = Typeface.DEFAULT_BOLD
            gravity = Gravity.CENTER
            setTextColor(ContextCompat.getColor(context, R.color.primary))
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply { bottomMargin = (12 * dp).toInt() }
        }
        root.addView(progressPercent!!)

        progressBar = ProgressBar(context, null, android.R.attr.progressBarStyleHorizontal).apply {
            max = 100
            progress = 0
            progressDrawable = ContextCompat.getDrawable(context, R.drawable.bg_progress_track)
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                (8 * dp).toInt()
            ).apply { bottomMargin = (8 * dp).toInt() }
        }
        root.addView(progressBar!!)

        progressText = TextView(context).apply {
            text = "A preparar…"
            textSize = 12f
            gravity = Gravity.CENTER
            setTextColor(ContextCompat.getColor(context, R.color.text_secondary))
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }
        root.addView(progressText!!)

        progressDialog = AlertDialog.Builder(context)
            .setView(root)
            .setCancelable(false)
            .create()

        progressDialog?.show()
    }

    private fun downloadApk(context: Context, apkUrl: String) {
        if (apkUrl.isBlank()) {
            Toast.makeText(context, "URL de download não disponível.", Toast.LENGTH_SHORT).show()
            return
        }

        val activity = context as? androidx.appcompat.app.AppCompatActivity ?: return

        val fileName = apkUrl.substringAfterLast("/")
        val destFile = File(context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), fileName)
        if (destFile.exists()) destFile.delete()

        showDownloadProgress(context)

        val request = DownloadManager.Request(Uri.parse(apkUrl))
            .setTitle("Actualização do App")
            .setDescription("A transferir nova versão…")
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            .setDestinationInExternalFilesDir(context, Environment.DIRECTORY_DOWNLOADS, fileName)
            .setAllowedOverMetered(true)
            .setAllowedOverRoaming(true)

        val dm = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        val downloadId = dm.enqueue(request)

        // Poll progress on a background thread
        Thread {
            var downloading = true
            while (downloading) {
                val query = DownloadManager.Query().setFilterById(downloadId)
                val cursor = dm.query(query)
                if (cursor != null && cursor.moveToFirst()) {
                    val bytesIdx = cursor.getColumnIndex(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR)
                    val totalIdx = cursor.getColumnIndex(DownloadManager.COLUMN_TOTAL_SIZE_BYTES)
                    val statusIdx = cursor.getColumnIndex(DownloadManager.COLUMN_STATUS)

                    val bytesDownloaded = if (bytesIdx >= 0) cursor.getLong(bytesIdx) else 0L
                    val totalBytes = if (totalIdx >= 0) cursor.getLong(totalIdx) else -1L
                    val status = if (statusIdx >= 0) cursor.getInt(statusIdx) else -1

                    if (status == DownloadManager.STATUS_SUCCESSFUL || status == DownloadManager.STATUS_FAILED) {
                        downloading = false
                    }

                    if (totalBytes > 0) {
                        val percent = ((bytesDownloaded * 100) / totalBytes).toInt()
                        val downloadedMB = String.format("%.1f", bytesDownloaded / 1_048_576.0)
                        val totalMB = String.format("%.1f", totalBytes / 1_048_576.0)

                        activity.runOnUiThread {
                            progressBar?.progress = percent
                            progressPercent?.text = "$percent%"
                            progressText?.text = "$downloadedMB MB / $totalMB MB"
                        }
                    }

                    if (status == DownloadManager.STATUS_FAILED) {
                        activity.runOnUiThread {
                            progressDialog?.dismiss()
                            Toast.makeText(context, "Falha ao transferir a actualização.", Toast.LENGTH_LONG).show()
                        }
                    }
                }
                cursor?.close()
                if (downloading) Thread.sleep(300)
            }
        }.start()

        val receiver = object : BroadcastReceiver() {
            override fun onReceive(ctx: Context, intent: Intent) {
                val id = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1)
                if (id == downloadId) {
                    ctx.unregisterReceiver(this)
                    activity.runOnUiThread {
                        progressBar?.progress = 100
                        progressPercent?.text = "100%"
                        progressText?.text = "Concluído! A instalar…"
                    }
                    // Small delay so user sees 100%
                    Thread {
                        Thread.sleep(600)
                        activity.runOnUiThread {
                            progressDialog?.dismiss()
                            installApk(ctx, fileName)
                        }
                    }.start()
                }
            }
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            context.registerReceiver(receiver, IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE), Context.RECEIVER_EXPORTED)
        } else {
            context.registerReceiver(receiver, IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE))
        }
    }

    private fun installApk(context: Context, fileName: String) {
        val file = File(context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), fileName)
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
