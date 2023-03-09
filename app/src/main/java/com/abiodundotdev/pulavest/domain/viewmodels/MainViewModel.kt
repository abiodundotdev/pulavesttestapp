package com.abiodundotdev.pulavest.domain.viewmodels

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abiodundotdev.pulavest.domain.models.ProductModel
import com.abiodundotdev.pulavest.domain.responses.GetProductsResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

//@HiltViewModel
//class MainViewModel @Inject constructor
//    (
//    private val repository: StoreRepository,
//) : ViewModel() {
//    private val _response: MutableLiveData<GetProductsResponse<List<ProductModel>>> = MutableLiveData()
//    val response: LiveData<GetProductsResponse<List<ProductModel>>> = _response
//    fun fetchProductsResponse() = viewModelScope.launch {
//        repository.getProducts().collect { values ->
//            _response.value = values
//        }
//    }
//}