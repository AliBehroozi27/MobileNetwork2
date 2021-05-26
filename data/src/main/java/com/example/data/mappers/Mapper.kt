package com.example.data.mappers

import com.example.data.entity.ProfessorEntity
import com.example.domain.model.Professor

fun ProfessorEntity.toProfessor() : Professor {
    return Professor(
        name = name,
        course = course,
        imageResourcePath = imageResourcePath,
        mostRecentDegree = mostRecentDegree,
        studyField = studyField
    )
}