package com.nbs.moviecompose.data.base

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.nbs.moviecompose.BuildConfig
import okhttp3.Dispatcher
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

internal object OkHttpClientService {

    private const val DEFAULT_MAX_REQUEST = 30

    fun create(context: Context): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .addInterceptor(ChuckerInterceptor.Builder(context).build())
            .addInterceptor(getParameterInterceptor())
            .readTimeout(300, TimeUnit.SECONDS)
            .connectTimeout(300, TimeUnit.SECONDS)

        val dispatcher = Dispatcher()
        dispatcher.maxRequests = DEFAULT_MAX_REQUEST
        builder.dispatcher(dispatcher)

        return builder.build()
    }
}

private fun getParameterInterceptor(): Interceptor {
    val params = HashMap<String, String>()
    params["api_key"] = BuildConfig.API_KEY
    params["language"] = BuildConfig.API_LANGUAGE

    return ParameterInterceptor(params)
}