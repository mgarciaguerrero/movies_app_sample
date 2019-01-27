package com.marcgarcia.moviessample.data.source.movies.network

import com.marcgarcia.moviessample.data.source.movies.network.endpoint.TvShowsService
import com.marcgarcia.moviessample.data.source.movies.network.mapper.PopularTvShowsApiMapper
import com.marcgarcia.moviessample.domain.model.TvShow
import io.reactivex.Single
import javax.inject.Inject

class TvShowsApiDataSource @Inject constructor(
    private val service: TvShowsService,
    private val apiShowsMapper: PopularTvShowsApiMapper
) {

    private companion object {

        // https://developers.themoviedb.org/3/tv/get-popular-tv-shows
        // TODO: add api key
        private const val API_KEY = "null"
    }

    fun getPopularShows(page: Int): Single<List<TvShow>> =
        service.getPopularShows(API_KEY, page).map(apiShowsMapper::map)
}
