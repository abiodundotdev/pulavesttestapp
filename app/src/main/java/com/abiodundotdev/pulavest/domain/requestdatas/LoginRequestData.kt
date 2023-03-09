package com.abiodundotdev.pulavest.domain.requestdatas

data class LoginRequestData(
var email: String = "",
var password: String = "",
){
    fun isValid() : Boolean  = email.isNotEmpty() && password.isNotEmpty();
//    fun isEmailValid() : Boolean = email.isEmpty();
//    fun isPasswordValid() : Boolean = password.isEmpty();
}
