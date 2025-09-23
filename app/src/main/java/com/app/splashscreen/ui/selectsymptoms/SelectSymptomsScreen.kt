package com.app.splashscreen.ui.selectsymptoms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.app.splashscreen.R
import com.app.splashscreen.ui.components.DashboardTopBar
import com.app.splashscreen.ui.components.DoctorSearchBar

@Composable
fun SelectSymptomsScreen(navController: NavController? = null) {
    // --- Dynamic symptoms list ---
    val allSymptoms = listOf(
        "Common Cold", "Allergies", "Constipation", "Cough",
        "Ear Problems", "UTI(Females, 18+)", "Fever", "Flu"
    )
    val columns = 2
    val symptomRows = allSymptoms.chunked(columns)
    val selectedSymptoms = remember { mutableStateOf(setOf<String>()) }
    var searchQuery = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F8F8))
    ) {
        // Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            DashboardTopBar(
                title = "Select Symptoms",
                backIconRes = R.drawable.ic_dashboard_arrow_backward,
                endIconRes = R.drawable.ic_dcd_hospital,
                showBackIcon = true,
                showEndIcon = true,
                onBackClick = { navController?.popBackStack() }
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Select from the following symptoms:",
            color = Color(0xFFE94F4F),
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 24.dp, bottom = 8.dp)
        )

        // --- Symptoms Table ---
        Surface(
            shape = RoundedCornerShape(12.dp),
            color = Color.White,
            shadowElevation = 2.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        ) {
            Column {
                symptomRows.forEach { row ->
                    Row(modifier = Modifier.fillMaxWidth()) {
                        row.forEach { symptom ->
                            Box(modifier = Modifier.weight(1f)) {
                                SymptomItem(
                                    label = symptom,
                                    selected = selectedSymptoms.value.contains(symptom),
                                    onClick = {
                                        selectedSymptoms.value =
                                            if (selectedSymptoms.value.contains(symptom))
                                                selectedSymptoms.value - symptom
                                            else
                                                selectedSymptoms.value + symptom
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(18.dp))

        Text(
            text = "Add ICD-10 Codes:",
            color = Color(0xFFE94F4F),
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 24.dp, bottom = 8.dp)
        )

        // --- Search Bar ---
        DoctorSearchBar(
            value = searchQuery.value,
            onValueChange = { searchQuery.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        // --- Selected Symptoms Cards ---
        Column(modifier = Modifier.padding(horizontal = 24.dp)) {
            selectedSymptoms.value
                .filter { it.contains(searchQuery.value, ignoreCase = true) || searchQuery.value.isBlank() }
                .forEach { symptom ->
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = Color(0xFFFDE6E6),
                        shadowElevation = 1.dp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(12.dp)
                                    .background(Color(0xFFE94F4F), CircleShape)
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(
                                text = symptom,
                                color = Color.Black,
                                fontSize = 14.sp,
                                modifier = Modifier.weight(1f)
                            )
                            IconButton(onClick = {
                                selectedSymptoms.value = selectedSymptoms.value - symptom
                            }) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_dashboard_arrow_backward),
                                    contentDescription = "Remove",
                                    tint = Color(0xFFE94F4F),
                                    modifier = Modifier.size(18.dp)
                                )
                            }
                        }
                    }
                }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SelectSymptomsScreenPreview() {
    SelectSymptomsScreen()
}
