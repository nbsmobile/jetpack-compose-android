package com.nbs.moviecompose.composable.component

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import coil.compose.SubcomposeAsyncImage
import com.nbs.moviecompose.utils.emptyString

@Composable
fun BaseImageView(imageResourceId: Int, modifier: Modifier, contentScale: ContentScale? = null) {
    Image(
        painter = painterResource(imageResourceId),
        contentDescription = emptyString(),
        modifier = modifier,
        contentScale = contentScale ?: ContentScale.FillBounds
    )
}

@Composable
fun BaseImageView(url: String, modifier: Modifier, contentScale: ContentScale? = null) {
    SubcomposeAsyncImage(
        model = url,
        modifier = modifier,
        loading = {
            DefaultLoadingView()
        },
        success = {
            Image(
                painter = this.painter, contentDescription = emptyString(),
                modifier = modifier,
                contentScale = contentScale ?: ContentScale.FillBounds,
            )
        },
        contentDescription = emptyString()
    )
}