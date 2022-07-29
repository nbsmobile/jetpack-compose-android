package com.nbs.moviecompose.composable.model

import com.nbs.moviecompose.utils.emptyString

data class FormValidationData(
    var text : String = emptyString(),
    var isError : Boolean = false,
    val errorMessage : String = emptyString(),
    val hint : String = emptyString()
)
