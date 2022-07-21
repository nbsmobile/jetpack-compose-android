package com.nbs.moviecompose.data.movie.api

import com.nbs.moviecompose.data.movie.response.MovieResponse
import com.nbs.moviecompose.data.movie.response.PaginationResponse
import com.nbs.moviecompose.utils.call

class MovieApi(private val apiClient: MovieApiClient) {
    suspend fun getPopularMovies(): PaginationResponse<MovieResponse> {
        return call {
            apiClient.getPopularMovies()
        }
    }

    suspend fun getNowPlayingMovies(): PaginationResponse<MovieResponse> {
        return call {
            apiClient.getNowPlayingMovies()
        }
    }
}