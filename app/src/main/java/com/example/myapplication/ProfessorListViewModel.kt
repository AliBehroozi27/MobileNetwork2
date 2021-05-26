package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.interactor.GetProfessorsUseCase
import com.example.domain.model.Professor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ProfessorListViewModel @Inject constructor(
    private val getProfessorProfessorsUseCase: GetProfessorsUseCase
) : ViewModel() {

    private val _professors: MutableLiveData<List<Professor>> = MutableLiveData()
    val professors: LiveData<List<Professor>> = _professors

    private val _errorMessage: MutableLiveData<String> = MutableLiveData()
    val errorMessage: LiveData<String> = _errorMessage

    init {
        viewModelScope.launch {
            try {
                onProfessorsLoaded(getProfessorProfessorsUseCase())
            } catch (cause: Throwable) {
                onProfessorsLoadingFailed(cause)
            }
        }
    }

    private fun onProfessorsLoaded(professors: List<Professor>) {
        _professors.value = professors
    }

    private fun onProfessorsLoadingFailed(throwable: Throwable) {
        _errorMessage.value = throwable.message
    }
}