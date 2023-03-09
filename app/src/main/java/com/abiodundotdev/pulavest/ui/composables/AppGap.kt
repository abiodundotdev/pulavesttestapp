package com.abiodundotdev.pulavest.ui.composables

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@Composable
fun ColumnGap(size : Dp) {
    Spacer(modifier = Modifier.height(size))
}

@Composable

fun RowGap(size : Dp) {
    Spacer(modifier = Modifier.width(size))
}