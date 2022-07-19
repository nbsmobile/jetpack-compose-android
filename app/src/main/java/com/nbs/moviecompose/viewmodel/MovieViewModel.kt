package com.nbs.moviecompose.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nbs.moviecompose.data.base.Resource
import com.nbs.moviecompose.data.base.Resource.Companion.init
import com.nbs.moviecompose.data.base.Resource.Companion.loading
import com.nbs.moviecompose.domain.MovieRepository
import com.nbs.moviecompose.domain.response.Movie
import kotlinx.coroutines.launch

class MovieViewModel(
    private val repository: MovieRepository
) : ViewModel() {

    private val _popularMovies = MutableLiveData<Resource<List<Movie>>>()
    val popularMovies : LiveData<Resource<List<Movie>>> get() = _popularMovies

    init {
        _popularMovies.value = init()
    }

    fun getPopularMovies(){
        viewModelScope.launch {
            _popularMovies.value = loading()
            val data = repository.getPopularMovies()
            _popularMovies.value = data
        }
    }

}