package com.abiodundotdev.pulavest.ui.features.profile.screens

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.abiodundotdev.pulavest.core.AppNavigator
import com.abiodundotdev.pulavest.core.constants.Routes
import com.abiodundotdev.pulavest.data.repository.AuthRepository
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
class ProfileViewModel @Inject constructor
    (
    private val appNavigator: AppNavigator,
)  : ViewModel() {

    val navigator : AppNavigator = appNavigator;


}