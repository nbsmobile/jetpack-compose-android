package com.nbs.moviecompose.data.base

sealed class Resource<out T> {
    data class Loading<out T>(val loading: Boolean) : Resource<T>()
    data class Success<out T>(val data: T) : Resource<T>()
    data class Error<out T>(val throwable: Throwable, val message: String) : Resource<T>()
    data class Init<out T>(val new: Boolean) : Resource<T>()
    class Empty<out T> : Resource<T>()

    companion object {
        fun <T> loading(): Resource<T> = Loading(true)
        fun <T> success(data: T): Resource<T> = Success(data)
        fun <R> error(throwable: Throwable, message: String): Resource<R> =
            Error(throwable, message)
        fun <T> init(): Resource<T> = Init(true)
        fun <T> empty(): Resource<T> = Empty()
    }
}