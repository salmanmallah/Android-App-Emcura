package com.app.splashscreen.ui.videocall

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.app.splashscreen.R
import com.app.splashscreen.ui.components.DashboardTopBar
import com.app.splashscreen.ui.components.DoctorSearchBar
import com.app.splashscreen.ui.components.OlcOfficeProfileCard
import com.app.splashscreen.ui.emr_patients.EmrPatients

// Profile data for Video Call Patients
// (reuse ProfileData if needed)
data class VideoCallProfileData(
    val name: String,
    val email: String,
    val mobile: String,
    val imageRes: Int
)

@Composable
fun VideoCallScreen(
    navController: NavController? = null,
    enableScroll: Boolean = true
) {
    var selectedTab by remember { mutableStateOf(0) } // 0 = VideoCall, 1 = EMR
    var searchQuery by remember { mutableStateOf("") }

    // Dummy data for Video Call patients
    val videoCallPatients = remember {
        listOf(
            VideoCallProfileData("John Doe", "john@email.com", "1234567890", com.app.splashscreen.R.drawable.ic_dashboard_profile),
            VideoCallProfileData("Jane Smith", "jane@email.com", "9876543210", com.app.splashscreen.R.drawable.ic_dashboard_profile),
            VideoCallProfileData("Alex Brown", "alex@email.com", "5555555555", com.app.splashscreen.R.drawable.ic_dashboard_profile),
            VideoCallProfileData("Emily White", "emily@email.com", "4444444444", com.app.splashscreen.R.drawable.ic_dashboard_profile)
        )
    }

    val filteredPatients = if (searchQuery.isBlank()) {
        videoCallPatients
    } else {
        videoCallPatients.filter { it.name.contains(searchQuery, ignoreCase = true) }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F8F8))
    ) {
        // 🔹 TopBar
        DashboardTopBar(
            title = "00:58",
            backIconRes = R.drawable.ic_dashboard_arrow_backward,
            endIconRes = R.drawable.ic_dcd_hospital,
            showBackIcon = true,
            showEndIcon = true,
            onBackClick = { navController?.popBackStack() }
        )
        // 



        Spacer(modifier = Modifier.height(16.dp))




    }
}



@Preview
@Composable
fun VideoCallScreenPreview() {
    VideoCallScreen(enableScroll = false)
}
