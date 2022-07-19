package com.nbs.moviecompose.utils

import com.nbs.moviecompose.R
import com.nbs.moviecompose.data.base.*
import retrofit2.HttpException

suspend fun <T> call(
    block: suspend () -> Result<T>
): T {
    var data: T = Model() as T
    block.invoke()
        .onSuccess {
            data = it
        }.onFailure {
            throw it
        }
    return data
}

suspend fun <T> execute(
    block: suspend () -> T
): Resource<T> {
    return try {
        Resource.success(block.invoke())
    } catch (e: Exception) {
        Resource.error(e, e.message.toString())
    }
}

inline fun <reified T> getValue(resource: Resource<T>?): T {
    val successResource = resource as Resource.Success
    return successResource.data
}

inline fun <reified T> getErrorMessage(resource: Resource<T>?): String {
    var errorMessage = emptyString()
    observeApiError(resource) {
        errorMessage = it.errorMessage
    }
    return errorMessage
}

fun <T> observeApiError(resource: Resource<T>?, observer: ((ApiError) -> Unit)) {
    val result = resource as Resource.Error

    when (result.throwable) {
        is ApiError -> {
            observer.invoke(
                result.throwable
            )
        }
        is HttpException -> {
            observer.invoke(
                ApiError(
                    ErrorCodes.ERROR_NO_CONNECTION,
                    ContextProvider.get().getString(R.string.error_no_connection),
                    status = false
                )
            )
        }
        else -> {
            observer.invoke(
                ApiError(
                    ErrorCodes.ERROR_UNABLE_TO_REACH_SERVICE,
                    ContextProvider.get().getString(R.string.error_unable_to_connect),
                    status = false
                )
            )
        }
    }
}