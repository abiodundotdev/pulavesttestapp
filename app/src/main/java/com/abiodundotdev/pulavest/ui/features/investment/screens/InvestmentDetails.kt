package com.abiodundotdev.pulavest.ui.features.investment.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.abiodundotdev.pulavest.core.constants.Routes
import com.abiodundotdev.pulavest.domain.aliases.ListOfInvestments
import com.abiodundotdev.pulavest.domain.models.Investment
import com.abiodundotdev.pulavest.domain.models.User
import com.abiodundotdev.pulavest.ui.composables.AppScaffold
import com.abiodundotdev.pulavest.ui.composables.FilledButton
import com.abiodundotdev.pulavest.ui.composables.PAppTopAppBar
import com.abiodundotdev.pulavest.ui.features.auth.LoginState
import com.abiodundotdev.pulavest.ui.features.profile.screens.InvestmentCard
import com.google.accompanist.flowlayout.MainAxisAlignment
import java.time.format.DateTimeFormatter
import java.util.*

@Composable
fun InvestmentDetailsScreen(investmentId: Int, investmentViewModel: InvestmentViewModel) {

    //val investmentViewModel = hiltViewModel<InvestmentViewModel>();

     //val viewModel: InvestmentViewModel by activityViewModels()

    val investmentState  = investmentViewModel.investmentState.collectAsState().value;
    val typography = MaterialTheme.typography;
    AppScaffold(appBar = { PAppTopAppBar {
        InvestmentStateBuilder(investmentState = investmentState) {investments ->
            val investment : Investment? = investments.find { it.id == investmentId };
            Text(investment?.name ?: "")
        }
} }) {
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


               Box( modifier = Modifier
                   .fillMaxWidth(1.0f)
                   .height(180.0.dp).width(300.dp)
                   .clip(RoundedCornerShape(20.dp)),
                   ) {
                   AsyncImage(
                       model = investment?.image_url,
                       contentDescription = "s",
                       contentScale = ContentScale.FillBounds,
                       )
               }
                Spacer(modifier = Modifier.height(10.0.dp))
                Text(text = investment?.name ?: "N/A", style = MaterialTheme.typography.h6, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(10.0.dp))

                Text(text = "Investment Details", style = MaterialTheme.typography.subtitle1, fontWeight = FontWeight.Normal)
                Spacer(modifier = Modifier.height(10.0.dp))
                Text(text = investment?.description ?: "N/A", style = MaterialTheme.typography.body2, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(10.0.dp))
                InfoRow(title = "Closing date", value = "10, January 2022")
                Spacer(modifier = Modifier.height(10.0.dp))
                InfoRow(title = "Maturity date", value = "10, January 2022")
                Spacer(modifier = Modifier.height(10.0.dp))
                InfoRow(title = "Estimated start date", value = "10, January 2022")
                Spacer(modifier = Modifier.height(10.0.dp))
                InfoRow(title = "Estimated amount", value = "${investment?.amount}")
                Spacer(modifier = Modifier.height(20.0.dp))
                FilledButton(onClick = { investmentViewModel.navigator.navigate(Routes.Invest+"/${investment?.id}") }, text = "Invest now")

            }
        }

}
}

@Composable
fun InfoRow(title: String, value : String) {
    Row(horizontalArrangement = Arrangement.SpaceBetween){
        Text(text = title)
        Text(text = value)
    }
}

@Composable
fun InvestmentStateBuilder(investmentState: InvestmentState, content  :  @Composable (ListOfInvestments) -> Unit){
    when (investmentState) {
        is InvestmentState.Error -> Text(text = "Something went wrong")
        is InvestmentState.Loading -> CircularProgressIndicator()
        is InvestmentState.Success -> content(investmentState.investments)
    }
}