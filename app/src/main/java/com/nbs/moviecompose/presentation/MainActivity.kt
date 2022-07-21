package com.nbs.moviecompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.nbs.moviecompose.composable.component.MovieComposeThemeView
import com.ramcosta.composedestinations.DestinationsNavHost

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieComposeThemeView {
                DestinationsNavHost(navGraph = NavGraphs.root)
            }
        }
    }
}