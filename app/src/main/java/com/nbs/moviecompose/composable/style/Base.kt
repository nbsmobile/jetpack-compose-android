package com.nbs.moviecompose.composable.style

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

abstract class BaseMovieComposeColors {
    abstract val colorPrimary: Color
    abstract val colorSecondary: Color
    abstract val statusBarColor: Color
}

val LocalMovieComposeColors = staticCompositionLocalOf<BaseMovieComposeColors> {
    MovieComposeColorsLight()
    MovieComposeColorsDark()
}

abstract class BaseMovieComposeComposeTypography {
    abstract val medium: TextStyle
    abstract val bold: TextStyle
    abstract val light: TextStyle
    abstract val normal: TextStyle
}

val LocalMovieComposeTypography = staticCompositionLocalOf<BaseMovieComposeComposeTypography> {
    MovieComposeTypography()
}
