package com.marcgarcia.moviessample.presentation.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.marcgarcia.moviessample.presentation.ui.common.GenericViewModelFactory
import com.marcgarcia.moviessample.presentation.ui.movielist.TvShowListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: GenericViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(TvShowListViewModel::class)
    abstract fun bindMyViewModel(myViewModel: TvShowListViewModel): ViewModel
}
