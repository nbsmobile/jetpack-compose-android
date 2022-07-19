package com.nbs.moviecompose.data.base

import com.google.gson.GsonBuilder
import com.nbs.moviecompose.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    fun <S> createService(serviceClass: Class<S>, okhttpClient: OkHttpClient): S {
        val gson = GsonBuilder().create()
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(ResultCallAdapterFactory())
            .client(okhttpClient)
            .build()

        return retrofit.create(serviceClass)
    }
}