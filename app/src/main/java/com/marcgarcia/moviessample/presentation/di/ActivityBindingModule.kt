package com.marcgarcia.moviessample.presentation.di

import com.marcgarcia.moviessample.presentation.ui.movielist.TvShowListActivity
import com.marcgarcia.moviessample.presentation.ui.movielist.di.TvShowListModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [TvShowListModule::class])
    internal abstract fun provideTvShowListActivity(): TvShowListActivity
}
