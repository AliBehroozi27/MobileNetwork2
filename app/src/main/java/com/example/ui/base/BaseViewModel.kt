package com.example.ui.base

import androidx.lifecycle.ViewModel
import com.example.domain.interactor.base.UseCase

abstract class BaseViewModel : ViewModel() {

    protected val useCases = mutableListOf<UseCase>()

    override fun onCleared() {
        useCases.forEach { useCases ->
            useCases.dispose()
        }
        super.onCleared()
    }
}