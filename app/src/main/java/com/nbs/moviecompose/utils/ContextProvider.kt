package com.nbs.moviecompose.utils

import android.annotation.SuppressLint
import android.content.Context
import kotlin.jvm.internal.Intrinsics

@SuppressLint("StaticFieldLeak")
object ContextProvider {
    private var mContext: Context? = null

    private val INSTANCE_PROVIDER: ContextProvider = ContextProvider()

    private fun ContextProvider() = INSTANCE_PROVIDER

    private fun init(context: Context) {
        mContext = context
    }

    private fun getContext(): Context {
        return if (mContext == null) {
            throw IllegalStateException("call init first")
        } else {
            val var1 = mContext
            Intrinsics.checkNotNull(var1)
            var1!!
        }
    }

    fun initialize(context: Context){
        Intrinsics.checkNotNullParameter(context, "context")
        INSTANCE_PROVIDER.init(context)
    }

    fun get(): Context {
        return INSTANCE_PROVIDER.getContext()
    }
}