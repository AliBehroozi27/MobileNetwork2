package com.example.usecase.interactor

import com.example.common.entity.Professor
import com.example.usecase.repository.ProfessorRepository
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class RetrieveSelectedProfessorUseCase @Inject constructor(
    private val professorRepository: ProfessorRepository
) {
    operator fun invoke(): StateFlow<Professor?> = professorRepository.selectedProfessor
}