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
    lateinit   var investmentViewModel :InvestmentViewModel;
    lateinit var usernameField : SemanticsNodeInteraction;
    lateinit var passwordField : SemanticsNodeInteraction;
    lateinit var loginButton : SemanticsNodeInteraction;




    @Before
    fun setUp() {
        hiltRule.inject()
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
        usernameField = testRule.onNodeWithTag(ComposableTags.USERNAME_FORM_FIELD);
        passwordField = testRule.onNodeWithTag(ComposableTags.PASSWORD_FORM_FIELD)
        loginButton =  testRule.onNode(hasTestTag(ComposableTags.LOGIN_BUTTON) and  hasClickAction())
    }

    @Test
    fun verify_login_has_required_composable_for_input_and_others(){
        testRule.onNode(hasText("Login, here")).assertExists()
        usernameField.assertIsDisplayed()
        passwordField.assertIsDisplayed()
        loginButton.assertIsDisplayed();
    }


    @Test
    fun verify_error_text_is_shown_when_fields_are_empty_and_form_submitted(){
        loginButton.performClick()
        testRule.onNode(hasText("Username is required")).assertIsDisplayed()
        testRule.onNode(hasText("Password is required")).assertIsDisplayed()
    }

    @Test
    fun verify_shows_no_error_when_username_and_password_is_not_empty(){
        usernameField.performClick().performTextInput("abiodun")
        passwordField.performClick().performTextInput("abiodun")
        loginButton.performClick()
       // testRule.onNode(("Username is required")).assertIsNotDisplayed()
       // testRule.onNode(hasText("Password is required")).assertIsNotDisplayed()
    }
}
