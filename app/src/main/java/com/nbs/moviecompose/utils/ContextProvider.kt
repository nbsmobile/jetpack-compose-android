package com.nbs.moviecompose.utils

import android.annotation.SuppressLint
import android.content.Context
import kotlin.jvm.internal.Intrinsics

@SuppressLint("StaticFieldLeak")
class ContextProvider {
    companion object {
        private var INSTANCE: ContextProvider? = null

        @JvmStatic
        val instance: ContextProvider
            get() {
                if (INSTANCE == null) { // Single Checked
                    synchronized(ContextProvider::class.java) {
                        if (INSTANCE == null) { // Double checked
                            INSTANCE = ContextProvider()
                        }
                    }
                }
                return INSTANCE!!
            }
    }

    private var mContext: Context? = null

    private fun getContext(): Context {
        return if (mContext == null) {
            throw IllegalStateException("call init first")
        } else {
            val var1 = mContext
            Intrinsics.checkNotNull(var1)
            var1!!
        }
    }

    private fun init(context: Context) {
        mContext = context
    }

    fun initialize(context: Context) {
        Intrinsics.checkNotNullParameter(context, "context")
        init(context)
    }

    fun get(): Context {
        return getContext()
    }
}