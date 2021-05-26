package com.example.data.datasource

import com.example.data.entity.ProfessorEntity
import io.reactivex.rxjava3.core.Single

interface ProfessorLocalDataSource {
    fun getProfessors() : Single<List<ProfessorEntity>>
}