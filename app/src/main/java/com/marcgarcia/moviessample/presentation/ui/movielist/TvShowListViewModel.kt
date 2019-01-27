package com.marcgarcia.moviessample.presentation.ui.movielist

import androidx.lifecycle.MutableLiveData
import com.marcgarcia.moviessample.domain.common.SchedulerProvider
import com.marcgarcia.moviessample.domain.usecase.GetPopularShows
import com.marcgarcia.moviessample.presentation.ui.common.BaseNavigator
import com.marcgarcia.moviessample.presentation.ui.common.BaseViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class TvShowListViewModel @Inject constructor(
    // Use cases
    private val popularShows: GetPopularShows,
    // Mappers
    private val tvShowMapper: TvShowListMapper,
    // Schedulers
    private val scheduler: SchedulerProvider
) : BaseViewModel() {

    val navigator: MutableLiveData<BaseNavigator> = MutableLiveData()
    val viewState: MutableLiveData<TvShowViewState> = MutableLiveData()

    private val disposables = CompositeDisposable()

    fun onViewReady() {
        disposables.add(
            popularShows
                .build(Any())
                .subscribeOn(scheduler.io)
                .observeOn(scheduler.post)
                .doOnSubscribe { viewState.value = TvShowViewState.Loading }
                .map { response ->
                    response.tvShows
                        .map { tvShowMapper.transform(it) }
                        .let { TvShowViewState.PopularMovies(it) }
                }
                .subscribe(
                    {
                        viewState.value = it
                    },
                    {
                        viewState.value = TvShowViewState.Error
                    })
        )
    }

    override fun onCleared() {
        disposables.dispose()
        super.onCleared()
    }
}
