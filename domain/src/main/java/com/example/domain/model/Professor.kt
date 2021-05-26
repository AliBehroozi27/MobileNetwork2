package com.example.domain.model

data class Professor(
    val name: String,
    val course: String,
    val imageResourcePath: String, // In an online app use imageUrl instead
    val mostRecentDegree: String,
    val studyField: String
)