package com.example.local.mappers

import com.example.local.dto.ProfessorDto
import com.example.data.entity.ProfessorEntity

fun ProfessorDto.toProfessorEntity() : ProfessorEntity {
    return ProfessorEntity(
        name = name,
        course = course,
        imageResourcePath = imageResourcePath,
        mostRecentDegree = mostRecentDegree,
        studyField = studyField
    )
}