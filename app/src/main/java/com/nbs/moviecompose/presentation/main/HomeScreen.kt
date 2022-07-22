@file:OptIn(ExperimentalPagerApi::class)

package com.nbs.moviecompose.presentation.main

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.nbs.moviecompose.BuildConfig
import com.nbs.moviecompose.R
import com.nbs.moviecompose.composable.component.BaseImageView
import com.nbs.moviecompose.composable.component.VerticalSpace
import com.nbs.moviecompose.composable.style.Dimensions
import com.nbs.moviecompose.composable.style.MovieComposeTheme
import com.nbs.moviecompose.composable.style.TextSizes
import com.nbs.moviecompose.composable.utils.*
import com.nbs.moviecompose.domain.response.Movie
import com.nbs.moviecompose.presentation.detail.DetailActivity
import com.nbs.moviecompose.viewmodel.MovieViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield
import org.koin.androidx.compose.getViewModel

@Composable
@Destination
fun HomeScreen(navigator: DestinationsNavigator) {

    val activity = getActivity()

    BackHandler {
        activity.finish()
    }

    val movieViewModel = getViewModel<MovieViewModel>()
    val popularMovieState = movieViewModel.popularMovies.observeAsState()
    val nowPlayingMovieState = movieViewModel.nowPlayingMovies.observeAsState()

    val isLoadingPopular = remember { mutableStateOf(false) }

    val isLoadingNowPlaying = remember { mutableStateOf(false) }

    val popularMovies = remember {
        mutableStateOf(
            listOf(
                Movie.dummy(),
                Movie.dummy()
            )
        )
    }

    val nowPlayingMovies = remember {
        mutableStateOf(
            listOf(
                Movie.dummy(),
                Movie.dummy(),
                Movie.dummy(),
                Movie.dummy()
            )
        )
    }

    LaunchedEffect(key1 = Unit) {
        movieViewModel.getPopularMovies()
        movieViewModel.getNowPlayingMovies()
    }

    ComposableObserver(state = popularMovieState,
        onLoading = {
            isLoadingPopular.value = true
        }, onFailure = {
            isLoadingPopular.value = false
        }, onSuccess = {
            isLoadingPopular.value = false
            popularMovies.value = it
        })

    ComposableObserver(state = nowPlayingMovieState,
        onLoading = {
            isLoadingNowPlaying.value = true
        }, onFailure = {
            isLoadingNowPlaying.value = false
        }, onSuccess = {
            isLoadingNowPlaying.value = false
            nowPlayingMovies.value = it
        })

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MovieComposeTheme.colors.colorPrimary)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(Dimensions.SIZE_16)
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            BaseImageView(
                imageResourceId = R.drawable.app_logo,
                modifier = Modifier.wrapContentSize()
            )
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .heightIn(min = Dimensions.SIZE_4, max = 10000.dp)
                .padding(bottom = Dimensions.SIZE_8)
        ) {
            item(span = { GridItemSpan(2) }) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {
                    HomeCarouselView(
                        movies = popularMovies.value,
                        onMoviesItemClicked = {
                            DetailActivity.start(activity, it)
                            activity.finish()
                        },
                        isLoadingPopular = isLoadingPopular.value
                    )

                    VerticalSpace(size = Dimensions.SIZE_24)

                    Text(
                        text = stringResource(id = R.string.label_now_playing),
                        style = MovieComposeTheme.typography.bold.withSize(TextSizes.SIZE_16)
                            .withColor(MovieComposeTheme.colors.colorTextPrimary),
                        modifier = Modifier.padding(horizontal = Dimensions.SIZE_16)
                    )

                    VerticalSpace(size = Dimensions.SIZE_16)
                }
            }

            items(nowPlayingMovies.value.size) { index ->
                MovieItem(
                    movie = nowPlayingMovies.value[index],
                    onMoviesItemClicked = {
                        DetailActivity.start(activity, it)
                        activity.finish()
                    },
                    isLoadingNowPlaying = isLoadingNowPlaying.value
                )
            }

            item(span = { GridItemSpan(2) }) {
                VerticalSpace(size = Dimensions.SIZE_40)
            }
        }
    }
}

@Composable
fun HomeCarouselView(
    movies: List<Movie>,
    onMoviesItemClicked: ((Movie) -> Unit)?,
    isLoadingPopular: Boolean
) {
    val pagerState = rememberPagerState(movies.size)
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = Dimensions.SIZE_16)
    ) {
        val (pager, indicators) = createRefs()
        val configuration = LocalConfiguration.current

        HorizontalPager(
            count = movies.size,
            state = pagerState,
            contentPadding = PaddingValues(end = Dimensions.SIZE_50),
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(pager) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                }
        ) { page ->
            BaseImageView(
                url = BuildConfig.IMAGE_BASE_URL + movies[page].backdropPath,
                modifier = Modifier
                    .width((configuration.screenWidthDp / 6 * 5).dp)
                    .aspectRatio(2f)
                    .clip(RoundedCornerShape(Dimensions.SIZE_12))
                    .shimmer(isLoadingPopular)
                    .clickable {
                        onMoviesItemClicked?.invoke(movies[page])
                    },
                contentScale = ContentScale.FillBounds
            )
        }

        if (!isLoadingPopular) {
            HorizontalPagerIndicator(
                pagerState = pagerState,
                activeColor = MovieComposeTheme.colors.colorAccent,
                inactiveColor = MovieComposeTheme.colors.colorTextSecondary,
                modifier = Modifier.constrainAs(indicators) {
                    top.linkTo(pager.bottom, margin = Dimensions.SIZE_12)
                    start.linkTo(parent.start, margin = Dimensions.SIZE_16)
                }
            )
        }
    }

    LaunchedEffect(Unit) {
        while (true) {
            yield()
            delay(2000)
            pagerState.animateScrollToPage(
                page = (pagerState.currentPage + 1) % (pagerState.pageCount)
            )
        }
    }
}

@Composable
fun MovieItem(movie: Movie, isLoadingNowPlaying: Boolean, onMoviesItemClicked: ((Movie) -> Unit)?) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onMoviesItemClicked?.invoke(movie)
            },
        backgroundColor = MovieComposeTheme.colors.colorPrimary
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(Dimensions.SIZE_16)
        ) {
            BaseImageView(
                url = BuildConfig.IMAGE_BASE_URL + movie.posterPath,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(0.7f)
                    .clip(RoundedCornerShape(Dimensions.SIZE_8))
                    .shimmer(isLoadingNowPlaying)
                    .clickable {
                        onMoviesItemClicked?.invoke(movie)
                    },
                contentScale = ContentScale.FillBounds
            )

            VerticalSpace(size = Dimensions.SIZE_8)

            Text(
                text = movie.title,
                style = MovieComposeTheme.typography.medium.withSize(TextSizes.SIZE_14)
                    .withColor(MovieComposeTheme.colors.colorTextPrimary)
            )
        }
    }
}