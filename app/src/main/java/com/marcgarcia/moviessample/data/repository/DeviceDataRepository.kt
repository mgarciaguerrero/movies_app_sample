package com.marcgarcia.moviessample.data.repository

import com.marcgarcia.moviessample.data.source.device.DeviceDataSource
import com.marcgarcia.moviessample.domain.repository.DeviceRepository
import io.reactivex.Single

class DeviceDataRepository constructor(deviceDataSource: DeviceDataSource) : DeviceRepository {

    override fun getLanguageCode(): Single<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
