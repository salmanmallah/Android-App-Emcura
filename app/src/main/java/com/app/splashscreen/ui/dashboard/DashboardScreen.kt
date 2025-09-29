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
import com.app.splashscreen.ui.components.DashboardIconGrid
import com.app.splashscreen.ui.components.BottomNavbar
import androidx.compose.runtime.Composable
import com.app.splashscreen.ui.components.DashboardStatusCard
import com.app.splashscreen.ui.components.DocToDocPopup
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.app.splashscreen.ui.components.DoctorSearchBar


@Composable
fun DashboardScreen(navController: NavController) {
    var showDocToDocPopup by remember { mutableStateOf(false) }
    var showInstantConnectPopup by remember { mutableStateOf(false) }
    var searchQuery by remember { mutableStateOf("") }

    // List of all icons with tags for search
    val allIcons = listOf(
        Triple(R.drawable.ic_dashboard_connect, "Doc to Doc", "doc"),
        Triple(R.drawable.ic_dashboard_mic, "Clinic Patient", "patient"),
        Triple(R.drawable.ic_dashboard_prescription, "My Prescriptions", "prescription"),
        Triple(R.drawable.ic_dashboard_call, "Call History", "call"),
        Triple(R.drawable.ic_dashboard_connect, "Instant Connect", "instant doc"),
        Triple(R.drawable.ic_dashboard_refill, "Refill Request", "refill"),
    )

    // Filter icons by search query
    val filteredIcons = remember(searchQuery) {
        if (searchQuery.isBlank()) allIcons
        else allIcons.filter { triple ->
            triple.second.contains(searchQuery, ignoreCase = true) ||
            triple.third.contains(searchQuery, ignoreCase = true)
        }
    }

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
                    OutlinedTextField(
                        value = searchQuery,
                        onValueChange = { searchQuery = it },
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = { Text("Search") },
                        singleLine = true,
                        trailingIcon = {
                            if (searchQuery.isNotEmpty()) {
                                // ❌ Cross image
                                IconButton(onClick = { searchQuery = "" }) {
                                    Image(
                                        painter = painterResource(id = R.drawable.dashboard_cross),
                                        contentDescription = "Clear Search"
                                    )
                                }
                            } else {
                                // 🔍 Search image
                                Image(
                                    painter = painterResource(id = R.drawable.ic_dashboard_search),
                                    contentDescription = "Search Icon"
                                )
                            }
                        },
                        shape = RoundedCornerShape(24.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color(0xFFC2185B),
                            unfocusedBorderColor = Color(0xFFE0E0E0)
                        )
                    )

                    Spacer(modifier = Modifier.height(25.dp))

                    DashboardIconGrid(
                        icons = filteredIcons.map { it.first to it.second },
                        onIconClick = { index ->
                            // Map index to filteredIcons
                            val label = filteredIcons.getOrNull(index)?.second ?: ""
                            when (label) {
                                "Doc to Doc" -> showDocToDocPopup = true
                                "Clinic Patient" -> navController.navigate("onlinecarepatients")
                                "My Prescriptions" -> navController.navigate("prescription")
                                "Call History" -> navController.navigate("callhistory")
                                "Refill Request" -> navController.navigate("refill_request")
                                "Instant Connect" -> showInstantConnectPopup = true
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
                            navController = navController,
                            onDismiss = { showInstantConnectPopup = false },
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
                    when (index) {
                        0 -> navController.navigate("start") // Shutdown/Power icon → Login screen
                        1 -> navController.navigate("waitingroom")
                        2 -> navController.navigate("callhistory") // Support icon (man with mic) → Call History
                        3 -> navController.navigate("messages")
                        4 -> navController.navigate("patientcare")
                    }
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


