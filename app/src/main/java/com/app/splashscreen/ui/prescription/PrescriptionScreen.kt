package com.app.splashscreen.ui.prescription

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.app.splashscreen.R
import com.app.splashscreen.ui.components.DashboardTopBar
import com.app.splashscreen.ui.components.DoctorSearchBar
import com.app.splashscreen.ui.components.OlcOfficeProfileCard
import com.app.splashscreen.ui.emr_patients.EmrPatients
import com.app.splashscreen.ui.components.PrescriptionProfileCard


// Profile data for OnlineCare Patients
// (Keep as is for now, can be moved to a shared model if needed)
data class ProfileData(
    val name: String,
    val email: String,
    val mobile: String,
    val imageRes: Int
)

@Composable
fun PrescriptionScreen(
    navController: NavController? = null,
    enableScroll: Boolean = true
) {
    var selectedTab by remember { mutableStateOf(0) } // 0 = OnlineCare, 1 = EMR
    var searchQuery by remember { mutableStateOf("") }

    // Dummy data for OnlineCare patients
    val onlineCarePatients = remember {
        listOf(
            ProfileData("John Doe", "john@email.com", "1234567890", com.app.splashscreen.R.drawable.ic_dashboard_profile),
            ProfileData("Jane Smith", "jane@email.com", "9876543210", com.app.splashscreen.R.drawable.ic_dashboard_profile),
            ProfileData("Alex Brown", "alex@email.com", "5555555555", com.app.splashscreen.R.drawable.ic_dashboard_profile),
            ProfileData("Emily White", "emily@email.com", "4444444444", com.app.splashscreen.R.drawable.ic_dashboard_profile)
        )
    }

    val filteredPatients = if (searchQuery.isBlank()) {
        onlineCarePatients
    } else {
        onlineCarePatients.filter { it.name.contains(searchQuery, ignoreCase = true) }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F8F8))
    ) {
        // 🔹 TopBar
        DashboardTopBar(
            title = "Prescription to Patients",
            backIconRes = R.drawable.ic_dashboard_arrow_backward,
            endIconRes = R.drawable.ic_dcd_hospital,
            showBackIcon = true,
            showEndIcon = true,
            onBackClick = { navController?.popBackStack() }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // 🔹 Tabs (OnlineCare / EMR)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { selectedTab = 0 },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (selectedTab == 0)
                        colorResource(id = R.color.instant_connect_button)
                    else
                        Color(0xFFF8BFC2)
                ),
                shape = RoundedCornerShape(50),
                modifier = Modifier
                    .weight(1f)
                    .height(36.dp),
                contentPadding = PaddingValues(vertical = 0.dp)
            ) {
                Text(
                    "Prescription By Doc",
                    color = if (selectedTab == 0) Color.White else Color(0xFFE94F4F),
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Button(
                onClick = { selectedTab = 1 },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (selectedTab == 1)
                        colorResource(id = R.color.instant_connect_button)
                    else
                        Color(0xFFF8BFC2)
                ),
                shape = RoundedCornerShape(50),
                modifier = Modifier
                    .weight(1f)
                    .height(36.dp),
                contentPadding = PaddingValues(vertical = 0.dp)
            ) {
                Text(
                    "Canceled Prescription",
                    color = if (selectedTab == 1) Color.White else Color(0xFFE94F4F),
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))



        // 🔹 Content Section
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(horizontal = 8.dp)
                .background(Color.White, RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                .padding(top = 8.dp)
        ) {
            if (selectedTab == 0) {
                if (filteredPatients.isEmpty()) {
                    SearchPatient()
                } else {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .verticalScroll(rememberScrollState()),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        filteredPatients.forEach {
                            PrescriptionProfileCard()
                        }
                    }
                }
            } else {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState())
                ) {
                    Spacer(modifier = Modifier.height(16.dp))
                    PrescriptionProfileCard()
                }
            }
        }
    }
}

@Composable
fun SearchPatient() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 48.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = R.drawable.onliecare_patiends_human),
            contentDescription = "Search Patient",
            tint = Color(0xFFE94F4F),
            modifier = Modifier.size(100.dp)
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Search Patient",
            color = Color.Black,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Please search Patient by first name or last name",
            color = Color.Black,
            fontSize = 14.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Your search result will appear over here",
            color = Color.Black,
            fontSize = 14.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun PrescriptionScreenPreview() {
    PrescriptionScreen(enableScroll = false)
}
