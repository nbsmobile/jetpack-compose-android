package com.nbs.moviecompose.composable.style

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import com.nbs.moviecompose.R
import com.nbs.moviecompose.composable.utils.asDisabledColor
import com.nbs.moviecompose.composable.utils.getColorIntFromRes

// Color Resource
object Colors {
    val white: Color = Color(getColorIntFromRes(R.color.white))
    val black: Color = Color(getColorIntFromRes(R.color.black))
    val raisinBlack: Color = Color(getColorIntFromRes(R.color.colorRaisinBlack))
    val charlestonGreen: Color = Color(getColorIntFromRes(R.color.colorRaisinBlack))
    val sunGlow: Color = Color(getColorIntFromRes(R.color.colorSunGlow))
    val transparent: Color = Color(getColorIntFromRes(R.color.transparent))
}

// Color Movie Compose Theme
@Immutable
data class MovieComposeColorsDark(
    override val colorPrimary: Color = Colors.charlestonGreen,
    override val colorAccent: Color = Colors.sunGlow,
    override val colorPrimaryDark: Color = Colors.black,
    override val colorTextPrimary: Color = Colors.white,
    override val colorTextSecondary: Color = Colors.white.asDisabledColor()
) : BaseMovieComposeColors()

@Immutable
data class MovieComposeColorsLight(
    override val colorPrimary: Color = Colors.charlestonGreen,
    override val colorAccent: Color = Colors.sunGlow,
    override val colorPrimaryDark: Color = Colors.black,
    override val colorTextPrimary: Color = Colors.white,
    override val colorTextSecondary: Color = Colors.white.asDisabledColor()
) : BaseMovieComposeColors()