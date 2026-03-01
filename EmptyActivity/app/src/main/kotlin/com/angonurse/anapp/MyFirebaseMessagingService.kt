package com.angonurse.anapp

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.angonurse.anapp.util.NotificationStore
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        val title = remoteMessage.notification?.title ?: remoteMessage.data["title"] ?: "Teste Online"
        val body = remoteMessage.notification?.body ?: remoteMessage.data["body"] ?: ""

        // Armazenar no SharedPreferences
        NotificationStore.save(applicationContext, title, body)

        // Mostrar notificação do sistema
        showSystemNotification(title, body)
    }

    override fun onNewToken(token: String) {
        // Pode enviar o token para o servidor se necessário
    }

    private fun showSystemNotification(title: String, body: String) {
        val channelId = "angonurse_notifications"
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                "Notificações",
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "Notificações do Teste Online"
            }
            notificationManager.createNotificationChannel(channel)
        }

        val intent = Intent(this, NotificationsActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
        }
        val pendingIntent = PendingIntent.getActivity(
            this, 0, intent,
            PendingIntent.FLAG_ONE_SHOT or PendingIntent.FLAG_IMMUTABLE
        )

        val notification = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle(title)
            .setContentText(body)
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .build()

        notificationManager.notify(System.currentTimeMillis().toInt(), notification)
    }
}
