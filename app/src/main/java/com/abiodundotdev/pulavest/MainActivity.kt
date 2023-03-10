package com.abiodundotdev.pulavest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.abiodundotdev.pulavest.core.AppNavigator
import com.abiodundotdev.pulavest.core.constants.Routes
import com.abiodundotdev.pulavest.ui.features.SecondarySlashScreen
import com.abiodundotdev.pulavest.ui.features.auth.AuthViewModel
import com.abiodundotdev.pulavest.ui.features.auth.screens.LoginScreen
import com.abiodundotdev.pulavest.ui.features.auth.screens.RegisterScreen
import com.abiodundotdev.pulavest.ui.features.investment.screens.InvestScreen
import com.abiodundotdev.pulavest.ui.features.investment.screens.InvestmentDetailsScreen
import com.abiodundotdev.pulavest.ui.features.investment.screens.InvestmentViewModel
import com.abiodundotdev.pulavest.ui.features.profile.screens.DashBoardScreen
import com.abiodundotdev.pulavest.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity  : ComponentActivity() {
    @Inject lateinit var appNavigator: AppNavigator;
    private val authViewModel: AuthViewModel by viewModels();
    private val investmentViewModel : InvestmentViewModel by  viewModels();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            appNavigator.setController(navController)
            AppTheme{
                NavHost(navController = navController, startDestination = Routes.Splash) {
                    composable(Routes.Login) {LoginScreen(investmentViewModel, authViewModel)}
                    composable(Routes.Register) { RegisterScreen() }
                    composable(Routes.Splash) { SecondarySlashScreen() }
                    composable(Routes.DashBoard) { DashBoardScreen(
                        investmentViewModel, authViewModel
                    ) }
                    composable(
                        Routes.Invest+"/{investmentId}",
                        arguments = listOf(navArgument("investmentId") { type = NavType.IntType})
                    ){ backStackEntry ->
                        backStackEntry.arguments?.getInt("investmentId")
                            ?.let { InvestScreen(it, investmentViewModel) }
                    }
                    composable(
                        Routes.InvestmentDetails+"/{investmentId}",
                        arguments = listOf(navArgument("investmentId") { type = NavType.IntType})
                    ){ backStackEntry ->
                        backStackEntry.arguments?.getInt("investmentId")
                            ?.let { InvestmentDetailsScreen(it, investmentViewModel) }
                    }

                }
            }
        }
    }
}