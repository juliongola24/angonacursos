package com.angonurse.anapp.util

import android.content.Context
import com.angonurse.anapp.data.ResultRecord
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.text.SimpleDateFormat
import java.util.*

object ResultHistory {
    private const val PREFS_NAME = "exam_results"
    private const val KEY_HISTORY = "exam_result_history"
    private val gson = Gson()

    fun getHistory(context: Context): List<ResultRecord> {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val json = prefs.getString(KEY_HISTORY, null) ?: return emptyList()
        return try {
            val type = object : TypeToken<List<ResultRecord>>() {}.type
            gson.fromJson(json, type)
        } catch (e: Exception) {
            emptyList()
        }
    }

    fun saveResult(context: Context, participantName: String, percentage: String, correctCount: Int, totalQuestions: Int) {
        val history = getHistory(context).toMutableList()
        val record = ResultRecord(
            id = UUID.randomUUID().toString(),
            participantName = participantName,
            percentage = percentage,
            correctCount = correctCount,
            totalQuestions = totalQuestions,
            date = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault()).format(Date())
        )
        history.add(0, record)
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        prefs.edit().putString(KEY_HISTORY, gson.toJson(history)).apply()
    }

    fun clearHistory(context: Context) {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        prefs.edit().remove(KEY_HISTORY).apply()
    }
}
