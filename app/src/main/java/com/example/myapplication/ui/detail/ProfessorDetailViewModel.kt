package com.example.myapplication.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.entity.Professor
import com.example.usecase.interactor.RetrieveSelectedProfessorUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfessorDetailViewModel @Inject constructor(
    retrieveSelectedProfessorUseCase: RetrieveSelectedProfessorUseCase
): ViewModel() {

    private val _professor: MutableLiveData<Professor> = MutableLiveData()
    val professor = _professor

    init {
        // The current selectedProfessor is accessed by a stream (flow)
        // As opposed to using a ShareViewModel, The data is stored in data layer to persist
        // Through process (activity) death
        viewModelScope.launch {
            retrieveSelectedProfessorUseCase().collect { data ->
                _professor.value = data
            }
        }
    }
}