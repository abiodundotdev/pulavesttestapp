package com.abiodundotdev.pulavest.domain.serviceinterface

import com.abiodundotdev.pulavest.core.constants.EndPoints
import com.abiodundotdev.pulavest.domain.requestdatas.LoginRequestData
import com.abiodundotdev.pulavest.domain.requestdatas.RegisterRequestData
import com.abiodundotdev.pulavest.domain.responses.LoginResponseData
import retrofit2.Response


interface AuthServiceInterface {
    suspend fun login(loginResponseData: LoginRequestData): Response<LoginResponseData>

    suspend fun register(registerRequestData: RegisterRequestData): Response<LoginResponseData>

    suspend fun logout(): Response<String>

}