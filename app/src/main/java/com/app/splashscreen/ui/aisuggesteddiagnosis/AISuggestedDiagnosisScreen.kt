package com.app.splashscreen.ui.aisuggesteddiagnosis

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
import com.app.splashscreen.ui.components.AISuggestedDiagnosisButtonCard
import com.app.splashscreen.ui.components.AISuggestedDiagnosisTextCard
import com.app.splashscreen.ui.components.CallHistoryOptionBottomButtons
import com.app.splashscreen.ui.components.CallHistoryOptionNotes
import com.app.splashscreen.ui.components.CallHistoryOptionsProfileCard
import com.app.splashscreen.ui.components.DashboardTopBar
import com.app.splashscreen.ui.components.DoctorSearchBar

@Composable
fun AISuggestedDiagnosisScreen(navController: NavController) {
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
            onBackClick = { navController?.popBackStack() }
        )

        // Add DashboardStatusCard below top icons
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Top icons ke liye space
            Spacer(modifier = Modifier.height(50.dp))

            // Dashboard Status Card
            AISuggestedDiagnosisTextCard()

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
                        .padding(horizontal = 10.dp, vertical = 24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    AISuggestedDiagnosisButtonCard()
                }
            } // end of White rounded container
        }


    }
}

@Preview(
    showBackground = true,
)
@Composable
fun AISuggestedDiagnosisScreenPreview() {
    val navController = rememberNavController()
    AISuggestedDiagnosisScreen(navController)
}
