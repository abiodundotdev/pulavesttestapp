package com.abiodundotdev.pulavest.domain.responses

import com.abiodundotdev.pulavest.domain.models.User

data class LoginResponseData(
    val message: String,
    val token: String,
    val user: User
)