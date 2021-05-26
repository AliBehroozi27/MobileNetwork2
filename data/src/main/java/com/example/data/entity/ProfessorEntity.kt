package com.example.data.entity

data class ProfessorEntity(
    val name: String,
    val course: String,
    val imageResourcePath: String, // In an online app use imageUrl instead
    val mostRecentDegree: String,
    val studyField: String
)