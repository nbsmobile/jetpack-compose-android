package com.nbs.moviecompose.data.movie.response

import com.google.gson.annotations.SerializedName

data class PaginationResponse<T>(
    @SerializedName("total_pages")
    var totalPages: Long?,
    @SerializedName("page")
    var page: Int?,
    @SerializedName("total_results")
    var totalResults: Long?,
    @SerializedName("results")
    var results: List<T>
)
