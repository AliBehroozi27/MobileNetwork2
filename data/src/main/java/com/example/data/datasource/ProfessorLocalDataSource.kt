package com.example.data.datasource

import com.example.common.entity.Professor

interface ProfessorLocalDataSource {
    suspend fun getProfessors() : List<Professor>
}