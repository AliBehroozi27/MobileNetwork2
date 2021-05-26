package com.example.domain.interactor.base

import com.example.domain.executor.PostExecutorThread
import com.example.domain.executor.UseCaseExecutorThread
import io.reactivex.rxjava3.core.Single

abstract class SingleUseCase<in Params, Result>(
    private val useCaseExecutorThread: UseCaseExecutorThread,
    private val postExecutorThread: PostExecutorThread
) : UseCase() {

    abstract fun buildSingle(params: Params): Single<Result>

    fun execute(
        params: Params,
        success: (Result) -> Unit,
        failure: (Throwable) -> Unit
    ) {
        buildSingle(params)
            .observeOn(postExecutorThread.scheduler)
            .subscribeOn(useCaseExecutorThread.scheduler)
            .subscribe({
                success(it)
            }, {
                failure(it)
            }).also {
                add(it)
            }
    }

}