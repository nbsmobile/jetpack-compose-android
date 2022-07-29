package com.nbs.moviecompose.composable.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.nbs.moviecompose.composable.style.Colors
import com.nbs.moviecompose.composable.style.Dimensions
import com.nbs.moviecompose.composable.style.MovieComposeTheme
import com.nbs.moviecompose.composable.utils.withColor
import java.util.*

@Composable
fun MovieComposeButton(
    modifier: Modifier,
    text: String,
    color: Color = Colors.sunGlow,
    textAllCaps: Boolean = false,
    enabled: Boolean = false,
    onClick: () -> Unit,
    cornerRadius: Dp = Dimensions.SIZE_4,
    textPadding: Dp = Dimensions.SIZE_10
) {

    Button(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = color,
            disabledBackgroundColor = color.copy(alpha = 0.3f)
        ),
        shape = RoundedCornerShape(cornerRadius),
        enabled = enabled,
        onClick = {
            onClick()
        }
    ) {
        Text(
            modifier = Modifier
                .wrapContentSize()
                .padding(textPadding),
            text = if (textAllCaps) text.uppercase(Locale.getDefault()) else text,
            style = MovieComposeTheme.typography.bold.withColor(MovieComposeTheme.colors.colorPrimaryDark)
        )
    }
}