package com.nbs.moviecompose.composable.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nbs.moviecompose.composable.style.MovieComposeTheme

@Composable
fun MovieComposeThemeView(content: @Composable () -> Unit) {
    MovieComposeTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MovieComposeTheme.colors.colorPrimary)
        ) {
            content()
        }
    }
}