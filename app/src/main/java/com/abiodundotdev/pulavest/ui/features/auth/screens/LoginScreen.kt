package com.abiodundotdev.pulavest.ui.features.auth.screens;

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.abiodundotdev.pulavest.core.constants.ComposableTags
import com.abiodundotdev.pulavest.core.constants.Routes
import com.abiodundotdev.pulavest.core.utils.FormValidator
import com.abiodundotdev.pulavest.domain.requestdatas.LoginRequestData
import com.abiodundotdev.pulavest.domain.requestdatas.RegisterRequestData
import com.abiodundotdev.pulavest.ui.composables.*
import com.abiodundotdev.pulavest.ui.features.auth.AuthViewModel
import com.abiodundotdev.pulavest.ui.features.auth.LoginState
import com.abiodundotdev.pulavest.ui.features.investment.screens.InvestmentViewModel
import com.abiodundotdev.pulavest.ui.theme.AppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun LoginScreen( investmentViewModel: InvestmentViewModel, authViewModel: AuthViewModel ) {

    val loginState  = authViewModel.loginState.collectAsState().value;

    var loginRequestData  = remember { mutableStateOf(LoginRequestData())}

    val scaffoldState: ScaffoldState = rememberScaffoldState()

    val coroutineScope: CoroutineScope = rememberCoroutineScope()


    AppScaffold(  appBar = { AppTopAppBar(title = "") }, scaffoldState = scaffoldState) { padding ->
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

            Text(text = "Login, here",  style =  MaterialTheme.typography.h6, fontWeight = FontWeight.ExtraBold,  modifier = Modifier.align(Alignment.Start) )

            Spacer(modifier = Modifier.height(15.dp))

            AppTextField(value= loginRequestData.value.email, onValueChange = {_username ->
                loginRequestData.value =   loginRequestData.value.copy(email = _username)
            },  label =  "Username",
                isError = loginRequestData.value.isEmailValid(),
                validator = FormValidator.empty(loginRequestData.value.email, "Username"),
                testTag = ComposableTags.USERNAME_FORM_FIELD
            )

            Spacer(modifier = Modifier.height(25.dp))

            AppTextField(value= loginRequestData.value.password, onValueChange = {_password ->
                loginRequestData.value =   loginRequestData.value.copy(password = _password)
            }, label =  "Password",
                isError = loginRequestData.value.isPasswordValid(),
                validator = FormValidator.empty(loginRequestData.value.password, "Password") ,
                testTag = ComposableTags.PASSWORD_FORM_FIELD
            )

            ColumnGap(size = 15.0.dp)

            TextButton(onClick = { authViewModel.navigator.navigate(Routes.Register)},
            modifier = Modifier.align(Alignment.End)
            ) {
                Text(text = "Click here to register")
            }

            ColumnGap(size = 15.0.dp)

            when(loginState) {
                is LoginState.Loading -> CircularProgressIndicator(
                    modifier = Modifier.testTag("loading")
                )
                is LoginState.Error -> Text("error occur")
                is LoginState.Initial -> FilledButton(onClick = {
                   if(!loginRequestData.value.isValid()){
                       loginRequestData.value = loginRequestData.value.copy(isValidated = true)
                       coroutineScope.launch {
                           scaffoldState.snackbarHostState.showSnackbar(
                               message = "Kindly validate form before submission",
                               actionLabel = "Error"
                           )
                       }
                   }else{
                       authViewModel.login(loginRequestData.value);
                       investmentViewModel.getInvestments()
                   }
                } , text =  "Login",
                    modifier = Modifier.testTag(ComposableTags.LOGIN_BUTTON)
                )
                is LoginState.Success -> FilledButton(onClick = {} , text =  "Login")
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppTheme {
       // LoginScreen()
    }
}

//val authViewModel = hiltViewModel<AuthViewModel>()
//    val composeView = LocalView.current
//    val authViewModel = composeView.findViewTreeViewModelStoreOwner()?.let {
//        hiltViewModel<AuthViewModel>(it)
//    }
