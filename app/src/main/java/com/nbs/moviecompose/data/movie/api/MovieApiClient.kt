package com.nbs.moviecompose.data.movie.api

import com.nbs.moviecompose.data.movie.response.MovieResponse
import com.nbs.moviecompose.data.movie.response.PaginationResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiClient {
    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("page") page: Int = 1): Result<PaginationResponse<MovieResponse>>

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(@Query("page") page: Int = 1): Result<PaginationResponse<MovieResponse>>
}