package com.example.myapplication.ui.home

import androidx.lifecycle.*
import androidx.recyclerview.widget.DiffUtil
import com.example.common.entity.Professor
import com.example.myapplication.ui.util.SingleLiveEvent
import com.example.usecase.interactor.GetProfessorsUseCase
import com.example.myapplication.ui.util.ViewState
import com.example.usecase.interactor.SelectProfessorUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfessorListViewModel @Inject constructor(
    private val getProfessorProfessorsUseCase: GetProfessorsUseCase,
    private val selectProfessorUseCase: SelectProfessorUseCase
) : ViewModel() {

    private val _professorsLiveData: MutableLiveData<List<Professor>> = MutableLiveData()
    val professorsLiveData: LiveData<List<Professor>> = _professorsLiveData

    private val _errorMessageLiveData: MutableLiveData<String> = MutableLiveData()
    val errorMessageLiveData: LiveData<String> = _errorMessageLiveData

    private val _viewStateLiveData: MutableLiveData<ViewState> = MutableLiveData()
    val viewStateLiveData: LiveData<ViewState> = _viewStateLiveData

    private val _navigationAction: SingleLiveEvent<NavigationAction> = SingleLiveEvent()
    val navigationAction: LiveData<NavigationAction> = _navigationAction

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
        selectProfessorUseCase(professor).also {
            _navigationAction.value = NavigationAction.NavigateProfessorDetail
        }
    }

    sealed class NavigationAction {
        object NavigateProfessorDetail : NavigationAction()
    }
}