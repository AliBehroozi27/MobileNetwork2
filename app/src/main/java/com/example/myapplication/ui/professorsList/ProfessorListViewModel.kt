package com.example.myapplication.ui.professorsList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.DiffUtil
import com.example.common.entity.Professor
import com.example.usecase.interactor.GetProfessorsUseCase
import com.example.myapplication.ui.util.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfessorListViewModel @Inject constructor(
    private val getProfessorProfessorsUseCase: GetProfessorsUseCase
) : ViewModel() {

    private val _professorsLiveData: MutableLiveData<List<Professor>> = MutableLiveData()
    val professorsLiveData: LiveData<List<Professor>> = _professorsLiveData

    private val _errorMessageLiveData: MutableLiveData<String> = MutableLiveData()
    val errorMessageLiveData: LiveData<String> = _errorMessageLiveData

    private val _viewStateLiveData: MutableLiveData<ViewState> = MutableLiveData()
    val viewStateLiveData: LiveData<ViewState> = _viewStateLiveData

    val diffCallback = object : DiffUtil.ItemCallback<Professor>() {
        override fun areItemsTheSame(oldItem: Professor, newItem: Professor): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Professor, newItem: Professor): Boolean {
            return oldItem.id == newItem.id
        }
    }

    init {
        _viewStateLiveData.value = ViewState.LOADING

        viewModelScope.launch {
            try {
                onProfessorsLoaded(getProfessorProfessorsUseCase())
            } catch (cause: Throwable) {
                onProfessorsLoadingFailed(cause)
            }
        }
    }

    private fun onProfessorsLoaded(professors: List<Professor>) {
        _professorsLiveData.value = professors

        if (professors.isEmpty()) {
            _viewStateLiveData.value = ViewState.EMPTY
        } else {
            _viewStateLiveData.value = ViewState.DATA
        }
    }

    private fun onProfessorsLoadingFailed(throwable: Throwable) {
        _errorMessageLiveData.value = throwable.message
        _viewStateLiveData.value = ViewState.ERROR
    }

    fun onProfessorSelected(professor: Professor) {

    }
}