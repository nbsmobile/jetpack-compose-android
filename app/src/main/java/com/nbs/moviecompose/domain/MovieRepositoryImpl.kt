package com.nbs.moviecompose.domain

import com.nbs.moviecompose.data.base.Resource
import com.nbs.moviecompose.data.movie.api.MovieApi
import com.nbs.moviecompose.domain.mapper.toDomain
import com.nbs.moviecompose.domain.response.Movie
import com.nbs.moviecompose.utils.execute

class MovieRepositoryImpl(private val api: MovieApi) : MovieRepository {
    override suspend fun getPopularMovies(): Resource<List<Movie>> {
        return execute {
            api.getPopularMovies().results.map {
                it.toDomain()
            }
        }
    }

    override suspend fun getNowPlayingMovies(): Resource<List<Movie>> {
        return execute {
            api.getNowPlayingMovies().results.map {
                it.toDomain()
            }
        }
    }
}