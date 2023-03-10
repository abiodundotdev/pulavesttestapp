package com.abiodundotdev.pulavest.core

import androidx.navigation.NavHostController
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class AppNavigator @Inject constructor(){
    private var navController: NavHostController? = null

    fun setController(controller: NavHostController) {
        navController = controller
    }

    fun clear() {
        navController = null
    }
    fun navigate( route : String) {
        navController?.navigate(route)
    }

    fun goBack() {
        navController?.popBackStack()
    }
}