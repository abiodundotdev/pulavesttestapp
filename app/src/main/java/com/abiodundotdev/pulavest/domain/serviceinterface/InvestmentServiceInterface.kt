package com.abiodundotdev.pulavest.domain.serviceinterface

import com.abiodundotdev.pulavest.domain.aliases.ListOfInvestments
import com.abiodundotdev.pulavest.domain.models.ProductModel
import retrofit2.Response


interface InvestmentServiceInterface {
    suspend fun getInvestments(): Response<ListOfInvestments>

    suspend fun getInvestment(): Response<List<ProductModel>>

    suspend fun invest(): Response<List<ProductModel>>

}