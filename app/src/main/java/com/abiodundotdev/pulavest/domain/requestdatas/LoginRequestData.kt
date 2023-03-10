package com.abiodundotdev.pulavest.domain.requestdatas

data class LoginRequestData(
var email: String = "",
var password: String = "",
val isValidated : Boolean = false
){
    fun isValid() : Boolean  = email.isNotEmpty() && password.isNotEmpty();
    fun isEmailValid() : Boolean = email.isEmpty() && isValidated;
    fun isPasswordValid() : Boolean = password.isEmpty() && isValidated;
}
