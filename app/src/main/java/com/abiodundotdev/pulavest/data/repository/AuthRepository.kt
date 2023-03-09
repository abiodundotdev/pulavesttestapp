package com.abiodundotdev.pulavest.data.repository

import com.abiodundotdev.pulavest.data.services.AuthService
import com.abiodundotdev.pulavest.domain.requestdatas.LoginRequestData
import com.abiodundotdev.pulavest.domain.requestdatas.RegisterRequestData
import com.abiodundotdev.pulavest.domain.responses.BaseApiResponse
import com.abiodundotdev.pulavest.domain.responses.LoginResponseData
import com.abiodundotdev.pulavest.domain.serviceinterface.AuthServiceInterface
import dagger.hilt.android.scopes.ActivityRetainedScoped
import retrofit2.Response
import javax.inject.Inject

@ActivityRetainedScoped
class AuthRepository @Inject constructor(
    private val authService: AuthServiceInterface
) : BaseApiResponse() {
    suspend fun login(loginRequestData: LoginRequestData): Response<LoginResponseData> {
        return  authService.login(loginRequestData);
    }

    suspend fun register(registerRequestData: RegisterRequestData): Response<LoginResponseData> {
        return  authService.register(registerRequestData);
    }

    suspend fun logout(): Response<String> {
        return  authService.logout();
    }

//    suspend fun register(): Flow<GetProductsResponse<List<ProductModel>>> {
//        return flow<GetProductsResponse<List<ProductModel>>> {
//            emit(safeApiCall{ authService.register()})
//        }.flowOn(Dispatchers.IO)
//    }
}



//        return flow<GetProductsResponse<List<ProductModel>>> {
//            emit(safeApiCall{ authService.login()})
//        }.flowOn(Dispatchers.IO)