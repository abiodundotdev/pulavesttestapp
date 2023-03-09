package com.abiodundotdev.pulavest.repositorytest

import com.abiodundotdev.pulavest.data.repository.AuthRepository
import com.abiodundotdev.pulavest.data.repository.InvestmentRepository
import com.abiodundotdev.pulavest.domain.requestdatas.LoginRequestData
import com.abiodundotdev.pulavest.domain.requestdatas.RegisterRequestData
import com.abiodundotdev.pulavest.domain.responses.LoginResponseData
import com.abiodundotdev.pulavest.domain.serviceinterface.AuthServiceInterface
import com.abiodundotdev.pulavest.domain.serviceinterface.InvestmentServiceInterface
import com.abiodundotdev.pulavest.domain.fakeservices.FakeAuthService
import com.abiodundotdev.pulavest.domain.fakeservices.FakeInvestmentService
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.After
import org.junit.Before
import org.junit.Test

class AllRepositoryTest {
    lateinit var authRepository: AuthRepository;
    lateinit var investmentRepository : InvestmentRepository;

     private  var investmentService: InvestmentServiceInterface = FakeInvestmentService()
     private var authService: AuthServiceInterface = FakeAuthService();

    @Before
    fun setUp(){
        authRepository = AuthRepository(authService);
        investmentRepository = InvestmentRepository(investmentService);
    }

    @After
    fun tearDownAll(){
    }

    @Test
    fun `verify user is logged return as expected`() {
        runBlocking {
            MatcherAssert.assertThat(
                authRepository.login(LoginRequestData()).body(), CoreMatchers.isA(
                    LoginResponseData::class.java
                )
            )
        }
    }

    @Test
    fun `verify user is able to register`() {
        runBlocking {
            MatcherAssert.assertThat(
                authRepository.register(RegisterRequestData()).body(), CoreMatchers.isA(
                    LoginResponseData::class.java
                )
            )
        }
    }

    @Test
    fun verify_investment_data_is_fetched_correct() {
        runBlocking {
            val investmentResponse = investmentRepository.getInvestments().body()
            MatcherAssert.assertThat(
                investmentResponse, CoreMatchers.isA(
                    List::class.java
                )
            )
            MatcherAssert.assertThat(
                investmentResponse!!.size, CoreMatchers.equalTo(3)
            )
        }
    }
}