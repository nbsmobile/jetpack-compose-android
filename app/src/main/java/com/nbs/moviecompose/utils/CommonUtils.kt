package com.nbs.moviecompose.utils

import android.app.Activity
import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

fun Boolean?.orDefault(default : Boolean) : Boolean{
    return this ?: default
}

fun Long?.orZero() : Long = this ?: 0L

fun Int?.orZero() : Int = this ?: 0

fun Double?.orZero() : Double = this ?:  0.0

fun emptyString() = ""

fun Activity.getStatusBarHeight(): Int {
    var result = 0
    val resourceId: Int = resources.getIdentifier("status_bar_height", "dimen", "android")
    if (resourceId > 0) {
        result = resources.getDimensionPixelSize(resourceId)
    }
    return result
}

const val emailRegex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"