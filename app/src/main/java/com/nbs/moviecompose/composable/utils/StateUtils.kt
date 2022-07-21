package com.nbs.moviecompose.composable.utils

import android.accounts.AccountManager
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import com.nbs.moviecompose.R
import com.nbs.moviecompose.data.base.ApiError
import com.nbs.moviecompose.data.base.ErrorCodes
import com.nbs.moviecompose.data.base.Resource
import com.nbs.moviecompose.utils.ContextProvider
import com.nbs.moviecompose.utils.emptyString
import org.koin.core.component.inject
import org.koin.java.KoinJavaComponent.inject
import retrofit2.HttpException

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
                    ContextProvider.instance.get().getString(R.string.error_no_connection),
                    status = false
                )
            )
        }
        else -> {
            observer.invoke(
                ApiError(
                    ErrorCodes.ERROR_UNABLE_TO_REACH_SERVICE,
                    ContextProvider.instance.get().getString(R.string.error_unable_to_connect),
                    status = false
                )
            )
        }
    }
}

@Composable
inline fun <reified T> ComposableObserver(
    state: State<Resource<T>?>,
    onLoading : @Composable () -> Unit,
    onSuccess: @Composable (T) -> Unit,
    onFailure: @Composable (String) -> Unit
) {
    when (state.value as Resource<T>) {
        is Resource.Loading -> {
            onLoading.invoke()
        }
        is Resource.Success -> {
            onSuccess.invoke(getValue(state.value))
        }
        is Resource.Error -> {
            onFailure.invoke(getErrorMessage(state.value))
        }
        else -> {}
    }
}