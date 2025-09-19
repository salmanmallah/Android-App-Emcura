package com.app.splashscreen.ui.doctodoc_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.splashscreen.R
import com.app.splashscreen.ui.components.DashboardTopBar
import com.app.splashscreen.ui.components.DoctorCardList
import com.app.splashscreen.ui.components.DoctorSearchBar

@Composable
fun DocToDocScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F8F8))
    ) {
        // Top bar
        DashboardTopBar(
            title = "Available Doctors",
            backIconRes = R.drawable.ic_dashboard_arrow_backward,
            endIconRes = R.drawable.ic_dcd_hospital,
            showBackIcon = true,
            showEndIcon = true
        )



        Spacer(modifier = Modifier.height(70.dp))


        // Doctors & specialists buttons
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.instant_connect_button) // 👈 XML color
                ),
                shape = RoundedCornerShape(50),
                modifier = Modifier
                    .weight(1f)
                    .height(30.dp), // kam height
                contentPadding = PaddingValues(vertical = 0.dp) // 👈 text ko center me karne ke liye
            ) {
                Text("DOCTORS", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 12.sp)
            }

            Spacer(modifier = Modifier.width(15.dp))

            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF8BFC2)),
                shape = RoundedCornerShape(50),
                modifier = Modifier
                    .weight(1f)
                    .height(30.dp),
                contentPadding = PaddingValues(vertical = 0.dp) // 👈 text ko center me karne ke liye
            ) {
                Text("SPECIALISTS", color = Color(0xFFE94F4F), fontWeight = FontWeight.Bold, fontSize = 12.sp)
            }
        }







        // Search bar
        DoctorSearchBar(
            modifier = Modifier
                .padding(16.dp)
        )
        // Doctor cards
        DoctorCardList(
            doctors = List(5) { i ->
                Triple(
                    if (i % 2 == 0) "Dr. Supak Sookkaskon" else "Supak Sookkaskon",
                    "Doctor",
                    i % 2 == 0
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
                .weight(1f)
        )
    }
}

@Composable
fun DoctorCard(name: String, title: String, online: Boolean) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(Color(0xFFFEEBEE), RoundedCornerShape(12.dp))
            .padding(horizontal = 8.dp, vertical = 8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .background(Color.White)
                    .border(3.dp, Color(0xFFE94F4F), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_dashboard_profile),
                    contentDescription = "Profile",
                    modifier = Modifier.size(54.dp)
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = name,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    text = title,
                    color = Color(0xFF757575),
                    fontSize = 13.sp
                )
                Box(
                    modifier = Modifier
                        .padding(top = 2.dp)
                        .background(
                            if (online) Color(0xFF1ED300) else Color(0xFF757575),
                            RoundedCornerShape(8.dp)
                        )
                        .padding(horizontal = 8.dp, vertical = 2.dp)
                ) {
                    Text(
                        text = if (online) "Online" else "Offline",
                        color = Color.White,
                        fontSize = 10.sp
                    )
                }
            }
            IconButton(onClick = { /* TODO: Navigate */ }) {
//
                Image(
                    painter = painterResource(id = R.drawable.ic_dashboard_arrow_forward),
                    contentDescription = "Notifications",
                    modifier = Modifier.size(25.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DocToDocScreenPreview() {
    DocToDocScreen()
}
