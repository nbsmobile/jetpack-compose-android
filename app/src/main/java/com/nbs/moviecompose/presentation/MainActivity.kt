package com.nbs.moviecompose.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.nbs.moviecompose.composable.component.MovieComposeThemeView
import com.nbs.moviecompose.presentation.destinations.HomeScreenDestination
import com.nbs.moviecompose.presentation.destinations.MainScreenDestination
import com.nbs.moviecompose.presentation.destinations.SplashScreenDestination
import com.nbs.moviecompose.presentation.main.MainScreen
import com.ramcosta.composedestinations.DestinationsNavHost

class MainActivity : ComponentActivity() {

    companion object {
        fun start(context: Context, rootHome: Boolean = true) {
            Intent(context, MainActivity::class.java).apply {
                putExtra("rootHome", rootHome)
                context.startActivity(this)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val rootHome = intent.getBooleanExtra("rootHome", false)

        setContent {
            MovieComposeThemeView {
                DestinationsNavHost(
                    navGraph = NavGraphs.root.copy(
                        startRoute = if (rootHome) MainScreenDestination else SplashScreenDestination
                    )
                )
            }
        }
    }
}