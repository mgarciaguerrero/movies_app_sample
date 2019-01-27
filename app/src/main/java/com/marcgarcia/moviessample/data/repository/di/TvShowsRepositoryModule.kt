package com.marcgarcia.moviessample.data.repository.di

import com.marcgarcia.moviessample.data.repository.TvShowsDataRepository
import com.marcgarcia.moviessample.data.source.movies.network.TvShowsApiDataSource
import com.marcgarcia.moviessample.data.source.movies.network.endpoint.TvShowsService
import com.marcgarcia.moviessample.domain.repository.PopularShowsRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class TvShowsRepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(
        popularShowsApiDataSource: TvShowsApiDataSource
    ): PopularShowsRepository {
        return TvShowsDataRepository(popularShowsApiDataSource)
    }

    @Provides
    fun provideService(retrofit: Retrofit): TvShowsService {
        return retrofit.create(TvShowsService::class.java)
    }
}

