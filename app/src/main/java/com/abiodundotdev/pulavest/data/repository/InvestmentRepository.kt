package com.abiodundotdev.pulavest.data.repository

import com.abiodundotdev.pulavest.data.services.InvestmentService
import com.abiodundotdev.pulavest.domain.aliases.ListOfInvestments
import com.abiodundotdev.pulavest.domain.models.ProductModel
import com.abiodundotdev.pulavest.domain.requestdatas.LoginRequestData
import com.abiodundotdev.pulavest.domain.responses.BaseApiResponse
import com.abiodundotdev.pulavest.domain.responses.GetProductsResponse
import com.abiodundotdev.pulavest.domain.responses.LoginResponseData
import com.abiodundotdev.pulavest.domain.serviceinterface.InvestmentServiceInterface
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import javax.inject.Inject

@ActivityRetainedScoped
class InvestmentRepository @Inject constructor(
    private val investmentService: InvestmentServiceInterface
) : BaseApiResponse(){

    suspend fun getInvestments(): Response<ListOfInvestments> {
        return  investmentService.getInvestments();
    }


    suspend fun invest(): Flow<GetProductsResponse<List<ProductModel>>> {
        return flow<GetProductsResponse<List<ProductModel>>> {
            emit(safeApiCall{ investmentService.invest()})
        }.flowOn(Dispatchers.IO)
    }
}