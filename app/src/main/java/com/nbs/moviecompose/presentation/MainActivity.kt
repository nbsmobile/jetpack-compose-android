package com.nbs.moviecompose.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.nbs.moviecompose.composable.style.MovieComposeTheme
import com.nbs.moviecompose.data.base.Resource
import com.nbs.moviecompose.utils.getErrorMessage
import com.nbs.moviecompose.utils.getValue
import com.nbs.moviecompose.viewmodel.MovieViewModel
import org.koin.androidx.compose.getViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MovieComposeTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen(){
    val movieViewModel = getViewModel<MovieViewModel>()
    val popularMovieState = movieViewModel.popularMovies.observeAsState()
    val isLoading = remember{ mutableStateOf(false) }

    when (popularMovieState.value) {
        is Resource.Loading -> {
            isLoading.value = true
        }
        is Resource.Success -> {
            isLoading.value = false
            val popularMovies = getValue(popularMovieState.value)
        }
        is Resource.Error -> {
            isLoading.value = false
            val message = getErrorMessage(popularMovieState.value)
        }
        else -> {}
    }
}