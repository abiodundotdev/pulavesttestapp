package com.abiodundotdev.pulavest.ui.features

import android.os.Handler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.abiodundotdev.pulavest.R
import com.abiodundotdev.pulavest.core.constants.Routes
import com.abiodundotdev.pulavest.ui.composables.ColumnGap
import com.abiodundotdev.pulavest.ui.features.auth.AuthViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*
import kotlin.concurrent.timerTask

@Composable
fun SecondarySlashScreen() {
    val authViewModel  = hiltViewModel<AuthViewModel>()
    val scope = rememberCoroutineScope()

    val shouldRedirect  = remember{ mutableStateOf<Boolean>(false)};

    LaunchedEffect(key1 = "splashscreen" ){
       scope.launch(Dispatchers.Main) {
           Timer().schedule(timerTask {
               shouldRedirect.value = true;
           }, 3000)
       }
    }

    if(shouldRedirect.value){
        authViewModel.navigator.navigate(Routes.Login)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Image(
            painter = painterResource(id = R.drawable.app_logo),
            contentDescription = "",
            modifier = Modifier.size(width = 200.dp, height = 200.dp)
        )
        ColumnGap(size = 100.dp)
        CircularProgressIndicator()
    }
    }