package com.abiodundotdev.pulavest.domain.fakeservices

import com.abiodundotdev.pulavest.domain.aliases.ListOfInvestments
import com.abiodundotdev.pulavest.domain.models.ProductModel
import com.abiodundotdev.pulavest.domain.serviceinterface.InvestmentServiceInterface
import retrofit2.Response

class FakeInvestmentService : InvestmentServiceInterface {
    override suspend fun getInvestments(): Response<ListOfInvestments> {
       return Response.success(listOf(
           FakeResponse.investment,
           FakeResponse.investment,
           FakeResponse.investment
       ));
    }

    override suspend fun getInvestment(): Response<List<ProductModel>> {
        throw Exception();
    }

    override suspend fun invest(): Response<List<ProductModel>> {
        throw Exception();
    }
}