package com.abiodundotdev.pulavest.ui.features.auth

import com.abiodundotdev.pulavest.domain.responses.LoginResponseData

sealed class LoginState() {
    data class Success(val data: LoginResponseData) : LoginState();
    data  class Error(val message: String) : LoginState();
    class Loading() : LoginState();
    class Initial() : LoginState();
}