package com.abiodundotdev.pulavest.domain.models

data class CartModel(
    val date: String,
    val id: Int,
    val products: List<Product>,
    val userId: Int
)