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
    // Navigation bar and white area remain at the top
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F8F8))
    ) {
        // TopBar (navigation)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            DashboardTopBar(
                title = "00:58",
                backIconRes = R.drawable.ic_dashboard_arrow_backward,
                endIconRes = R.drawable.ic_dcd_hospital,
                showBackIcon = true,
                showEndIcon = true,
                onBackClick = { navController?.popBackStack() },
                onEndIconClick = { navController?.navigate("dashboard") }
            )
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .background(Color.White)
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            androidx.compose.foundation.Image(
                painter = painterResource(id = R.drawable.video_call_image),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = androidx.compose.ui.layout.ContentScale.Crop
            )

            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.TopEnd
            ) {
                com.app.splashscreen.ui.videocall.FloatingVideoPreview(
                    modifier = Modifier.padding(top = 24.dp, end = 16.dp)
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.BottomCenter
            ) {
                com.app.splashscreen.ui.videocall.VideoCallNavBar(
                    onHangup = { navController?.popBackStack() }
                )
            }
        }
    }
}




@Preview
@Composable
fun VideoCallScreenPreview() {
    VideoCallScreen(enableScroll = false)
}
