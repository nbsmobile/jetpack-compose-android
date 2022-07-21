package com.nbs.moviecompose.composable.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.nbs.moviecompose.R
import com.nbs.moviecompose.composable.style.Dimensions
import com.nbs.moviecompose.composable.style.MovieComposeTheme

@Composable
fun DefaultLoadingView() {
    Row(
        Modifier
            .fillMaxSize()
            .background(color = Color.Transparent),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .wrapContentSize(),
            color = MovieComposeTheme.colors.colorTextSecondary
        )
    }
}

@Composable
fun DefaultErrorView(error: String, onRetryClicked: (() -> Unit)? = null) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1.2f, matchHeightConstraintsFirst = false)
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = error,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = Dimensions.SIZE_16),
            style = MaterialTheme.typography.body2.copy(color = Color.Red),
            maxLines = 2,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(Dimensions.SIZE_8))
        TextButton(onClick = { onRetryClicked?.invoke() }) {
            Text(
                text = stringResource(id = R.string.action_retry),
                style = MaterialTheme.typography.body1.copy(color = Color.Black),
                maxLines = 1,
                textAlign = TextAlign.Center
            )
        }
    }
}