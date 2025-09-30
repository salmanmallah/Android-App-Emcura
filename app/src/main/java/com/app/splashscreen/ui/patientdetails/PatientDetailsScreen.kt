package com.app.splashscreen.ui.patientdetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.app.splashscreen.R

import com.app.splashscreen.ui.components.CallHistoryOptionsProfileCard
import com.app.splashscreen.ui.components.DashboardTopBar
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.app.splashscreen.ui.components.ReviewCurrentSymptomsButton
import com.app.splashscreen.ui.components.PatientsDetailsPopup
import com.app.splashscreen.ui.components.SendMessagePopup

@Composable
fun PatientDetailsScreen(navController: NavController) {
    var showSymptomsPopup by remember { mutableStateOf(false) }
    var showSendMessagePopup by remember { mutableStateOf(false) }
    
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
                    Spacer(modifier = Modifier.height(10.dp))


                    ReviewCurrentSymptomsButton(
                        modifier = Modifier.padding(bottom = 18.dp),
                        onClick = { showSymptomsPopup = true }
                    )

                    val patientIcons = listOf(
                        R.drawable.pd_message to "Send Message",
                        R.drawable.pd_video_checkup to "Video Checkup",
                        R.drawable.pd_remove_patient to "Remove Patient",
                        R.drawable.ic_dashboard_call to "Call History",
                        R.drawable.pd_ai_diagnosis to "AI Suggested Diagnosis",
                        R.drawable.pd_med_history to "Med History"
                    )
                    com.app.splashscreen.ui.components.DashboardIconGrid(
                        icons = patientIcons,
                        modifier = Modifier.padding(5.dp),
                        onIconClick = { index ->
                            when (patientIcons[index].second) {
                                "Send Message" -> showSendMessagePopup = true
                                "Video Checkup" -> navController.navigate("videocall")
                                "Call History" -> navController.navigate("callhistory")
                                "AI Suggested Diagnosis" -> navController.navigate("aisuggesteddiagnosis")
                                "Med History" -> {
                                }
                                "Remove Patient" -> {
                                }
                            }
                        }
                    )


                    Spacer(modifier = Modifier.height(200.dp))
                }
            }


        }
        
        if (showSymptomsPopup) {
            PatientsDetailsPopup(
                onDismiss = { showSymptomsPopup = false },
                symptoms = "Headache, fever, cough",
                conditions = "Common cold",
                icdCodes = "jfwiejwfjpawjfpoawjpt",
                description = "Patient experiencing symptoms since yesterday",
                temperature = "30C",
                bloodSugar = "120",
                height = "5.65",
                bmi = "22.5",
                weight = "65",
                respiration = "18",
                bp = "120/80",
                o2Saturation = "02 Saturation",
                heartRate = "75"
            )
        }
        
        if (showSendMessagePopup) {
            SendMessagePopup(
                name = "Elizabeth weisberg",
                online = true,
                onDismiss = { showSendMessagePopup = false },
                onSend = { message ->
                    println("Message sent: $message")
                    showSendMessagePopup = false
                }
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

