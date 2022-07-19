package com.nbs.moviecompose.domain.mapper

import com.nbs.moviecompose.data.movie.response.MovieResponse
import com.nbs.moviecompose.domain.response.Movie
import com.nbs.moviecompose.utils.orDefault
import com.nbs.moviecompose.utils.orZero

fun MovieResponse.toDomain(): Movie {
    return Movie(
        posterPath = posterPath.orEmpty(),
        video = video.orDefault(false),
        overview = overview.orEmpty(),
        popularity = popularity.orZero(),
        adult = adult.orDefault(false),
        originalTitle = originalTitle.orEmpty(),
        id = id.orZero(),
        backdropPath = backdropPath.orEmpty(),
        genreIds = genreIds.orEmpty(),
        voteCount = voteCount.orZero(),
        title = title.orEmpty(),
        voteAverage = voteAverage.orZero(),
        originalLanguage = originalLanguage.orEmpty(),
        releaseDate = releaseDate.orEmpty()
    )
}