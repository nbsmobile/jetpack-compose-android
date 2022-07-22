package com.nbs.moviecompose.presentation.main

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.nbs.moviecompose.composable.style.MovieComposeTheme
import com.nbs.moviecompose.presentation.navigation.BottomNavigationMain
import com.nbs.moviecompose.presentation.navigation.MainNavigationGraph
import com.nbs.moviecompose.viewmodel.MovieViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.rememberNavHostEngine
import org.koin.androidx.compose.getViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
@Destination
fun MainScreen(navigator: DestinationsNavigator) {
    val engine = rememberNavHostEngine()
    val controller = engine.rememberNavController()
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(MovieComposeTheme.colors.colorPrimary),
        bottomBar = { BottomNavigationMain(navController = controller) }
    ) {
        MainNavigationGraph(
            navigator,
            controller
        )
    }
}