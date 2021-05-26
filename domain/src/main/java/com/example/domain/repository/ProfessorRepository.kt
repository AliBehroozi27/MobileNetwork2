package com.example.domain.repository

import com.example.common.entity.Professor

interface ProfessorRepository {

    suspend fun getProfessors() : List<Professor>
}