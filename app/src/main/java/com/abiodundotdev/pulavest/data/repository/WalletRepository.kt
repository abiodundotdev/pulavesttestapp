package com.abiodundotdev.pulavest.data.repository

import com.abiodundotdev.pulavest.data.services.AuthService
import com.abiodundotdev.pulavest.data.services.WalletService
import com.abiodundotdev.pulavest.domain.models.ProductModel
import com.abiodundotdev.pulavest.domain.responses.BaseApiResponse
import com.abiodundotdev.pulavest.domain.responses.GetProductsResponse
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@ActivityRetainedScoped
class WalletRepository @Inject constructor(
    private val walletService: WalletService
) : BaseApiResponse() {
    suspend fun fundWallet(): Flow<GetProductsResponse<List<ProductModel>>> {
        return flow<GetProductsResponse<List<ProductModel>>> {
            emit(safeApiCall{ walletService.fundWallet()})
        }.flowOn(Dispatchers.IO)
    }


}