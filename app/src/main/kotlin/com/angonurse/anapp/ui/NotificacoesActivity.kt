package com.angonurse.anapp.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.angonurse.anapp.R
import com.angonurse.anapp.databinding.ActivityNotificacoesBinding
import org.json.JSONArray
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.*

class NotificacoesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNotificacoesBinding
    private val notifications = mutableListOf<JSONObject>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotificacoesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener { finish() }

        // Handle notification from background tap (FCM extras)
        handleIncomingIntent(intent)

        loadNotifications()

        binding.btnClearAll.setOnClickListener {
            val prefs = getSharedPreferences("notifications", MODE_PRIVATE)
            prefs.edit().putString("list", "[]").apply()
            notifications.clear()
            updateUI()
        }

        binding.rvNotificacoes.layoutManager = LinearLayoutManager(this)
        updateUI()
    }

    private fun loadNotifications() {
        val prefs = getSharedPreferences("notifications", MODE_PRIVATE)
        val json = prefs.getString("list", "[]") ?: "[]"
        try {
            val arr = JSONArray(json)
            notifications.clear()
            for (i in 0 until arr.length()) {
                notifications.add(arr.getJSONObject(i))
            }
            // Most recent first
            notifications.sortByDescending { it.optLong("timestamp", 0) }
        } catch (_: Exception) {}
    }

    private fun saveNotifications() {
        val arr = JSONArray()
        notifications.forEach { arr.put(it) }
        getSharedPreferences("notifications", MODE_PRIVATE)
            .edit().putString("list", arr.toString()).apply()
    }

    private fun updateUI() {
        if (notifications.isEmpty()) {
            binding.emptyState.visibility = View.VISIBLE
            binding.rvNotificacoes.visibility = View.GONE
        } else {
            binding.emptyState.visibility = View.GONE
            binding.rvNotificacoes.visibility = View.VISIBLE
            binding.rvNotificacoes.adapter = NotificacoesAdapter()
        }
    }

    inner class NotificacoesAdapter : RecyclerView.Adapter<NotificacoesAdapter.VH>() {
        inner class VH(view: View) : RecyclerView.ViewHolder(view) {
            val tvTitle: TextView = view.findViewById(R.id.tvTitle)
            val tvBody: TextView = view.findViewById(R.id.tvBody)
            val tvTime: TextView = view.findViewById(R.id.tvTime)
            val viewUnread: View = view.findViewById(R.id.viewUnread)
            val btnDelete: ImageButton = view.findViewById(R.id.btnDelete)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_notificacao, parent, false)
            return VH(view)
        }

        override fun onBindViewHolder(holder: VH, position: Int) {
            val n = notifications[position]
            holder.tvTitle.text = n.optString("title", "AnApp")
            holder.tvBody.text = n.optString("body", "")

            val ts = n.optLong("timestamp", 0)
            val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())
            holder.tvTime.text = if (ts > 0) sdf.format(Date(ts)) else ""

            val read = n.optBoolean("read", false)
            holder.viewUnread.visibility = if (read) View.GONE else View.VISIBLE

            holder.itemView.setOnClickListener {
                n.put("read", true)
                saveNotifications()
                notifyItemChanged(position)
            }

            holder.btnDelete.setOnClickListener {
                notifications.removeAt(position)
                saveNotifications()
                updateUI()
            }
        }

        override fun getItemCount() = notifications.size
    }

    private fun handleIncomingIntent(intent: Intent?) {
        val title = intent?.getStringExtra("fcm_title") ?: intent?.getStringExtra("title")
        val body = intent?.getStringExtra("fcm_body") ?: intent?.getStringExtra("body")
        if (!title.isNullOrBlank() && !body.isNullOrBlank()) {
            addNotification(this, title, body)
            // Clear to avoid re-adding on config change
            intent?.removeExtra("fcm_title")
            intent?.removeExtra("fcm_body")
            intent?.removeExtra("title")
            intent?.removeExtra("body")
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        handleIncomingIntent(intent)
        loadNotifications()
        updateUI()
    }

    companion object {
        fun addNotification(context: android.content.Context, title: String, body: String) {
            val prefs = context.getSharedPreferences("notifications", MODE_PRIVATE)
            val json = prefs.getString("list", "[]") ?: "[]"
            val arr = try { JSONArray(json) } catch (_: Exception) { JSONArray() }
            val obj = JSONObject().apply {
                put("title", title)
                put("body", body)
                put("timestamp", System.currentTimeMillis())
                put("read", false)
            }
            arr.put(obj)
            prefs.edit().putString("list", arr.toString()).apply()
        }

        fun getUnreadCount(context: android.content.Context): Int {
            val prefs = context.getSharedPreferences("notifications", MODE_PRIVATE)
            val json = prefs.getString("list", "[]") ?: "[]"
            return try {
                val arr = JSONArray(json)
                var count = 0
                for (i in 0 until arr.length()) {
                    if (!arr.getJSONObject(i).optBoolean("read", false)) count++
                }
                count
            } catch (_: Exception) { 0 }
        }
    }
}
