package com.app.splashscreen.ui.olc_office




import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.app.splashscreen.R
import com.app.splashscreen.ui.components.DashboardTopBar
import com.app.splashscreen.ui.components.OlcOfficeProfileCard

@Composable
fun WaitingRoomScreen(navController: NavController? = null) {
    val dropdownOptions = listOf(
        "Nurse", "Nurse Practitioner", "Social Worker", "Dietition", "OT/OPT",
        "Pharmacist", "Office Manager", "Medical Assistant", "Supervisor"
    )
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("Other") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
    ) {
        // Top Bar (DashboardTopBar)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            DashboardTopBar(
                title = "OLC Office Visit",
                backIconRes = R.drawable.ic_dashboard_arrow_backward,
                endIconRes = R.drawable.ic_dcd_hospital,
                showBackIcon = true,
                showEndIcon = true,
                onBackClick = { navController?.popBackStack() }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 🔹 Waiting room docs list
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Profile Card
            OlcOfficeProfileCard(
                name = "Susan Edward",
                email = "email2jamal3@yahoo.com",
                mobile = "5555655555",
                imageRes = R.drawable.ic_dashboard_profile // Replace with actual image resource if needed
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Mic Icon with timer
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.olc_screen_mic),
                    contentDescription = "Mic",
                    tint = Color(0xFFE94F4F),
                    modifier = Modifier.size(180.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "00:55",
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    color = Color.Black
                )
            }

            Spacer(modifier = Modifier.height(100.dp))

            // Stop Recording Button
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Surface(
                    shape = CircleShape,
                    color = Color.White,
                    shadowElevation = 10.dp
                ) {
                    Box(
                        modifier = Modifier
                            .size(64.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.olc_screen_stop_recording),
                            contentDescription = "Stop Recording",
                            tint = Color(0xFFE94F4F),
                            modifier = Modifier.size(36.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Stop Recording",
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    color = Color.Black
                )
            }

            Spacer(modifier = Modifier.weight(1f))
        }


    }
}



@Preview(showBackground = true)
@Composable
fun WaitingRoomScreenPreview() {
    WaitingRoomScreen()
}

