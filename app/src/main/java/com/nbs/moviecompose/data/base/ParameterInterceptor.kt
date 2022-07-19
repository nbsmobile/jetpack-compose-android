package com.nbs.moviecompose.data.base

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class ParameterInterceptor(private val params: HashMap<String, String>) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()

        val requestBuilder = original.newBuilder()
            .url(mapParameters(chain))

        val request = requestBuilder.build()
        return chain.proceed(request)

    }

    private fun mapParameters(chain: Interceptor.Chain): HttpUrl {
        val original = chain.request()
        val originalHttpUrl = original.url()

        val builder = originalHttpUrl.newBuilder()

        for ((key, value) in params) {
            builder.addQueryParameter(key, value)
        }

        return builder.build()
    }
}