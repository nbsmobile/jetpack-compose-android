package com.nbs.moviecompose.presentation.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.nbs.moviecompose.R
import com.nbs.moviecompose.composable.component.BaseImageView
import com.nbs.moviecompose.composable.style.MovieComposeTheme
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@Destination
fun AwardScreen(navigator: DestinationsNavigator) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MovieComposeTheme.colors.colorPrimary.copy(0.1f)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        BaseImageView(
            imageResourceId = R.drawable.logo_nbs,
            modifier = Modifier.wrapContentSize()
        )
    }
}