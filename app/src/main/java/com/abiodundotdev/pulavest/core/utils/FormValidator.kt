package com.abiodundotdev.pulavest.core.utils

class FormValidator {
    companion object{
        fun empty(value: String, field : String? ) : String{
            if(value.isEmpty()) return  "${field ?: "field"} is required"
            return  "";
        }

        fun number(value: String, field : String?) : String{
            val num: Int? =  value.toIntOrNull();
            if(num === null) return  "${field ?: "field"} must be a number"
            return  "";
        }
    }
}