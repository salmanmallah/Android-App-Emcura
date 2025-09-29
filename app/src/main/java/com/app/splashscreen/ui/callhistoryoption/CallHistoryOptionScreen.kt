package com.app.splashscreen.ui.callhistoryoption

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
import com.app.splashscreen.ui.components.CallHistoryOptionBottomButtons
import com.app.splashscreen.ui.components.CallHistoryOptionNotes
import com.app.splashscreen.ui.components.CallHistoryOptionsProfileCard
import com.app.splashscreen.ui.components.DashboardTopBar
import com.app.splashscreen.ui.components.DoctorSearchBar

@Composable
fun CallHistoryOptionScreen(navController: NavController) {
    var showDocToDocPopup by remember { mutableStateOf(false) }
    var showInstantConnectPopup by remember { mutableStateOf(false) }
    var searchQuery by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.dashboard_background))
    ) {

        DashboardTopBar(
            title = "Available Doctors",
            backIconRes = R.drawable.ic_dashboard_arrow_backward,
            endIconRes = R.drawable.ic_dcd_hospital,
            showBackIcon = true,
            showEndIcon = true,
            textColor = Color.White,
            onBackClick = { navController?.popBackStack() },
            onEndIconClick = { navController?.navigate("dashboard") }
        )

        // Add DashboardStatusCard below top icons
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Top icons ke liye space
            Spacer(modifier = Modifier.height(30.dp))

            // Dashboard Status Card
            CallHistoryOptionsProfileCard()

            // Card aur neeche container ke beech gap
            Spacer(modifier = Modifier.height(5.dp))

            // White rounded container
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .clip(RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
                    .background(
                        brush = androidx.compose.ui.graphics.Brush.verticalGradient(
                            colors = listOf(
                                Color(0xFFF8F8F8),
                                Color.White,
                                Color(0xFFF8F8F8),
                                Color(0xFFFDE6EA),
                                Color(0xFFD3A8AC)
                            ),
                            startY = 0f,
                            endY = 1200f
                        )
                    )
                    .verticalScroll(rememberScrollState())
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp, vertical = 24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {


                    Spacer(modifier = Modifier.height(15.dp))
                    CallHistoryOptionNotes()
                    Spacer(modifier = Modifier.height(15.dp))
                    CallHistoryOptionNotes()
                    Spacer(modifier = Modifier.height(200.dp))
                }
            } // end of White rounded container
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        ) {
           // idhr ayengy saary icons
            CallHistoryOptionBottomButtons(
                recallIcon = R.drawable.ic_recall,
                notesIcon = R.drawable.ic_encounter_notes,
                labIcon = R.drawable.ic_lab_requests,
                messageIcon = R.drawable.ic_message,
                prescriptionIcon = R.drawable.ic_prescription,
                dischargeIcon = R.drawable.ic_discharge_summary
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
fun CallHistoryOptionScreenPreview() {
    val navController = rememberNavController()
    CallHistoryOptionScreen(navController)
}
