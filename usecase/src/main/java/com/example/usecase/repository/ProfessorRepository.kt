package com.example.usecase.repository

import com.example.common.entity.Professor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class ProfessorRepository() {

    private val _selectedProfessor: MutableStateFlow<Professor?> = MutableStateFlow(null)
    val selectedProfessor: StateFlow<Professor?> = _selectedProfessor

    fun setSelectedProfessor(professor: Professor) {
        _selectedProfessor.value = professor
    }

    abstract suspend fun getProfessors() : List<Professor>
}