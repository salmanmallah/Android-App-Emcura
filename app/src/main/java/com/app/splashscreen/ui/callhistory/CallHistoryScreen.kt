package com.app.splashscreen.ui.callhistory

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import com.app.splashscreen.R
import com.app.splashscreen.ui.components.DashboardTopBar
import com.app.splashscreen.ui.components.DoctorSearchBar
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.app.splashscreen.ui.components.CallHistoryProfileCard
import com.app.splashscreen.ui.components.PatientCareProfileCard

@Composable
fun CallHistoryScreen(enableScroll: Boolean = true) {
    var searchQuery by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F8F8))
    ) {
        // TopBar Section
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            DashboardTopBar(
                title = "Call History",
                backIconRes = R.drawable.ic_dashboard_arrow_backward,
                endIconRes = R.drawable.ic_dcd_hospital,
                showBackIcon = true,
                showEndIcon = true,
                onBackClick = { /* TODO: Add navigation if needed */ }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Search Section
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .background(Color.White, RoundedCornerShape(12.dp))
                .padding(8.dp)
        ) {
            DoctorSearchBar(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                modifier = Modifier.fillMaxWidth()
            )
        }

//        Spacer(modifier = Modifier.height(16.dp)

        Spacer(modifier = Modifier.height(12.dp))

        // Doctors List Section (Always visible now)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(horizontal = 8.dp)
                .background(Color.White, RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                .padding(top = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .then(
                        if (enableScroll) Modifier.verticalScroll(rememberScrollState()) else Modifier
                    ),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                // yahan par calls k card ayengy
                CallHistoryProfileCard(name="Aslam Chandio")
                Spacer(modifier = Modifier.height(16.dp))
                CallHistoryProfileCard()
                Spacer(modifier = Modifier.height(16.dp))
                CallHistoryProfileCard()
                Spacer(modifier = Modifier.height(16.dp))
                CallHistoryProfileCard(name = "Dr John Wick Memon",profileImageRes = R.drawable.dr_john_wick)

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CallHistoryScreenPreview() {
    CallHistoryScreen(enableScroll = false)
}
