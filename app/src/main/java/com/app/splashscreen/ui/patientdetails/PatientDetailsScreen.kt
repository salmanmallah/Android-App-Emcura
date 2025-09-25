package com.app.splashscreen.ui.patientdetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.app.splashscreen.R
import com.app.splashscreen.ui.components.CallHistoryOptionBottomButtons
import com.app.splashscreen.ui.components.CallHistoryOptionNotes
import com.app.splashscreen.ui.components.CallHistoryOptionsProfileCard
import com.app.splashscreen.ui.components.DashboardTopBar
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun PatientDetailsScreen(navController: NavController) {
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
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(30.dp))
            CallHistoryOptionsProfileCard()
            Spacer(modifier = Modifier.height(5.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .clip(RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
                    .background(Color.White)
                    
                    .verticalScroll(rememberScrollState())
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp, vertical = 24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(15.dp))

                    // Dashboard icon grid
                    com.app.splashscreen.ui.components.DashboardIconGrid(
                        icons = listOf(
                            R.drawable.ic_dashboard_connect to "Send Message",
                            R.drawable.ic_dashboard_mic to "Video Checkup",
                            R.drawable.ic_dashboard_prescription to "Remove Patient",
                            R.drawable.ic_dashboard_call to "Call History",
                            R.drawable.ic_dashboard_connect to "AI Suggested Diagnosis",
                            R.drawable.ic_dashboard_refill to "Med History"
                        ),
                        modifier = Modifier.padding(18.dp)
                    )


                    Spacer(modifier = Modifier.height(200.dp))
                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        ) {
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

@Preview(showBackground = true)
@Composable
fun PatientDetailsScreenPreview() {
    val navController = rememberNavController()
    PatientDetailsScreen(navController)
}
