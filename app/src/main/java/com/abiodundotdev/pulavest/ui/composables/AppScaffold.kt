package com.abiodundotdev.pulavest.ui.composables

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.abiodundotdev.pulavest.ui.features.auth.AuthViewModel
import javax.inject.Inject

@Composable
fun AppScaffold(
    appBar : @Composable () -> Unit,
    scaffoldState: ScaffoldState? = rememberScaffoldState(),
    content : @Composable (PaddingValues) -> Unit,
) {
    Scaffold(
        topBar = appBar,
        content = content,
    )
}

@Composable
fun AppTopAppBar(
    title : String
) {
    var authViewModel = hiltViewModel<AuthViewModel>();

    TopAppBar(
        title = { Text(text = title) },
        elevation = 0.dp,
        backgroundColor = Color.White,
        navigationIcon = { IconButton(onClick = { authViewModel.navigator.goBack()},)
        {
            Icon(
                Icons.Rounded.ArrowBack,
                contentDescription = "back"
            )
        }
 }
    )
}

@Composable
fun PAppTopAppBar(
    title: @Composable () -> Unit,
) {
    var authViewModel = hiltViewModel<AuthViewModel>();

    TopAppBar(
        title = title,
        elevation = 0.dp,
        backgroundColor = Color.White,
        navigationIcon = { IconButton(onClick = { authViewModel.navigator.goBack()}, )
        {
            Icon(
                Icons.Rounded.ArrowBack,
                contentDescription = "back"
            )
        }
        }
    )
}