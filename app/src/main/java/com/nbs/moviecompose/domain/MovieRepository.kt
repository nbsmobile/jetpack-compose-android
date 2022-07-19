package com.nbs.moviecompose.domain

import com.nbs.moviecompose.data.base.Resource
import com.nbs.moviecompose.domain.response.Movie

interface MovieRepository {
    suspend fun getPopularMovies(): Resource<List<Movie>>
}