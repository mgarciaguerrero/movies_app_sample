package com.marcgarcia.moviessample.presentation.di

import com.marcgarcia.moviessample.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
abstract class NetworkModule {

    @Module
    companion object {

        private const val BASE_URL = "https://api.themoviedb.org/"

        @JvmStatic
        @Provides
        @Singleton
        fun provideRetrofit(): Retrofit =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(provideHttpClient())
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

        private fun provideHttpClient(): OkHttpClient =
            OkHttpClient.Builder().let { builder ->
                return@let if (BuildConfig.DEBUG) {
                    val loggingInterceptor = HttpLoggingInterceptor()
                    loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
                    builder.addInterceptor(loggingInterceptor)
                } else {
                    builder
                }
            }.build()
    }

}
