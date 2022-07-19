package com.nbs.moviecompose.di

import com.nbs.moviecompose.data.base.OkHttpClientService
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val applicationModule = module {
    single {
        return@single OkHttpClientService.create(androidContext())
    }
}