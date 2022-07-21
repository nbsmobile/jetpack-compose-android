package com.nbs.moviecompose.presentation

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.nbs.moviecompose.presentation.navigation.BottomNavigationMain
import com.nbs.moviecompose.presentation.navigation.MainNavigationGraph
import com.nbs.moviecompose.viewmodel.MovieViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.rememberNavHostEngine
import org.koin.androidx.compose.getViewModel

@Composable
@Destination
fun MainScreen(navigator: DestinationsNavigator) {
    val engine = rememberNavHostEngine()
    val controller = engine.rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationMain(navController = controller) }
    ) {
        MainNavigationGraph(
            navigator,
            controller
        )
    }
}