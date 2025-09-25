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
import com.app.splashscreen.ui.components.ReviewCurrentSymptomsButton
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.android.gms.maps.model.LatLng
import androidx.compose.material3.Card
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.material3.CardDefaults
import com.google.android.gms.maps.GoogleMap

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
                    Spacer(modifier = Modifier.height(10.dp))


                    // Review Current Symptoms Button
                    ReviewCurrentSymptomsButton(
                        modifier = Modifier.padding(bottom = 18.dp)
                    )

                    // Dashboard icon grid
                    com.app.splashscreen.ui.components.DashboardIconGrid(
                        icons = listOf(
                            R.drawable.pd_message to "Send Message",
                            R.drawable.pd_video_checkup to "Video Checkup",
                            R.drawable.pd_remove_patient to "Remove Patient",
                            R.drawable.ic_dashboard_call to "Call History",
                            R.drawable.pd_ai_diagnosis to "AI Suggested Diagnosis",
                            R.drawable.pd_med_history to "Med History"
                        ),
                        modifier = Modifier.padding(5.dp)
                    )

                    // Live Map Card
                    val cameraPositionState = rememberCameraPositionState {
                        position = com.google.android.gms.maps.model.CameraPosition.fromLatLngZoom(LatLng(24.8607, 67.0011), 12f)
                    }
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 24.dp)
                            .aspectRatio(1.3f)
                            .clip(RoundedCornerShape(24.dp)),
                        elevation = CardDefaults.cardElevation(8.dp)
                    ) {
                        GoogleMap(
                            modifier = Modifier.fillMaxSize(),
                            cameraPositionState = cameraPositionState
                        )
                    }


                    Spacer(modifier = Modifier.height(200.dp))
                }
            }

            // google map box below
                


        } // end of column

//
    }
}

@Preview(showBackground = true)
@Composable
fun PatientDetailsScreenPreview() {
    val navController = rememberNavController()
    PatientDetailsScreen(navController)
}

