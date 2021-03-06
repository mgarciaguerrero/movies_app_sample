package com.marcgarcia.moviessample.data.source.movies.network.endpoint

import com.marcgarcia.moviessample.data.source.movies.network.entity.PopularTvShowsApiResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface TvShowsService {

    private companion object {
        private const val PATH_POPULAR_SHOWS = "/3/tv/popular"
        private const val PARAM_API_KEY = "api_key"
        private const val PARAM_PAGE = "page"
    }

    @GET(PATH_POPULAR_SHOWS)
    fun getPopularShows(
        @Query(PARAM_API_KEY) apiKey: String,
        @Query(PARAM_PAGE) page: Int
    ): Single<PopularTvShowsApiResponse>
}
