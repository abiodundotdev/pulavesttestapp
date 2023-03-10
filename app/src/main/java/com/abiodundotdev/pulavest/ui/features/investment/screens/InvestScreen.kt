package com.abiodundotdev.pulavest.ui.features.investment.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.abiodundotdev.pulavest.domain.aliases.ListOfInvestments
import com.abiodundotdev.pulavest.domain.models.Investment
import com.abiodundotdev.pulavest.ui.composables.*
import java.util.*

@Composable
fun InvestScreen(investmentId: Int, investmentViewModel: InvestmentViewModel) {
    val investmentState  = investmentViewModel.investmentState.collectAsState().value;
    val typography = MaterialTheme.typography;
    AppScaffold(appBar = { PAppTopAppBar {
       Text(text = "Invest now")
    }
        })
     {
        InvestmentStateBuilder(investmentState = investmentState) {investments ->
            val investment : Investment? = investments.find { it.id == investmentId };
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                AppTextField(value = "", onValueChange = {}, label = "Amount to invest " )
                ColumnGap(size = 10.0.dp)
                InfoRow(title = "Closing date", value = "10, January 2022")
                ColumnGap(size = 10.0.dp)
                InfoRow(title = "Maturity date", value = "10, January 2022")
                ColumnGap(size = 10.0.dp)
                InfoRow(title = "Estimated start date", value = "10, January 2022")
                ColumnGap(size = 10.0.dp)
                InfoRow(title = "Estimated amount", value = "${investment?.amount}")
                ColumnGap(size = 10.0.dp)
                FilledButton(onClick = {  }, text = "Invest now")
            }
        }

    }
}




//val investmentViewModel = hiltViewModel<InvestmentViewModel>();
//val viewModel: InvestmentViewModel by activityViewModels()