package com.marcgarcia.moviessample.domain.common

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SchedulerProvider constructor(
    val io: Scheduler = Schedulers.io(),
    val computation: Scheduler = Schedulers.computation(),
    val post: Scheduler = AndroidSchedulers.mainThread()
)
