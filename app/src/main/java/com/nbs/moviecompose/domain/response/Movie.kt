package com.nbs.moviecompose.domain.response

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("poster_path")
    var posterPath: String?,
    @SerializedName("video")
    var video: Boolean?,
    @SerializedName("overview")
    var overview: String?,
    @SerializedName("popularity")
    var popularity: Double?,
    @SerializedName("adult")
    var adult: Boolean?,
    @SerializedName("original_title")
    var originalTitle: String?,
    @SerializedName("id")
    var id: Long?,
    @SerializedName("backdrop_path")
    var backdropPath: String?,
    @SerializedName("genre_ids")
    var genreIds: List<Int>?,
    @SerializedName("vote_count")
    var voteCount: Int?,
    @SerializedName("title")
    var title: String?,
    @SerializedName("vote_average")
    var voteAverage: Double?,
    @SerializedName("original_language")
    var originalLanguage: String?,
    @SerializedName("release_date")
    var releaseDate: String?
)