package com.abiodundotdev.pulavest.ui.features.auth

sealed class RegisterState() {
    class Success<T>(data: T)
    class Error<T>(message: String)
    class Loading
    class Initial
}