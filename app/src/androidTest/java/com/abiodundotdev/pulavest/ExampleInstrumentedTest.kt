package com.abiodundotdev.pulavest

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.abiodundotdev.pulavest.data.repository.AuthRepository
import com.abiodundotdev.pulavest.data.repository.InvestmentRepository
import com.abiodundotdev.pulavest.domain.requestdatas.LoginRequestData
import com.abiodundotdev.pulavest.domain.responses.LoginResponseData
import com.abiodundotdev.pulavest.domain.serviceinterface.AuthServiceInterface
import com.abiodundotdev.pulavest.domain.serviceinterface.InvestmentServiceInterface
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.After

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import javax.inject.Inject

@RunWith(AndroidJUnit4::class)
class PulaInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.abiodundotdev.pulavest", appContext.packageName)
    }
}

