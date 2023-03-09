package com.abiodundotdev.pulavest.ui.features.profile.screens

import android.widget.Space
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import coil.compose.AsyncImage
import com.abiodundotdev.pulavest.core.constants.Routes
import com.abiodundotdev.pulavest.domain.models.Investment
import com.abiodundotdev.pulavest.domain.models.User
import com.abiodundotdev.pulavest.ui.composables.*
import com.abiodundotdev.pulavest.ui.features.auth.AuthViewModel
import com.abiodundotdev.pulavest.ui.features.auth.LoginState
import com.abiodundotdev.pulavest.ui.features.investment.screens.InvestmentState
import com.abiodundotdev.pulavest.ui.features.investment.screens.InvestmentViewModel
import com.abiodundotdev.pulavest.ui.theme.AppTheme

@Composable
fun DashBoardScreen( investmentViewModel: InvestmentViewModel, authViewModel: AuthViewModel) {
    val loginState  = authViewModel.loginState.collectAsState().value;
    val investmentState  = investmentViewModel.investmentState.collectAsState().value;
    var typography = MaterialTheme.typography;
    AppScaffold(appBar = {
        PAppTopAppBar(title = { Row() {
            Box(modifier = Modifier
                .clip(CircleShape)
                .size(40.0.dp)){}
            Spacer(modifier = Modifier.width(4.0.dp))
            Column() {
                Text(text = "Welcome", style =  MaterialTheme.typography.caption.copy(fontSize = 10.0.sp) , fontWeight = FontWeight.ExtraLight)
                UserStateBuilder(loginState = loginState) {
                    Text(text = it.fullname.capitalize(), style = typography.subtitle2  )
                }
                Spacer(modifier = Modifier.fillMaxWidth())
            }
        }})
    }) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),
        ) {
        //  .verticalScroll(rememberScrollState())

        AppTextField(value = "", onValueChange = {}, label = "")
        Spacer(modifier = Modifier.height(10.0.dp))
        Text(text = "Trending")
        when (investmentState) {
            is InvestmentState.Error -> Text(text = "Something went wrong")
            is InvestmentState.Loading -> CircularProgressIndicator()
            is InvestmentState.Success -> { LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 128.dp) ,
                contentPadding = PaddingValues(12.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(investmentState.investments.size) { index ->
                    InvestmentCard(investment = investmentState.investments[index])
                }
            } }
        }
        }
    }
}
@Composable
fun InvestmentCard(investment: Investment) {
    val composeView = LocalView.current
    val investmentViewModel = composeView.findViewTreeViewModelStoreOwner()?.let {
        hiltViewModel<InvestmentViewModel>(it)
    }!!

    Card(shape = RoundedCornerShape(15.0.dp), elevation = 1.dp, modifier = Modifier.width(143.dp).clickable {
        investmentViewModel.navigator.navigate(Routes.InvestmentDetails+"/${investment.id}")
    }

    ) {
     Column() {
         Box(){
             AsyncImage(
                 model = investment.image_url,
                 contentDescription = "Translated description of what the image contains"
             )
         }
        Column(modifier = Modifier.padding(10.0.dp)) {
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = investment.name, style = MaterialTheme.typography.overline, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "${investment.percentage}%  in ${investment.duration} Months", style = MaterialTheme.typography.overline.copy(fontSize = 8.0.sp ), fontWeight = FontWeight.Thin)
            Spacer(modifier = Modifier.height(10.dp))
            GhostButton(onClick = { /*TODO*/ }, text =  "Invest now", fractionalSize = .5f)
            Spacer(modifier = Modifier.height(13.dp))
        }

     }   
    }    
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppTheme {
       // DashBoardScreen()
    }
}

@Composable
fun UserStateBuilder(loginState: LoginState, content  :  @Composable (User) -> Unit){
    when (loginState) {
        is LoginState.Error -> Text(text = "Something went wrong")
        is LoginState.Initial -> CircularProgressIndicator()
        is LoginState.Loading -> CircularProgressIndicator()
        is LoginState.Success -> content(loginState.data.user)
    }
}



//    val authViewModel = hiltViewModel<AuthViewModel>()
//    val investmentViewModel = hiltViewModel<InvestmentViewModel>()
//    val composeView = LocalView.current
//    val investmentViewModel = composeView.findViewTreeViewModelStoreOwner()?.let {
//        hiltViewModel<InvestmentViewModel>(it)
//    }!!
//    val authViewModel = composeView.findViewTreeViewModelStoreOwner()?.let {
//    hiltViewModel<AuthViewModel>(it)
//    }!!