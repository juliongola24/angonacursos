package com.angonurse.anapp.data

data class ResultRecord(
    val id: String,
    val participantName: String,
    val percentage: String,
    val correctCount: Int,
    val totalQuestions: Int,
    val date: String
)
