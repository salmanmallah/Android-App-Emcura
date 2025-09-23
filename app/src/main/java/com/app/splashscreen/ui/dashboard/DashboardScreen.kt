package com.app.splashscreen.ui.dashboard


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.app.splashscreen.R
import com.app.splashscreen.ui.components.SearchBar
import com.app.splashscreen.ui.components.DashboardIconGrid
import com.app.splashscreen.ui.components.BottomNavbar
import androidx.compose.runtime.Composable
import com.app.splashscreen.ui.components.DashboardStatusCard
import com.app.splashscreen.ui.components.DocToDocPopup
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun DashboardScreen(navController: NavController) {
    var showDocToDocPopup by remember { mutableStateOf(false) }
    var showInstantConnectPopup by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.dashboard_background))
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_dashboard_background_pattern),
            contentDescription = null,
            modifier = Modifier
                .size(280.dp)
                .align(Alignment.TopEnd)
                .offset(x = (-16).dp, y = -16.dp),
            alpha = 0.25f // subtle overlay
        )


        // Top icons row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp, start = 24.dp, end = 24.dp)
                .align(Alignment.TopCenter),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_dashboard_top_sider),
                contentDescription = "Menu",
                modifier = Modifier.size(25.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_dashboard_bell),
                contentDescription = "Notifications",
                modifier = Modifier.size(25.dp)
            )
        }


        // Add DashboardStatusCard below top icons
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Top icons ke liye space
            Spacer(modifier = Modifier.height(70.dp))

            // Dashboard Status Card
            DashboardStatusCard()

            // Card aur neeche container ke beech gap
            Spacer(modifier = Modifier.height(40.dp))




            // White rounded container
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                    .background(Color.White)
                    .verticalScroll(rememberScrollState()) // scroll added to the container
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp, vertical = 24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    SearchBar(
                        value = "",
                        onValueChange = {},
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(25.dp))

                    DashboardIconGrid(
                        icons = listOf(
                            R.drawable.ic_dashboard_connect to "Doc to Doc",
                            R.drawable.ic_dashboard_mic to "Clinic Patient",
                            R.drawable.ic_dashboard_prescription to "My Prescriptions",
                            R.drawable.ic_dashboard_call to "Call History",
                            R.drawable.ic_dashboard_connect to "Instant Connect",
                            R.drawable.ic_dashboard_refill to "Refill Request",
                            // R.drawable.ic_dashboard_bell_patientcare to "Patient Care"
                        ),
                        onIconClick = { index ->
                            when (index) {
                                0 -> showDocToDocPopup = true
                                1 -> navController.navigate("onlinecarepatients")
                                2 -> navController.navigate("prescription")
                                5 -> navController.navigate("refill_request")
                                // 6 -> navController.navigate("patientcare")
                            }
                        },
                        onInstantConnectClick = {
                            showInstantConnectPopup = true
                        }
                    )
                    if (showDocToDocPopup) {
                        DocToDocPopup(
                            onDismiss = { showDocToDocPopup = false },
                            onDocToDocClick = { showDocToDocPopup = false },
                            onDocToCpClick = {
                                showDocToDocPopup = false
                                navController.navigate("doctocp")
                            },
                            navController = navController
                        )
                    }
                    if (showInstantConnectPopup) {
                        com.app.splashscreen.ui.components.InstantConnectPopup(
                            onDismiss = { showInstantConnectPopup = false },
                            onExistingPatient = { showInstantConnectPopup = false },
                            onNewPatient = { showInstantConnectPopup = false },
                            onCancel = { showInstantConnectPopup = false }
                        )
                    }

                    Spacer(modifier = Modifier.height(25.dp))

                    Image(
                        painter = painterResource(id = R.drawable.ic_dashboard_card),
                        contentDescription = "Dashboard Card"
                    )
                    Spacer(modifier = Modifier.height(200.dp))
                }
            } // end of White rounded container



        }




        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        ) {
            BottomNavbar(
                icons = listOf(
                    R.drawable.ic_dashboard_power,
                    R.drawable.ic_dashboard_waitingroom,
                    R.drawable.ic_dashboard_support,
                    R.drawable.ic_dashboard_masseges,
                ),
                centerImageResId = R.drawable.ic_dashboard_bell_patientcare,
                onIconClick = { index ->
                    // 0: Power, 1: Waiting Room, 2: Support, 3: Messages, 4: Center (Patient Care)
                    if (index == 4) {
                        navController.navigate("patientcare")
                    }
                    // ...yahan baqi icons ke triggers bhi add kar sakte hain...
                }
            )
        }


    }
}

@Preview(
    showBackground = true,
//    widthDp = 1080,
//    heightDp = 2400,
)
@Composable
fun DashboardScreenPreview() {
    val navController = rememberNavController()
    DashboardScreen(navController)
}


