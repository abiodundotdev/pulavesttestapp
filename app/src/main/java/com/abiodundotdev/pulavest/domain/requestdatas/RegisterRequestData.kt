package com.abiodundotdev.pulavest.domain.requestdatas

import com.google.gson.annotations.SerializedName

data class RegisterRequestData(
    var email: String = "",
    var firstname: String = "",
    var lastname: String = "",
    var password: String = "",
    val isValidated : Boolean = false
){
    fun isValid() : Boolean  = email.isNotEmpty() && password.isNotEmpty();
    fun isEmailValid() : Boolean = email.isEmpty() && isValidated;

    fun lastNameValid() : Boolean = lastname.isEmpty() && isValidated;

    fun firstNameValid() : Boolean = firstname.isEmpty() && isValidated;

    fun isPasswordValid() : Boolean = password.isEmpty() && isValidated;
}
