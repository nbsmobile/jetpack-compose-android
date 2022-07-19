package com.nbs.moviecompose.composable.style

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.toFontFamily
import com.nbs.moviecompose.R

object MovieComposeFonts {
    val regular : Font = Font(R.font.sf_pro_text_regular)
    val bold : Font = Font(R.font.sf_pro_text_bold)
    val medium : Font = Font(R.font.sf_pro_text_medium)
    val light : Font = Font(R.font.sf_pro_text_light)
}

@Immutable
data class MovieComposeTypography(
    override val medium: TextStyle = TextStyle(
        fontFamily = MovieComposeFonts.medium.toFontFamily(),
        fontSize = TextSizes.SIZE_1,
        fontWeight = FontWeight.Medium,
        color = Colors.black
    ),
    override val bold: TextStyle = TextStyle(
        fontFamily = MovieComposeFonts.bold.toFontFamily(),
        fontSize = TextSizes.SIZE_1,
        fontWeight = FontWeight.Bold,
        color = Colors.black
    ),
    override val light: TextStyle = TextStyle(
        fontFamily = MovieComposeFonts.light.toFontFamily(),
        fontSize = TextSizes.SIZE_1,
        fontWeight = FontWeight.Light,
        color = Colors.black
    ),
    override val normal: TextStyle = TextStyle(
        fontFamily = MovieComposeFonts.regular.toFontFamily(),
        fontSize = TextSizes.SIZE_1,
        fontWeight = FontWeight.Normal,
        color = Colors.black,
    )
) : BaseMovieComposeComposeTypography()