package com.example.local.datasource

import com.example.data.datasource.ProfessorLocalDataSource
import com.example.data.entity.ProfessorEntity
import com.example.local.dto.ProfessorDto
import com.example.local.mappers.toProfessorEntity
import kotlinx.coroutines.delay
import javax.inject.Inject

class ProfessorLocalDataSourceImpl @Inject constructor() : ProfessorLocalDataSource {

    override suspend fun getProfessors(): List<ProfessorEntity> {
        delay(5000)
        return listOf(
            ProfessorDto(
                name = "Sauleh Ashtiani",
                course = "Algorithms",
                imageResourcePath = "Path",
                mostRecentDegree = "Bachelors",
                studyField = "Some Field"
            ).toProfessorEntity()
        )
    }
}