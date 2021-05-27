package com.example.common.entity

data class Professor constructor(
    val id: Int,
    val name: String,
    val course: String,
    val imageResourcePath: String,
    val mostRecentDegree: String,
    val studyField: String
)