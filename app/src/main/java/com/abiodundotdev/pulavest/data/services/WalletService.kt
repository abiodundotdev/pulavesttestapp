package com.abiodundotdev.pulavest.data.services

import retrofit2.http.POST

import com.abiodundotdev.pulavest.core.constants.EndPoints
import com.abiodundotdev.pulavest.domain.models.ProductModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface WalletService {
    @POST(EndPoints.Login)
    suspend fun fundWallet(): Response<List<ProductModel>>

    @POST(EndPoints.Register)
    suspend fun withdrawFromWallet(): Response<List<ProductModel>>
}