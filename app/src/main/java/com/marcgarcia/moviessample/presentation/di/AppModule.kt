package com.marcgarcia.moviessample.presentation.di

import android.app.Application
import android.content.Context
import com.marcgarcia.moviessample.domain.common.SchedulerProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
abstract class AppModule {

    @Binds
    internal abstract fun bindContext(application: Application): Context

    @Module
    companion object {

        @JvmStatic
        @Provides
        @Singleton
        fun providesAppSchedulers() = SchedulerProvider()
    }

}
