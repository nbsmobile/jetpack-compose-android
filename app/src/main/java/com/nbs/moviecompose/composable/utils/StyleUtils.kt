package com.nbs.moviecompose.composable.utils

import androidx.annotation.ColorRes
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.core.content.ContextCompat
import com.nbs.moviecompose.utils.ContextProvider

fun getColorIntFromRes(@ColorRes colorResId : Int) : Int{
    return ContextCompat.getColor(ContextProvider.instance.get(), colorResId)
}

fun TextStyle.withColor(color : Color) = this.copy(color = color)

fun TextStyle.withSize(size : TextUnit) = this.copy(fontSize = size)

fun Color.asDisabledColor() = this.copy(alpha = 0.7f)