package com.nbs.moviecompose.di

import com.nbs.moviecompose.data.movie.api.MovieApiClient
import com.nbs.moviecompose.data.base.RetrofitService
import com.nbs.moviecompose.data.movie.api.MovieApi
import com.nbs.moviecompose.domain.MovieRepository
import com.nbs.moviecompose.domain.MovieRepositoryImpl
import com.nbs.moviecompose.viewmodel.MovieViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featureModule = module {
    single {
        RetrofitService.createService(
            MovieApiClient::class.java,
            get()
        )
    }

    single { MovieApi(get()) }

    single<MovieRepository> {
        MovieRepositoryImpl(
            api = get()
        )
    }

    viewModel { MovieViewModel(get()) }
}