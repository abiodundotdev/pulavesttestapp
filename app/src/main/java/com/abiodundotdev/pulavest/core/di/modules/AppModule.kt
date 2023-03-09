package com.abiodundotdev.pulavest.core.di.modules

import com.abiodundotdev.pulavest.core.constants.EndPoints
import com.abiodundotdev.pulavest.data.services.AuthService
import com.abiodundotdev.pulavest.data.services.InvestmentService
import com.abiodundotdev.pulavest.data.services.WalletService
import com.abiodundotdev.pulavest.domain.serviceinterface.AuthServiceInterface
import com.abiodundotdev.pulavest.domain.serviceinterface.InvestmentServiceInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient
            .Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()
    }
    @Singleton
    @Provides
    fun provideConverterFactory(): GsonConverterFactory =
        GsonConverterFactory.create()
    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(EndPoints.BASEURL)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }
    @Singleton
    @Provides
    fun provideAuthService(retrofit: Retrofit): AuthServiceInterface =
        retrofit.create(AuthService::class.java)

    @Singleton
    @Provides
    fun provideInvestmentService(retrofit: Retrofit): InvestmentServiceInterface =
        retrofit.create(InvestmentService::class.java)

    @Singleton
    @Provides
    fun provideWalletService(retrofit: Retrofit): WalletService =
        retrofit.create(WalletService::class.java)


}