package com.example.data.repository

import com.example.data.datasource.ProfessorLocalDataSource
import com.example.data.mappers.toProfessor
import com.example.domain.model.Professor
import com.example.domain.repository.ProfessorRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class ProfessorRepositoryImpl @Inject constructor(private val professorLocalDataSource: ProfessorLocalDataSource) :
    ProfessorRepository {
    override fun getProfessors(): Single<List<Professor>> {
        return professorLocalDataSource.getProfessors().map { items ->
            items.map { professorEntity ->
                professorEntity.toProfessor()
            }
        }
    }
}