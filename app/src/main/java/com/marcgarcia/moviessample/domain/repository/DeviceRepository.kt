package com.marcgarcia.moviessample.domain.repository

import io.reactivex.Single

interface DeviceRepository {

    fun getLanguageCode(): Single<String>
}
