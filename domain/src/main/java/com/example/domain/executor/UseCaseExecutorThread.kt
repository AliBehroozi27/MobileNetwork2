package com.example.domain.executor

import io.reactivex.rxjava3.core.Scheduler

interface UseCaseExecutorThread {
    val scheduler: Scheduler
}