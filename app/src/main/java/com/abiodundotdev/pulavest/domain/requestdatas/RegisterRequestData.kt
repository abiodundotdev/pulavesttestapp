package com.abiodundotdev.pulavest.domain.requestdatas

import com.google.gson.annotations.SerializedName

data class RegisterRequestData(
    var email: String? = null,
    var password: String? = null,
    @SerializedName("first_name")
    var firstname: String? = null,
    @SerializedName("last_name")
    var lastname: String? = null,
    ){
    fun isValid() : Boolean  = email != null && password != null && firstname != null && lastname != null ;
}