package com.app.splashscreen.ui.doctodoc_screen

import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import com.app.splashscreen.R
import com.app.splashscreen.ui.components.DashboardTopBar
import com.app.splashscreen.ui.components.DoctorCard
import com.app.splashscreen.ui.components.DoctorSearchBar

@Composable
fun DocToDocScreen(navController: NavController? = null, enableScroll: Boolean = true) {
    var selectedTab by remember { mutableStateOf("DOCTORS") }
    var searchQuery by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F8F8))
    ) {
        // 🔹 TopBar Section
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            DashboardTopBar(
                title = "Available Doctors",
                backIconRes = R.drawable.ic_dashboard_arrow_backward,
                endIconRes = R.drawable.ic_dcd_hospital,
                showBackIcon = true,
                showEndIcon = true,
                onBackClick = { navController?.popBackStack() }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 🔹 Toggle Buttons (Doctors / Specialists)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = { selectedTab = "DOCTORS" },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (selectedTab == "DOCTORS") colorResource(id = R.color.instant_connect_button) else Color(0xFFF8BFC2)
                    ),
                    shape = RoundedCornerShape(50),
                    modifier = Modifier
                        .weight(1f)
                        .height(36.dp),
                    contentPadding = PaddingValues(vertical = 0.dp)
                ) {
                    Text(
                        "DOCTORS",
                        color = if (selectedTab == "DOCTORS") Color.White else Color(0xFFE94F4F),
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Button(
                    onClick = { selectedTab = "SPECIALISTS" },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (selectedTab == "SPECIALISTS") colorResource(id = R.color.instant_connect_button) else Color(0xFFF8BFC2)
                    ),
                    shape = RoundedCornerShape(50),
                    modifier = Modifier
                        .weight(1f)
                        .height(36.dp),
                    contentPadding = PaddingValues(vertical = 0.dp)
                ) {
                    Text(
                        "SPECIALISTS",
                        color = if (selectedTab == "SPECIALISTS") Color.White else Color(0xFFE94F4F),
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 🔹 Search Section
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

        Spacer(modifier = Modifier.height(12.dp))

        // 🔹 Doctors List or No Data Section
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(horizontal = 8.dp)
                .background(Color.White, RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                .padding(top = 8.dp)
        ) {
            if (selectedTab == "DOCTORS") {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .then(
                            if (enableScroll) Modifier.verticalScroll(rememberScrollState()) else Modifier
                        ),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    val doctors = List(10) { i ->
                        Triple(
                            if (i % 2 == 0) "Dr. Supak Sookkaskon" else "Supak Sookkaskon",
                            "Doctor",
                            i % 2 == 0
                        )
                    }
                    doctors.forEach { (name, title, online) ->
                        DoctorCard(
                            name = name,
                            title = title,
                            online = online
                        )
                    }
                }
            } else {
                // No Data Available Centered
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "NO DATA AVAILABLE",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DocToDocScreenPreview() {
    DocToDocScreen(enableScroll = false)   // ✅ Preview me scroll disable
}
