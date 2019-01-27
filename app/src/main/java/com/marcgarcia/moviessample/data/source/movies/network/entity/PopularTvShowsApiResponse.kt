package com.marcgarcia.moviessample.data.source.movies.network.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PopularTvShowsApiResponse(
    @Json(name = "total_pages")
    val totalPages: Int,
    @Json(name = "page")
    val page: Int,
    @Json(name = "results")
    val popularShows: List<PopularShow>
) {

    @JsonClass(generateAdapter = true)
    data class PopularShow(
        @Json(name = "id")
        val id: Int,
        @Json(name = "name")
        val name: String,
        @Json(name = "original_name")
        val originalName: String,
        @Json(name = "overview")
        val overview: String,
        @Json(name = "popularity")
        val popularity: Float,
        @Json(name = "poster_path")
        val posterPath: String,
        @Json(name = "vote_average")
        val voteAverage: Float,
        @Json(name = "vote_count")
        val voteCount: Float,
        @Json(name = "backdrop_path")
        val backdropPath: String,
        @Json(name = "first_air_date")
        val firstAirDate: String
    )
}
