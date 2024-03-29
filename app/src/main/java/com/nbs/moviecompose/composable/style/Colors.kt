package com.nbs.moviecompose.composable.style

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import com.nbs.moviecompose.R
import com.nbs.moviecompose.composable.utils.getColorIntFromRes

// Color Resource
object Colors {
    val white: Color = Color(getColorIntFromRes(R.color.white))
    val black: Color = Color(getColorIntFromRes(R.color.black))
}

// Color Movie Compose Theme
@Immutable
data class MovieComposeColorsDark(
    override val colorPrimary: Color = Colors.white,
    override val colorSecondary: Color = Colors.white,
    override val statusBarColor: Color = Colors.white
) : BaseMovieComposeColors()

@Immutable
data class MovieComposeColorsLight(
    override val colorPrimary: Color = Colors.white,
    override val colorSecondary: Color = Colors.white,
    override val statusBarColor: Color = Colors.white
) : BaseMovieComposeColors()