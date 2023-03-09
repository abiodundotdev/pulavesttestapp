package com.abiodundotdev.pulavest.domain.models

data class User(
    val address: String,
    val created_at: String,
    val device_id: String,
    val email: String,
    val email_verified_at: String,
    val first_name: String,
    val fullname: String,
    val id: Int,
    val is_email_verified: Int,
    val last_login: String,
    val last_name: String,
    val phone_no: Long,
    val status: Int,
    val trans_pin: Int,
    val updated_at: String,
    val wallet_balance: Int,
    val wallet_id: String
)