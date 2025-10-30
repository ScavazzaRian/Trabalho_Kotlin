package com.example.trabalho.model

data class Exercise(
    val id: Int,
    val titulo: String,
    val imagemResId: Int,
    val audioResId: Int,
    val passos: List<String>,
    val tempo: Int
)