package com.marcgarcia.moviessample.data.repository

import com.marcgarcia.moviessample.data.source.movies.network.TvShowsApiDataSource
import com.marcgarcia.moviessample.domain.model.TvShow
import com.marcgarcia.moviessample.domain.repository.PopularShowsRepository
import io.reactivex.Single

class TvShowsDataRepository constructor(
    private val tvShowsApiDataSource: TvShowsApiDataSource
) : PopularShowsRepository {

    override fun getPopularShows(page: Int, languageCode: String): Single<List<TvShow>> {
        return tvShowsApiDataSource.getPopularShows(page)
    }
}
