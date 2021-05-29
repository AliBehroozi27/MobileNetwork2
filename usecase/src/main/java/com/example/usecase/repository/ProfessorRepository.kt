package com.example.usecase.repository

import com.example.common.entity.Professor

interface ProfessorRepository {

    suspend fun getProfessors() : List<Professor>
}