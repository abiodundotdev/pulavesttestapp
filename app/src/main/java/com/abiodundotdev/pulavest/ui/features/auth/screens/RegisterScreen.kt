package com.abiodundotdev.pulavest.ui.features.auth.screens;

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.abiodundotdev.pulavest.core.constants.ComposableTags
import com.abiodundotdev.pulavest.core.constants.Routes
import com.abiodundotdev.pulavest.core.utils.FormValidator
import com.abiodundotdev.pulavest.domain.requestdatas.RegisterRequestData
import com.abiodundotdev.pulavest.ui.composables.*
import com.abiodundotdev.pulavest.ui.features.auth.AuthViewModel
import com.abiodundotdev.pulavest.ui.features.auth.LoginState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun RegisterScreen() {
    var registerRequestData = remember {mutableStateOf(RegisterRequestData()) }

    val authViewModel = hiltViewModel<AuthViewModel>()

    val registerState  = authViewModel.loginState.collectAsState().value;

    val scaffoldState: ScaffoldState = rememberScaffoldState()

    val coroutineScope: CoroutineScope = rememberCoroutineScope()

    AppScaffold(appBar = { AppTopAppBar(title = "") }) { padding ->
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

        ColumnGap(15.dp)

        AppTextField(value= registerRequestData.value.firstname, onValueChange = {_val ->
            registerRequestData.value =   registerRequestData.value.copy(firstname = _val)
        },  label =  "Firstname",
            validator = FormValidator.empty(registerRequestData.value.firstname, "Firstname"),
            modifier = Modifier.testTag(ComposableTags.USERNAME_FORM_FIELD),
            isError = registerRequestData.value.firstNameValid()
        )

        ColumnGap(15.dp)

        AppTextField(value= registerRequestData.value.lastname, onValueChange = {_val ->
            registerRequestData.value =   registerRequestData.value.copy(lastname = _val)
        },  label =  "Lastname",
            validator = FormValidator.empty(registerRequestData.value.lastname, "Lastname"),
            modifier = Modifier.testTag(ComposableTags.USERNAME_FORM_FIELD),
            isError = registerRequestData.value.lastNameValid()
        )

        ColumnGap(15.dp)

        AppTextField(value= registerRequestData.value.email, onValueChange = {_username ->
            registerRequestData.value =   registerRequestData.value.copy(email = _username)
        },  label =  "Username",
            validator = FormValidator.empty(registerRequestData.value.email, "Email"),
            modifier = Modifier.testTag(ComposableTags.USERNAME_FORM_FIELD),
            isError = registerRequestData.value.isEmailValid()
        )

        ColumnGap(15.dp)

        AppTextField(value= registerRequestData.value.password, onValueChange = {_password ->
            registerRequestData.value =   registerRequestData.value.copy(password = _password)
        }, label =  "Password",
            validator = FormValidator.empty(registerRequestData.value.password, "Password") ,
            modifier = Modifier.testTag(ComposableTags.PASSWORD_FORM_FIELD),
            isError = registerRequestData.value.isPasswordValid()
        )

        ColumnGap(size = 15.0.dp)

        TextButton(onClick = { authViewModel.navigator.navigate(Routes.Login)},
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "Click here to login")
        }

        ColumnGap(size = 15.0.dp)

        when(registerState) {
            is LoginState.Loading -> CircularProgressIndicator(
                modifier = Modifier.testTag("loading")

            )
            is LoginState.Error -> Text("error occur")
            is LoginState.Initial -> FilledButton(onClick = {
                registerRequestData.value = registerRequestData.value.copy(isValidated = true)
                if(!registerRequestData.value.isValid()){
                    coroutineScope.launch {
                        scaffoldState.snackbarHostState.showSnackbar(
                            message = "Kindly validate form before submission",
                            actionLabel = "Error"
                        )
                    }
                }else{
                    authViewModel.register(registerRequestData.value);
                }
            } , text =  "Login",
                modifier = Modifier.testTag(ComposableTags.LOGIN_BUTTON)
            )
            is LoginState.Success -> FilledButton(onClick = {} , text =  "Login")
        }
    }
}
}

fun handleSubmit(): Unit{

}