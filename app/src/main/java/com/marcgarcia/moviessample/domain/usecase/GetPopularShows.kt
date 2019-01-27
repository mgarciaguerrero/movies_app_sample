package com.marcgarcia.moviessample.domain.usecase

import com.marcgarcia.moviessample.domain.common.BaseUseCase
import com.marcgarcia.moviessample.domain.model.TvShow
import com.marcgarcia.moviessample.domain.repository.PopularShowsRepository
import io.reactivex.Single
import javax.inject.Inject

class GetPopularShows @Inject constructor(
    private val popularShowsRepository: PopularShowsRepository
) : BaseUseCase<Any, Single<GetPopularShows.Response>> {

    override fun build(params: Any): Single<Response> {
        return popularShowsRepository.getPopularShows(1, "en_US").map { Response(it) }
    }

    data class Response(val tvShows: List<TvShow>)
}
