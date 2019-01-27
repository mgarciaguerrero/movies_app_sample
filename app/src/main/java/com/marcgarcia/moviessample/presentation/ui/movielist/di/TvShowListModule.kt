package com.marcgarcia.moviessample.presentation.ui.movielist.di

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.marcgarcia.moviessample.presentation.ui.movielist.TvShowListActivity
import com.marcgarcia.moviessample.presentation.ui.movielist.TvShowListViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class TvShowListModule {

    @Binds
    abstract fun provideActivity(activity: TvShowListActivity): AppCompatActivity

    @Module
    companion object {

        @JvmStatic
        @Provides
        fun providesViewModel(activity: AppCompatActivity, factory: ViewModelProvider.Factory) =
            ViewModelProviders.of(activity, factory).get(TvShowListViewModel::class.java)
    }
}
