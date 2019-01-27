package com.marcgarcia.moviessample.domain.common

interface BaseUseCase<I : Any, O : Any> {

    fun build(params: I): O
}
