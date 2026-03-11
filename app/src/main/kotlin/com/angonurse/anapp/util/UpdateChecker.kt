package com.angonurse.anapp.util

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.coroutines.*
import org.json.JSONObject
import java.net.URL

class UpdateChecker(private val activity: Activity) {

    companion object {
        private const val VERSION_URL =
            "https://angonurse.vercel.app/downloads/anapp-update.json"
    }

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

    private fun showUpdateDialog(version: String, url: String) {
        AlertDialog.Builder(activity)
            .setTitle("Nova versão disponível")
            .setMessage("Existe uma nova versão do aplicativo.\n\nVersão: $version")
            .setPositiveButton("Actualizar") { _, _ ->
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                activity.startActivity(intent)
            }
            .setNegativeButton("Mais tarde", null)
            .show()
    }
}
