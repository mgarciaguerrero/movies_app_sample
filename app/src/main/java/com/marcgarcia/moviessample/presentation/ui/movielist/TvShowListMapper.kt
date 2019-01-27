package com.marcgarcia.moviessample.presentation.ui.movielist

import com.marcgarcia.moviessample.domain.model.TvShow
import javax.inject.Inject

class TvShowListMapper @Inject constructor() {

    fun transform(tvShow: TvShow) = TvShowViewEntity(
        id = tvShow.id,
        title = tvShow.title,
        poster = tvShow.poster
    )
}
