package com.example.app.executor

import com.example.domain.executor.PostExecutorThread
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler

class MainThread : PostExecutorThread {
    override val scheduler: Scheduler
        get() = AndroidSchedulers.mainThread()
}