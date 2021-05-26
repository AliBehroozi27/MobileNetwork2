package com.example.app.executor

import com.example.domain.executor.UseCaseExecutorThread
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers

class BackgroundThread : UseCaseExecutorThread {
    override val scheduler: Scheduler
        get() = Schedulers.io()
}