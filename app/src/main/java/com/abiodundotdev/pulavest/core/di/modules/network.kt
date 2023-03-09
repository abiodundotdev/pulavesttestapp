package com.abiodundotdev.pulavest.core.di.modules

import com.abiodundotdev.pulavest.core.constants.EndPoints
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class Network {
    companion object{
        val instance : Retrofit =   Retrofit.Builder()
            .baseUrl(EndPoints.BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    }
}