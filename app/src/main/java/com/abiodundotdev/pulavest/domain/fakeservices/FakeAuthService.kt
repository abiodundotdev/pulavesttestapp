package com.abiodundotdev.pulavest.domain.fakeservices

import com.abiodundotdev.pulavest.domain.requestdatas.LoginRequestData
import com.abiodundotdev.pulavest.domain.requestdatas.RegisterRequestData
import com.abiodundotdev.pulavest.domain.responses.LoginResponseData
import com.abiodundotdev.pulavest.domain.serviceinterface.AuthServiceInterface
import retrofit2.Response

class FakeAuthService : AuthServiceInterface {
    override suspend fun login(loginResponseData: LoginRequestData): Response<LoginResponseData>{
        return  Response.success(LoginResponseData( user = FakeResponse.user, message = "Success", token = "token" ));
    }

    override suspend fun register(registerRequestData: RegisterRequestData): Response<LoginResponseData> {
        return  Response.success(LoginResponseData( user = FakeResponse.user, message = "Success", token = "token" ));
    }

    override suspend fun logout(): Response<String> {
        return Response.success("Success")
    }
}