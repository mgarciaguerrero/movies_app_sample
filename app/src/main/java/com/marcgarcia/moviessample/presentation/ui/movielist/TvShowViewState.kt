package com.marcgarcia.moviessample.presentation.ui.movielist

sealed class TvShowViewState {

    object Loading : TvShowViewState()

    data class PopularMovies(val movies: List<TvShowViewEntity>) : TvShowViewState()

    object Error : TvShowViewState()
}
