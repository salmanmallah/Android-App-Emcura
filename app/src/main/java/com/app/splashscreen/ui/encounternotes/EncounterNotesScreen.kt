package com.app.splashscreen.ui.encounternotes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.splashscreen.R
import com.app.splashscreen.ui.components.DashboardTopBar
import androidx.navigation.NavController

@Composable
fun EncounterNotesScreen(navController: NavController? = null) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F8F8))
    ) {
        // Header (same as other screens)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            DashboardTopBar(
                title = "Encounter Notes",
                backIconRes = R.drawable.ic_dashboard_arrow_backward,
                endIconRes = R.drawable.ic_dcd_hospital,
                showBackIcon = true,
                showEndIcon = true,
                onBackClick = { navController?.popBackStack() }
            )
        }

        // Profile Card below header
        com.app.splashscreen.ui.components.EncounterNotesProfileCard()

        Spacer(modifier = Modifier.height(16.dp))

        // Patient Info
        Text(
            text = "Patient : Susan Edward",
            fontSize = 15.sp,
            color = Color(0xFF222222),
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Text(
            text = "Patient DOB : 01/01/1970",
            fontSize = 15.sp,
            color = Color(0xFF222222),
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 2.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Notes Box
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
                .padding(horizontal = 16.dp),
            shape = RoundedCornerShape(8.dp),
            color = Color.White,
            shadowElevation = 0.5.dp,
            border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFF222222))
        ) {
            Box(modifier = Modifier.padding(10.dp)) {
                Text(
                    text = "As an AI model developed by OpenAI, I regret to inform you that I can't create a SOAP note as there is no medical content provided in the given statement Recording screen Could you Please provide relevant medical information or a medical scenario?",
                    fontSize = 13.sp,
                    color = Color(0xFF222222)
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Save Notes Button
        Button(
            onClick = { /* TODO: Save notes logic */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .padding(horizontal = 32.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE94F4F)),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text("Save Notes", color = Color.White, fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Show Previous Notes Button
        Button(
            onClick = { /* TODO: Show previous notes logic */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .padding(horizontal = 32.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE94F4F)),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text("Show Previous Notes", color = Color.White, fontSize = 16.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EncounterNotesScreenPreview() {
    EncounterNotesScreen()
}
