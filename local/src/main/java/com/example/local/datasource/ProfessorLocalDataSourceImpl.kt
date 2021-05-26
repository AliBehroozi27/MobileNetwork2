package com.example.local.datasource

import com.example.common.entity.Professor
import com.example.data.datasource.ProfessorLocalDataSource
import kotlinx.coroutines.delay
import javax.inject.Inject

class ProfessorLocalDataSourceImpl @Inject constructor() : ProfessorLocalDataSource {

    override suspend fun getProfessors(): List<Professor> {
        delay(5000)
        return listOf(
            Professor(
                name = "Sauleh Ashtiani",
                course = "Algorithms",
                imageResourcePath = "Path",
                mostRecentDegree = "Bachelors",
                studyField = "Some Field"
            )
        )
    }
}