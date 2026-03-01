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

    private fun downloadApk(context: Context, apkUrl: String) {
        if (apkUrl.isBlank()) {
            Toast.makeText(context, "URL de download não disponível.", Toast.LENGTH_SHORT).show()
            return
        }

        val fileName = apkUrl.substringAfterLast("/")
        val destFile = File(context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), fileName)
        if (destFile.exists()) destFile.delete()

        Toast.makeText(context, "A transferir actualização…", Toast.LENGTH_SHORT).show()

        val request = DownloadManager.Request(Uri.parse(apkUrl))
            .setTitle("Actualização do App")
            .setDescription("A transferir nova versão…")
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            .setDestinationInExternalFilesDir(context, Environment.DIRECTORY_DOWNLOADS, fileName)
            .setAllowedOverMetered(true)
            .setAllowedOverRoaming(true)

        val dm = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        val downloadId = dm.enqueue(request)

        val receiver = object : BroadcastReceiver() {
            override fun onReceive(ctx: Context, intent: Intent) {
                val id = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1)
                if (id == downloadId) {
                    ctx.unregisterReceiver(this)
                    installApk(ctx, fileName)
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
