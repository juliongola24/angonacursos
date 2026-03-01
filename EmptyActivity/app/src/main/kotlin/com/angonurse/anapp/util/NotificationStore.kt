package com.angonurse.anapp.util

import android.content.Context
import com.angonurse.anapp.data.AppNotification
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.text.SimpleDateFormat
import java.util.*

object NotificationStore {
    private const val PREFS_NAME = "app_notifications"
    private const val KEY_LIST = "notification_list"
    private val gson = Gson()
    private val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())

    fun save(context: Context, title: String, body: String) {
        val list = getAll(context).toMutableList()
        list.add(0, AppNotification(
            id = UUID.randomUUID().toString(),
            title = title,
            body = body,
            receivedAt = dateFormat.format(Date()),
            isRead = false
        ))
        persist(context, list)
    }

    fun getAll(context: Context): List<AppNotification> {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val json = prefs.getString(KEY_LIST, null) ?: return emptyList()
        return try {
            val type = object : TypeToken<List<AppNotification>>() {}.type
            gson.fromJson(json, type)
        } catch (e: Exception) {
            emptyList()
        }
    }

    fun markAllAsRead(context: Context) {
        val list = getAll(context).map { it.copy(isRead = true) }
        persist(context, list)
    }

    fun delete(context: Context, id: String) {
        val list = getAll(context).filter { it.id != id }
        persist(context, list)
    }

    fun clearAll(context: Context) {
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            .edit().remove(KEY_LIST).apply()
    }

    fun unreadCount(context: Context): Int {
        return getAll(context).count { !it.isRead }
    }

    private fun persist(context: Context, list: List<AppNotification>) {
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            .edit().putString(KEY_LIST, gson.toJson(list)).apply()
    }
}
