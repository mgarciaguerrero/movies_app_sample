package com.marcgarcia.moviessample.presentation.ui.movielist

import com.marcgarcia.moviessample.presentation.ui.common.BaseNavigator

sealed class TvShowListNavigator : BaseNavigator {

    object Detail : TvShowListNavigator()
}
