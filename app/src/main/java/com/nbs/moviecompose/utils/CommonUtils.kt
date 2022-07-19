package com.nbs.moviecompose.utils

fun Boolean?.orDefault(default : Boolean) : Boolean{
    return this ?: default
}

fun Long?.orZero() : Long = this ?: 0L

fun Int?.orZero() : Int = this ?: 0

fun Double?.orZero() : Double = this ?:  0.0

fun emptyString() = ""