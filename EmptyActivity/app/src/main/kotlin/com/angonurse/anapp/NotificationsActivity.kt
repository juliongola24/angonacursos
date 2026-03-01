package com.angonurse.anapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.angonurse.anapp.adapter.NotificationAdapter
import com.angonurse.anapp.databinding.ActivityNotificationsBinding
import com.angonurse.anapp.util.NotificationStore
import com.angonurse.anapp.util.PrefsManager
import com.angonurse.anapp.util.SoundManager

class NotificationsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNotificationsBinding
    private lateinit var adapter: NotificationAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        PrefsManager.applyTheme(this)
        super.onCreate(savedInstanceState)
        binding = ActivityNotificationsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        SoundManager.init(this)

        adapter = NotificationAdapter(mutableListOf()) { notification ->
            SoundManager.playClick()
            NotificationStore.delete(this, notification.id)
            refreshList()
        }

        binding.rvNotifications.layoutManager = LinearLayoutManager(this)
        binding.rvNotifications.adapter = adapter

        binding.btnBack.setOnClickListener {
            SoundManager.playClick()
            finish()
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        }

        binding.btnClearAll.setOnClickListener {
            SoundManager.playClick()
            AlertDialog.Builder(this)
                .setTitle(R.string.clear_notifications_title)
                .setMessage(R.string.clear_notifications_desc)
                .setPositiveButton(R.string.delete_all) { _, _ ->
                    NotificationStore.clearAll(this)
                    refreshList()
                }
                .setNegativeButton(R.string.cancel, null)
                .show()
        }

        // Marcar todas como lidas ao abrir
        NotificationStore.markAllAsRead(this)
        refreshList()
    }

    private fun refreshList() {
        val list = NotificationStore.getAll(this)
        val count = list.size

        if (count == 0) {
            binding.emptyState.visibility = View.VISIBLE
            binding.rvNotifications.visibility = View.GONE
            binding.btnClearAll.visibility = View.GONE
            binding.tvNotifInfo.text = "Nenhuma notificação"
        } else {
            binding.emptyState.visibility = View.GONE
            binding.rvNotifications.visibility = View.VISIBLE
            binding.btnClearAll.visibility = View.VISIBLE
            binding.tvNotifInfo.text = "$count notificação(ões)"
        }

        adapter.updateItems(list)
    }
}
