package com.app.emcura.ui.waitingroom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.app.emcura.R
import com.app.emcura.ui.components.DashboardTopBar
import com.app.emcura.ui.components.WaitingRoomProfileCard

@Composable
fun WaitingRoomScreen(navController: NavController? = null) {
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
                .padding(vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            DashboardTopBar(
                title = "Waiting Room",
                backIconRes = R.drawable.ic_dashboard_arrow_backward,
                endIconRes = R.drawable.ic_dcd_hospital,
                showBackIcon = true,
                showEndIcon = true,
                onBackClick = { navController?.popBackStack() },
                onEndIconClick = { navController?.navigate("dashboard") }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            item {
                WaitingRoomProfileCard(
                    name = "Elizabeth Weisberg",
                    online = true,
                    onAcceptClick = { navController?.navigate("connecttodoctor") }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WaitingRoomScreenPreview() {
    WaitingRoomScreen()
}

