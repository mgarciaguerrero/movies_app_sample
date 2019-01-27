package com.marcgarcia.moviessample.domain.repository

import com.marcgarcia.moviessample.domain.model.TvShow
import io.reactivex.Single

interface PopularShowsRepository {

    fun getPopularShows(page: Int, languageCode: String): Single<List<TvShow>>
}
