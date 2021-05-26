package com.example.data.datasource

import com.example.data.entity.ProfessorEntity

interface ProfessorLocalDataSource {
    suspend fun getProfessors() : List<ProfessorEntity>
}