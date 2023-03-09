package com.abiodundotdev.pulavest.ui.features.auth

import android.util.Log
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.abiodundotdev.pulavest.core.AppNavigator
import com.abiodundotdev.pulavest.core.constants.Routes
import com.abiodundotdev.pulavest.data.repository.AuthRepository
import com.abiodundotdev.pulavest.domain.requestdatas.LoginRequestData
import com.abiodundotdev.pulavest.domain.requestdatas.RegisterRequestData
import com.abiodundotdev.pulavest.domain.responses.GetProductsResponse
import com.abiodundotdev.pulavest.domain.responses.LoginResponseData
import com.abiodundotdev.pulavest.ui.features.investment.screens.InvestmentViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.concurrent.Flow
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor
    (
    private val authRepository: AuthRepository,
    private val appNavigator: AppNavigator,

    )  : ViewModel() {
    private val _uiState = MutableStateFlow<LoginState>(LoginState.Initial());
    val loginState : StateFlow<LoginState> = _uiState.asStateFlow();

    fun login(loginRequestData : LoginRequestData){
        viewModelScope.launch(Dispatchers.Main) {
            _uiState.emit(LoginState.Loading());
            try {
                val response = authRepository.login(loginRequestData)
                Log.i("", "Error")
                if (response.isSuccessful) {
                    val body = response.body()
                    body?.let {
                        Log.e("app_error", "something went wrong)");
                        _uiState.emit(LoginState.Success(body));
                        appNavigator.navigate(Routes.DashBoard)
                    }
                    Log.e("app_error", "something went wrong before navigation");
                }
            } catch (e: Exception) {
                Log.e("app_error", "something went wrong in error stack");

                Log.e("app_error", e.toString());
                _uiState.emit(LoginState.Error("something went wrong"));
                appNavigator.navigate(Routes.Register)

            }
        }
        fun register(registerRequestData : RegisterRequestData){
            viewModelScope.launch(Dispatchers.Main) {
                _uiState.emit(LoginState.Loading());
                try {
                    val response = authRepository.register(registerRequestData)
                    Log.i("", "Error")
                    if (response.isSuccessful) {
                        val body = response.body()
                        body?.let {
                            Log.e("app_error", "something went wrong)");
                            _uiState.emit(LoginState.Success(body));
                        }
                        Log.e("app_error", "something went wrong before navigation");
                        appNavigator.navigate(Routes.Login)
                    }
                } catch (e: Exception) {
                    Log.e("app_error", "something went wrong in error stack");

                    Log.e("app_error", e.toString());
                    _uiState.emit(LoginState.Error("something went wrong"));
                    appNavigator.navigate(Routes.Register)

                }
            }
        }
    }

}