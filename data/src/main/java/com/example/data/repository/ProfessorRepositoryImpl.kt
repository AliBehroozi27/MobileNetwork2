package com.example.data.repository

import com.example.common.entity.Professor
import com.example.data.datasource.ProfessorLocalDataSource
import com.example.domain.repository.ProfessorRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProfessorRepositoryImpl @Inject constructor(private val professorLocalDataSource: ProfessorLocalDataSource) :
    ProfessorRepository {

    override suspend fun getProfessors(): List<Professor> = withContext(Dispatchers.IO) {
        professorLocalDataSource.getProfessors()
    }
}