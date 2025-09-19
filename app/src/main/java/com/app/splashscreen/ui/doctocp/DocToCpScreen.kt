package com.app.splashscreen.ui.doctocp

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
import com.app.splashscreen.ui.components.DocToCpProfileCard

@Composable
fun DocToCpScreen(navController: NavController? = null) {
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
                title = "Available Doctors",
                backIconRes = R.drawable.ic_dashboard_arrow_backward,
                endIconRes = R.drawable.ic_dcd_hospital,
                showBackIcon = true,
                showEndIcon = true,
                onBackClick = { navController?.popBackStack() }
            )
        }





        // 🔹 Tabs Row (Doctors / Dropdown)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(horizontal = 24.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            // Doctors Button
            Button(
                onClick = { /* TODO: Doctors tab click */ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.doc_to_cp_card)
                ),
                shape = RoundedCornerShape(50),
                modifier = Modifier
                    .weight(1f)
                    .height(36.dp),
                contentPadding = PaddingValues(vertical = 0.dp)
            ) {
                Text(
                    "DOCTORS",
                    color = Color.Red,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            // Dropdown Button
            Box(modifier = Modifier.weight(1f)) {
                Button(
                    onClick = { expanded = !expanded },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.dashboard_background)
                    ),
                    shape = RoundedCornerShape(50),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(36.dp),
                    contentPadding = PaddingValues(vertical = 0.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            selectedOption,
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.sp
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Icon(
                            painter = painterResource(id = R.drawable.doc_to_cp_dropdown),
                            contentDescription = "Dropdown",
                            tint = Color.White,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier
                        .background(colorResource(id = R.color.dashboard_background))
                        .width(180.dp)
                        .heightIn(max = 320.dp)
                ) {
                    dropdownOptions.forEach { option ->
                        DropdownMenuItem(
                            text = {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Text(
                                        text = "\u2022 ", // dot
                                        color = Color.White,
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(end = 4.dp)
                                    )
                                    Text(
                                        text = option,
                                        color = Color.White,
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            },
                            onClick = {
                                selectedOption = option
                                expanded = false
                            },
                            modifier = Modifier.padding(vertical = 0.dp)
                        )
                    }
                }
            }
        }





        Spacer(modifier = Modifier.height(16.dp))

        // 🔹 Care Providers List
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(5) { idx ->
                DocToCpProfileCard(
                    name = "Elizabeth weisberg",
                    title = "MA",
                    online = idx % 2 == 0
                )
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DocToCpScreenPreview() {
    DocToCpScreen()
}
