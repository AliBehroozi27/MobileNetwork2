package com.example.domain.interactor

import com.example.common.entity.Professor
import com.example.domain.repository.ProfessorRepository
import javax.inject.Inject

class GetProfessorsUseCase @Inject constructor(
    private val professorRepository: ProfessorRepository
) {
    suspend operator fun invoke(): List<Professor> {
        return professorRepository.getProfessors()
    }
}