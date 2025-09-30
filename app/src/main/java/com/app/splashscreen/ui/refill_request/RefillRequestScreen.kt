package com.app.splashscreen.ui.refill_request

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.app.splashscreen.R
import com.app.splashscreen.ui.components.DashboardTopBar
import com.app.splashscreen.ui.components.RefillRequestDetailsCard

@Composable
fun RefillRequestScreen(navController: NavController? = null) {
    val dropdownOptions = listOf(
        "Nurse", "Nurse Practitioner", "Social Worker", "Dietition", "OT/OPT",
        "Pharmacist", "Office Manager", "Medical Assistant", "Supervisor"
    )
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("Other") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(vertical = 8.dp)
            ,
            contentAlignment = Alignment.Center
        ) {
            DashboardTopBar(
                title = "Refill Request",
                backIconRes = R.drawable.ic_dashboard_arrow_backward,
                endIconRes = R.drawable.ic_dcd_hospital,
                showBackIcon = true,
                showEndIcon = true,
                onBackClick = { navController?.popBackStack() },
                onEndIconClick = { navController?.navigate("dashboard") }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
                .weight(1f)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            RefillRequestDetailsCard(navController = navController)

            Spacer(modifier = Modifier.height(16.dp))
            RefillRequestDetailsCard(navController = navController)

            Spacer(modifier = Modifier.height(16.dp))
            RefillRequestDetailsCard(navController = navController)

            Spacer(modifier = Modifier.height(16.dp))
            RefillRequestDetailsCard(navController = navController)

            Spacer(modifier = Modifier.height(200.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RefillRequestScreenPreview() {
    RefillRequestScreen()
}
