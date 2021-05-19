package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.interactor.GetProfessorsUseCase
import com.example.domain.model.Professor
import dagger.hilt.android.lifecycle.HiltViewModel
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
        getProfessorProfessorsUseCase.execute(
            GetProfessorsUseCase.None(),
            ::onProfessorsLoaded,
            ::onProfessorsLoadingFailed
        )
    }

    private fun onProfessorsLoaded(professors: List<Professor>) {
        _professors.value = professors
    }

    private fun onProfessorsLoadingFailed(throwable: Throwable) {
        _errorMessage.value = throwable.message
    }
}