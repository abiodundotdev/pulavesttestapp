package com.abiodundotdev.pulavest.data.services

import retrofit2.http.POST

import com.abiodundotdev.pulavest.core.constants.EndPoints
import com.abiodundotdev.pulavest.domain.models.ProductModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProfileService {
    @POST(EndPoints.Login)
    suspend fun getProfile(): Response<List<ProductModel>>

    @POST(EndPoints.Register)
    suspend fun updateProfile(): Response<List<ProductModel>>

}