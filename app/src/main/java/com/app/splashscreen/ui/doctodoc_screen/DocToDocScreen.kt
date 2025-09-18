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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.splashscreen.R

@Composable
fun DocToDocScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F8F8))
    ) {
        // Top bar

        // Red status bar

        // Header row
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(vertical = 18.dp, horizontal = 16.dp),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            IconButton(onClick = { /* TODO: Back */ }) {
//                Icon(
//                    painter = painterResource(id = R.drawable.ic_dashboard_top_sider),
//                    contentDescription = "Back",
//                    tint = Color(0xFFE94F4F)
//                )
//            }
//            Spacer(modifier = Modifier.weight(1f))
//            Text(
//                text = "Available Doctors",
//                color = Color.Black,
//                fontWeight = FontWeight.Bold,
//                fontSize = 20.sp
//            )
//            Spacer(modifier = Modifier.weight(1f))
//            IconButton(onClick = { /* TODO: Home */ }) {
//                Icon(
//                    painter = painterResource(id = R.drawable.ic_dashboard_bell),
//                    contentDescription = "Home",
//                    tint = Color(0xFFE94F4F)
//                )
//            }
//        }
        // Top icons row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp, start = 24.dp, end = 24.dp)
                .align(Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_dashboard_arrow_backward),
                contentDescription = "Menu",
                modifier = Modifier.size(25.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "Dashboard",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.weight(1f))

            Image(
                painter = painterResource(id = R.drawable.ic_dcd_hospital),
                contentDescription = "Notifications",
                modifier = Modifier.size(25.dp)
            )
        }
        // Top icons ke liye space
        Spacer(modifier = Modifier.height(70.dp))
        // Tabs
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE94F4F)),
                shape = RoundedCornerShape(50),
                modifier = Modifier.weight(1f)
            ) {
                Text("DOCTORS", color = Color.White, fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.width(15.dp))
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF8BFC2)),
                shape = RoundedCornerShape(50),
                modifier = Modifier.weight(1f)
            ) {
                Text("SPECIALISTS", color = Color(0xFFE94F4F), fontWeight = FontWeight.Bold)
            }
        }
        // Search bar
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(Color.White, RoundedCornerShape(24.dp))
                .height(44.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Text(
                    text = "Search",
                    color = Color(0xFFBDBDBD),
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    painter = painterResource(id = R.drawable.ic_dashboard_search),
                    contentDescription = "Search",
                    tint = Color(0xFFBDBDBD)
                )
            }
        }
        // Doctor cards
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            repeat(5) { i ->
                DoctorCard(
                    name = if (i % 2 == 0) "Dr. Supak Sookkaskon" else "Supak Sookkaskon",
                    title = "Doctor",
                    online = i % 2 == 0
                )
            }
        }
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
//                Icon(
//                    painter = painterResource(id = R.drawable.ic_dashboard_arroa_forward),
//                    contentDescription = "Go",
//                    tint = Color.White,
//                    modifier = Modifier
//                        .size(32.dp)
//                        .background(Color(0xFFE94F4F), CircleShape)
//                        .padding(6.dp)
//                )
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
