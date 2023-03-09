package com.abiodundotdev.pulavest.ui.features.investment.screens

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abiodundotdev.pulavest.core.AppNavigator
import com.abiodundotdev.pulavest.core.constants.Routes
import com.abiodundotdev.pulavest.data.repository.AuthRepository
import com.abiodundotdev.pulavest.data.repository.InvestmentRepository
import com.abiodundotdev.pulavest.domain.requestdatas.LoginRequestData
import com.abiodundotdev.pulavest.domain.requestdatas.RegisterRequestData
import com.abiodundotdev.pulavest.ui.features.auth.LoginState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InvestmentViewModel @Inject constructor
    (
    private val investmentRepository: InvestmentRepository,
    private val appNavigator: AppNavigator,
)  : ViewModel() {
    private val _uiState = MutableStateFlow<InvestmentState>(InvestmentState.Loading());
    val investmentState : StateFlow<InvestmentState> = _uiState.asStateFlow();
    val navigator = appNavigator;
    fun getInvestments(){
        viewModelScope.launch(Dispatchers.Main) {
            _uiState.emit(InvestmentState.Loading());
            try {
                val response = investmentRepository.getInvestments()
                Log.i("", "Error")
                if (response.isSuccessful) {
                    val body = response.body()
                    body?.let {
                        Log.e("app_error", "something went wrong)");
                        _uiState.emit(InvestmentState.Success(body));
                    }
                    Log.e("app_error", "something went wrong before navigation");
                    //appNavigator.navigate(Routes.Register)
                }
            } catch (e: Exception) {
                Log.e("app_error", "something went wrong in error stack");

                Log.e("app_error", e.toString());
                _uiState.emit(InvestmentState.Error("something went wrong"));
                appNavigator.navigate(Routes.Register)

            }
        }

    }

}