package com.nbs.moviecompose.data.movie.api

import com.nbs.moviecompose.data.movie.response.MovieResponse
import com.nbs.moviecompose.data.movie.response.PaginationResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiClient {
    @GET("discover/movie")
    suspend fun getPopularMovies(@Query("page") page: Int = 1): Result<PaginationResponse<MovieResponse>>
}