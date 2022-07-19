package com.nbs.moviecompose.data.base

data class ApiError(
    val errorCode: String,
    val errorMessage: String,
    val status: Boolean
): Exception()