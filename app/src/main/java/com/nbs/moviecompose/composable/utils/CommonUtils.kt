package com.nbs.moviecompose.composable.utils

import android.app.Activity
import androidx.activity.ComponentActivity
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.placeholder
import com.google.accompanist.placeholder.shimmer
import com.nbs.moviecompose.composable.style.Colors
import com.nbs.moviecompose.composable.style.Dimensions

@Composable
fun getActivity(): Activity = LocalContext.current as ComponentActivity

fun Modifier.shimmer(isShowShimmer: Boolean): Modifier {
    return this.placeholder(
        visible = isShowShimmer,
        color = Colors.white.asDisabledColor(),
        shape = RoundedCornerShape(Dimensions.SIZE_8),
        highlight = PlaceholderHighlight.shimmer(
            highlightColor = Colors.white
        )
    )
}