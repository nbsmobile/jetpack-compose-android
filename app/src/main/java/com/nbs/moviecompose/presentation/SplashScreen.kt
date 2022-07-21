package com.nbs.moviecompose.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.nbs.moviecompose.R
import com.nbs.moviecompose.composable.component.BaseImageView
import com.nbs.moviecompose.composable.style.MovieComposeTheme
import com.nbs.moviecompose.composable.utils.navigateAndFinish
import com.nbs.moviecompose.presentation.destinations.MainScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.delay

@Composable
@Destination
@RootNavGraph(true)
fun SplashScreen(navigator: DestinationsNavigator) {
    LaunchedEffect(Unit) {
        delay(2000)
        navigator.navigateAndFinish(MainScreenDestination)
    }

    Row(
        Modifier
            .fillMaxSize()
            .background(MovieComposeTheme.colors.colorPrimary),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        BaseImageView(
            imageResourceId = R.drawable.app_logo,
            modifier = Modifier.wrapContentHeight()
        )
    }
}