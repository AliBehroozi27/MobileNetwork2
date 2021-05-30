package com.example.common.entity

data class Professor constructor(
    val id: Int,
    val name: String,
    val course: String,
    val imageUrl: String,
    val mostRecentPlaceOfStudy: String ,
    val mostRecentDegree: String
)