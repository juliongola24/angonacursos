package com.angonurse.anapp.data

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.text.SimpleDateFormat
import java.util.*

data class ResultRecord(
    val id: String = UUID.randomUUID().toString(),
    val participantName: String,
    val percentage: String,
    val correctCount: Int,
    val totalQuestions: Int,
    val date: String = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault()).format(Date())
)

object ResultHistory {
    private const val PREFS_KEY = "exam_result_history"
    private const val DATA_KEY = "results"
    private val gson = Gson()

    fun getHistory(context: Context): List<ResultRecord> {
        val prefs = context.getSharedPreferences(PREFS_KEY, Context.MODE_PRIVATE)
        val json = prefs.getString(DATA_KEY, null) ?: return emptyList()
        val type = object : TypeToken<List<ResultRecord>>() {}.type
        return try {
            gson.fromJson(json, type)
        } catch (e: Exception) {
            emptyList()
        }
    }

    fun saveResult(context: Context, record: ResultRecord) {
        val history = getHistory(context).toMutableList()
        history.add(0, record)
        val prefs = context.getSharedPreferences(PREFS_KEY, Context.MODE_PRIVATE)
        prefs.edit().putString(DATA_KEY, gson.toJson(history)).apply()
    }

    fun clearHistory(context: Context) {
        val prefs = context.getSharedPreferences(PREFS_KEY, Context.MODE_PRIVATE)
        prefs.edit().remove(DATA_KEY).apply()
    }
}
