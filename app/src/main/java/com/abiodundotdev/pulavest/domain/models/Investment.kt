package com.abiodundotdev.pulavest.domain.models

data class Investment(
    val address: String,
    val amount: Int,
    val current_investors: Int,
    val date: String,
    val description: String,
    val duration: Int,
    val end_date: String,
    val id: Int,
    val image_url: String,
    val name: String,
    val percentage: Int,
    val rio: Int,
    val start_date: String
)