package com.marcgarcia.moviessample.data.source.movies.network.mapper

import com.marcgarcia.moviessample.data.source.movies.network.entity.PopularTvShowsApiResponse
import com.marcgarcia.moviessample.domain.model.TvShow
import java.net.URL
import javax.inject.Inject

class PopularTvShowsApiMapper @Inject constructor() {

    private companion object {
        // TODO: configurations might be retrieved from the configuration API
        private const val BASE_POSTER_IMAGE_URL = "https://image.tmdb.org/t/p/w154"
    }

    internal fun map(response: PopularTvShowsApiResponse): List<TvShow> {
        return response.popularShows.map { mapShow(it) }

    }

    private fun mapShow(popularShowApi: PopularTvShowsApiResponse.PopularShow): TvShow =
        with(popularShowApi) {
            TvShow(
                id = id.toString(),
                title = name,
                poster = URL("$BASE_POSTER_IMAGE_URL$posterPath")
            )
        }
}
