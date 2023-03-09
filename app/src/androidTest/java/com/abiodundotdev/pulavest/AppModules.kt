package com.abiodundotdev.pulavest

import com.abiodundotdev.pulavest.core.di.modules.AppModule
import com.abiodundotdev.pulavest.domain.fakeservices.FakeAuthService
import com.abiodundotdev.pulavest.domain.fakeservices.FakeInvestmentService
import com.abiodundotdev.pulavest.domain.serviceinterface.AuthServiceInterface
import com.abiodundotdev.pulavest.domain.serviceinterface.InvestmentServiceInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [AppModule::class]
)
object FakeAppModule {
    @Singleton
    @Provides
    fun provideAuthService(): AuthServiceInterface =
        FakeAuthService()

    @Singleton
    @Provides
    fun provideInvestmentService(): InvestmentServiceInterface =
        FakeInvestmentService()
}