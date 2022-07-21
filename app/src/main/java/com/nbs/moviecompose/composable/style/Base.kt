package com.nbs.moviecompose.composable.style

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

abstract class BaseMovieComposeColors {
    abstract val colorPrimary: Color
    abstract val colorAccent: Color
    abstract val colorPrimaryDark: Color
    abstract val colorTextPrimary: Color
    abstract val colorTextSecondary: Color
}

val LocalMovieComposeColors = staticCompositionLocalOf<BaseMovieComposeColors> {
    MovieComposeColorsLight()
    MovieComposeColorsDark()
}

abstract class BaseMovieComposeTypography {
    abstract val medium: TextStyle
    abstract val bold: TextStyle
    abstract val light: TextStyle
    abstract val normal: TextStyle
}

val LocalMovieComposeTypography = staticCompositionLocalOf<BaseMovieComposeTypography> {
    MovieComposeTypography()
}
