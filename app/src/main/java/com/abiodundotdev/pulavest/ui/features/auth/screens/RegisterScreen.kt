package com.abiodundotdev.pulavest.ui.features.auth.screens;

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.material.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.abiodundotdev.pulavest.domain.requestdatas.RegisterRequestData
import com.abiodundotdev.pulavest.ui.composables.AppScaffold
import com.abiodundotdev.pulavest.ui.composables.AppTextField
import com.abiodundotdev.pulavest.ui.composables.AppTopAppBar
import com.abiodundotdev.pulavest.ui.composables.FilledButton


@Composable
fun RegisterScreen() {
    var registerRequestData = remember {mutableStateOf(RegisterRequestData()) }

AppScaffold(appBar = { AppTopAppBar(title = "Welcome") }) { padding ->
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Hello there !", modifier = Modifier.align(Alignment.Start) )
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = "Let's get to know you",  style =  MaterialTheme.typography.h6, fontWeight = FontWeight.ExtraBold,  modifier = Modifier.align(Alignment.Start) )

        Spacer(modifier = Modifier.height(15.dp))

        AppTextField(value = registerRequestData.value.firstname.toString(), onValueChange = { registerRequestData.value.firstname = it }, label =  "First Nane")

        Spacer(modifier = Modifier.height(25.dp))

        AppTextField(value = registerRequestData.value.firstname.toString(), onValueChange = { registerRequestData.value.firstname = it }, label =  "Last Nane")

        Spacer(modifier = Modifier.height(25.dp))

        AppTextField(value = "",
            onValueChange = { registerRequestData.value.firstname = it },
            label = "Email"
        )

        Spacer(modifier = Modifier.height(25.dp))

        AppTextField(value = "",
            onValueChange = { registerRequestData.value.firstname = it },
            label = "Password"
        )

        Spacer(modifier = Modifier.height(25.dp))

        FilledButton(onClick = {  } , text =  "Register")

    }
}
}

fun handleSubmit(): Unit{

}