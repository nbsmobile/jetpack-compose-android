package com.nbs.moviecompose.domain.response

import android.os.Parcelable
import com.nbs.moviecompose.utils.emptyString
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    var posterPath: String,
    var video: Boolean,
    var overview: String,
    var popularity: Double,
    var adult: Boolean,
    var originalTitle: String,
    var id: Long,
    var backdropPath: String,
    var genreIds: List<Int>,
    var voteCount: Int,
    var title: String,
    var voteAverage: Double,
    var originalLanguage: String,
    var releaseDate: String
) : Parcelable{
    companion object {
        fun dummy() = Movie(
            emptyString(),
            false,
            emptyString(),
            0.0,
            false,
            emptyString(),
            0L,
            emptyString(),
            listOf(),
            0,
            emptyString(),
            0.0,
            emptyString(),
            emptyString()
        )
    }
}