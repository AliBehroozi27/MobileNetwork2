package com.example.domain.repository

import com.example.domain.model.Professor
import io.reactivex.rxjava3.core.Single

interface ProfessorRepository {

    fun getProfessors() : Single<List<Professor>>
}