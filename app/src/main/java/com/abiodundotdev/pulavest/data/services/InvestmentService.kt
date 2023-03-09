package com.abiodundotdev.pulavest.data.services

import retrofit2.http.POST

import com.abiodundotdev.pulavest.core.constants.EndPoints
import com.abiodundotdev.pulavest.domain.aliases.ListOfInvestments
import com.abiodundotdev.pulavest.domain.models.ProductModel
import com.abiodundotdev.pulavest.domain.serviceinterface.InvestmentServiceInterface
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface InvestmentService : InvestmentServiceInterface{
    @GET(EndPoints.Investments)
    override suspend fun getInvestments(): Response<ListOfInvestments>

    @GET(EndPoints.Investment)
    override suspend fun getInvestment(): Response<List<ProductModel>>

    @POST(EndPoints.Investment)
    override suspend fun invest(): Response<List<ProductModel>>

}