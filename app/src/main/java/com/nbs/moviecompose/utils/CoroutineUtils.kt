package com.nbs.moviecompose.utils

import com.nbs.moviecompose.data.base.Model
import com.nbs.moviecompose.data.base.Resource

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