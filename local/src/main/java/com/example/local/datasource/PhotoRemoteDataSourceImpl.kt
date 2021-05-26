package com.example.local.datasource

import com.example.data.datasource.ProfessorLocalDataSource
import com.example.data.entity.ProfessorEntity
import com.example.local.dto.ProfessorDto
import com.example.local.mappers.toProfessorEntity
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class ProfessorLocalDataSourceImpl @Inject constructor() : ProfessorLocalDataSource {

    override fun getProfessors(): Single<List<ProfessorEntity>> {
        return Single.just(
            listOf(
                ProfessorDto(
                    name = "Sauleh Ashtiani",
                    course = "Algorithms",
                    imageResourcePath = "Path",
                    mostRecentDegree = "Bachelors",
                    studyField = "Some Field"
                ).toProfessorEntity()
            )
        )
    }
}