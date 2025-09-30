package com.app.emcura.ui.aisuggesteddiagnosis

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import com.app.emcura.R
import com.app.emcura.ui.components.DashboardIconGrid
import com.app.emcura.ui.components.BottomNavbar
import androidx.compose.runtime.Composable
import com.app.emcura.ui.components.DashboardStatusCard
import com.app.emcura.ui.components.DocToDocPopup
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.app.emcura.ui.components.AISuggestedDiagnosisButtonCard
import com.app.emcura.ui.components.AISuggestedDiagnosisTextCard
import com.app.emcura.ui.components.CallHistoryOptionBottomButtons
import com.app.emcura.ui.components.CallHistoryOptionNotes
import com.app.emcura.ui.components.CallHistoryOptionsProfileCard
import com.app.emcura.ui.components.DashboardTopBar
import com.app.emcura.ui.components.DoctorSearchBar

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
            title = "AI suggested diagnosis ",
            backIconRes = R.drawable.ic_dashboard_arrow_backward,
            endIconRes = R.drawable.ic_dcd_hospital,
            showBackIcon = true,
            showEndIcon = true,
            textColor = Color.White,
            onBackClick = { navController?.popBackStack() },
            onEndIconClick = { navController?.navigate("dashboard") }
        )

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            AISuggestedDiagnosisTextCard()

            Spacer(modifier = Modifier.height(5.dp))

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

                    Spacer(modifier = Modifier.height(18.dp))

                    // Description
                    Text(
                        text = "Description:",
                        color = Color(0xFFEB474B),
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        modifier = Modifier
                            .align(Alignment.Start)
                            .padding(start = 8.dp, bottom = 4.dp)
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(140.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(Color.White)
                            .border(1.dp, Color(0xFFBDBDBD), RoundedCornerShape(12.dp))
                    ) {}

                    Spacer(modifier = Modifier.height(18.dp))

                    // Care Plan
                    Text(
                        text = "Care Plan:",
                        color = Color(0xFFED202E),
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        modifier = Modifier
                            .align(Alignment.Start)
                            .padding(start = 8.dp, bottom = 4.dp)
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(140.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(Color.White)
                            .border(1.dp, Color(0xFFBDBDBD), RoundedCornerShape(12.dp))
                    ) {}

                    Spacer(modifier = Modifier.height(32.dp))

                    Button(
                        onClick = { /* TODO: Done action */ },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEB474B)),
                        shape = RoundedCornerShape(16.dp),
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .height(48.dp)
                    ) {
                        Text("Done", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }
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
