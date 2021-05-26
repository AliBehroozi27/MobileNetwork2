package com.example.domain.repository

import com.example.domain.model.Professor

interface ProfessorRepository {

    suspend fun getProfessors() : List<Professor>
}