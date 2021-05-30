package com.example.usecase.interactor

import com.example.common.entity.Professor
import com.example.usecase.repository.ProfessorRepository
import javax.inject.Inject

class SelectProfessorUseCase @Inject constructor(
    private val professorRepository: ProfessorRepository
) {
    operator fun invoke(selectedProfessor: Professor) {
        professorRepository.setSelectedProfessor(selectedProfessor)
    }
}