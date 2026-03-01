package com.angonurse.anapp.data

data class AppNotification(
    val id: String,
    val title: String,
    val body: String,
    val receivedAt: String,
    var isRead: Boolean = false
)
