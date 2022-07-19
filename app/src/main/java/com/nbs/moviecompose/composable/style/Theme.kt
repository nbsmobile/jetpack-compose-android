package com.nbs.moviecompose.composable.style

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun MovieComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val movieComposeColors = if (darkTheme) MovieComposeColorsDark() else MovieComposeColorsLight()
    val movieComposeTypography = MovieComposeTypography()

    CompositionLocalProvider(
        LocalMovieComposeColors provides movieComposeColors,
        LocalMovieComposeTypography provides movieComposeTypography
    ) {
        MaterialTheme(
            content = content
        )
    }
}

object MovieComposeTheme {
    val colors: BaseMovieComposeColors
        @Composable
        get() = LocalMovieComposeColors.current

    val typography: BaseMovieComposeComposeTypography
        @Composable
        get() = LocalMovieComposeTypography.current
}
