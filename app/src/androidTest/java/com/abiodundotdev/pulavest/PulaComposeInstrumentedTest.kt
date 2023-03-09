package com.abiodundotdev.pulavest

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Text
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.abiodundotdev.pulavest.core.constants.ComposableTags
import com.abiodundotdev.pulavest.ui.features.auth.AuthViewModel
import com.abiodundotdev.pulavest.ui.features.auth.screens.LoginScreen
import com.abiodundotdev.pulavest.ui.features.investment.screens.InvestmentViewModel
import com.abiodundotdev.pulavest.ui.theme.AppTheme
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class PulaComposeInstrumentedTest {

    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val testRule = createAndroidComposeRule<MainActivity>()

   lateinit  var authViewModel :  AuthViewModel;
       //testRule.activity.viewModels<AuthViewModel>().value;
    lateinit   var investmentViewModel :InvestmentViewModel;
        //testRule.activity.viewModels<InvestmentViewModel>().value


    @Before
    fun setUp() {
        hiltRule.inject()
    }

    @Test
    fun verify_login_has_required_composable_for_input_and_others(){
        testRule.activity.apply {
            setContent {    // setting our composable as content for test
                AppTheme {
                    authViewModel = hiltViewModel<AuthViewModel>()
                    investmentViewModel = hiltViewModel<InvestmentViewModel>()
                    LoginScreen(
                        investmentViewModel = investmentViewModel,
                        authViewModel = authViewModel
                    )
                }
            }
        }
        testRule.onNode(hasText("Login, here")).assertExists()
        //testRule.onNodeWithTag(ComposableTags.USERNAME_FORM_FIELD).assertExists().performClick().performTextInput("qazeem")
        //testRule.onNodeWithTag(ComposableTags.PASSWORD_FORM_FIELD).assertExists().performClick().performTextInput("qazeem")
        //testRule.onRoot().printToLog("TAG")
    }
}



//    @Inject
//    lateinit var authViewModel: AuthViewModel

//    @Inject
//    lateinit var investmentViewModel: InvestmentViewModel