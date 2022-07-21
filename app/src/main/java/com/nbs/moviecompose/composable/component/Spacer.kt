package com.nbs.moviecompose.composable.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@Composable
fun HorizontalSpace(size : Dp){
    Spacer(modifier = Modifier.width(size))
}

@Composable
fun VerticalSpace(size : Dp){
    Spacer(modifier = Modifier.height(size))
}