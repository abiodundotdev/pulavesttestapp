package com.abiodundotdev.pulavest.ui.features.investment.screens


import com.abiodundotdev.pulavest.domain.aliases.ListOfInvestments
import com.abiodundotdev.pulavest.domain.responses.LoginResponseData

sealed class InvestmentState() {
    data class Success(val investments: ListOfInvestments) : InvestmentState();
    data  class Error(val message: String) : InvestmentState();
    class Loading() : InvestmentState();
}