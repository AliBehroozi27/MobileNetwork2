package com.example.data.repository

import com.example.data.datasource.ProfessorLocalDataSource
import com.example.data.mappers.toProfessor
import com.example.domain.model.Professor
import com.example.domain.repository.ProfessorRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProfessorRepositoryImpl @Inject constructor(private val professorLocalDataSource: ProfessorLocalDataSource) :
    ProfessorRepository {

    override suspend fun getProfessors(): List<Professor> = withContext(Dispatchers.IO) {
        professorLocalDataSource.getProfessors()
            .map { professorEntity -> professorEntity.toProfessor() }
    }
}