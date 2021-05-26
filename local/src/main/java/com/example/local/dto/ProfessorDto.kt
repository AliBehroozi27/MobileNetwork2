package com.example.local.dto

data class ProfessorDto(
    val name: String,
    val course: String,
    val imageResourcePath: String,
    val mostRecentDegree: String,
    val studyField: String
)