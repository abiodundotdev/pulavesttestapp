package com.abiodundotdev.pulavest.data.services

import retrofit2.http.POST

import com.abiodundotdev.pulavest.core.constants.EndPoints
import com.abiodundotdev.pulavest.domain.models.ProductModel
import com.abiodundotdev.pulavest.domain.requestdatas.LoginRequestData
import com.abiodundotdev.pulavest.domain.requestdatas.RegisterRequestData
import com.abiodundotdev.pulavest.domain.responses.LoginResponseData
import com.abiodundotdev.pulavest.domain.serviceinterface.AuthServiceInterface
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path

interface AuthService :AuthServiceInterface {
    @POST(EndPoints.Login)
    override suspend fun login(@Body loginResponseData: LoginRequestData ): Response<LoginResponseData>

    @POST(EndPoints.Register)
    override suspend fun register(@Body registerRequestData: RegisterRequestData ): Response<LoginResponseData>

    @POST(EndPoints.LogOut)
    override suspend fun logout(): Response<String>

}