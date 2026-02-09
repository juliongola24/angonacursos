package com.angonurse.anapp.data

data class Question(
    val id: Int,
    val question: String,
    val options: List<String>,
    val correctAnswer: String
)
