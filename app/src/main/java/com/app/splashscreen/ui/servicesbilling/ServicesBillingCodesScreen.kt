
package com.app.splashscreen.ui.servicesbilling

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.app.splashscreen.R
import com.app.splashscreen.ui.components.DashboardTopBar

@Composable
fun ServicesBillingCodesScreen(navController: NavController? = null) {
    // States for dropdowns
    var myFavoritesExpanded by remember { mutableStateOf(false) }
    var mostCommonExpanded by remember { mutableStateOf(false) }
    var psychExpanded by remember { mutableStateOf(false) }
    var lsrdExpanded by remember { mutableStateOf(false) }
    var behavioralHealthExpanded by remember { mutableStateOf(false) }
    var officeOutpatientExpanded by remember { mutableStateOf(false) }
    var inpatientExpanded by remember { mutableStateOf(false) }
    var auditingExpanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F8F8))
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            // Top Bar
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(vertical = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                DashboardTopBar(
                    title = "Services Billing Codes",
                    backIconRes = R.drawable.ic_dashboard_arrow_backward,
                    endIconRes = R.drawable.ic_dcd_hospital,
                    showBackIcon = true,
                    showEndIcon = true,
                    onBackClick = { navController?.popBackStack() },
                    onEndIconClick = { navController?.navigate("dashboard") }
                )
            }

            // Timer section with red background
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFE53E3E))
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Most Common",
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = "Total Visited Time : 00:00:00",
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )
            }

            // White section for billing codes
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(16.dp)
            ) {
                BillingCodesList()
            }

            // Red section with curved top edges for dropdowns
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Color(0xFFE53E3E),
                        RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                    )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    // Dropdown menus section
                    LazyColumn(
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        item {
                            DropdownMenuItem(
                                title = "My Favorites",
                                expanded = myFavoritesExpanded,
                                onToggle = { myFavoritesExpanded = !myFavoritesExpanded }
                            )
                        }
                        item {
                            DropdownMenuItem(
                                title = "Most Common",
                                expanded = mostCommonExpanded,
                                onToggle = { mostCommonExpanded = !mostCommonExpanded }
                            )
                        }
                        item {
                            DropdownMenuItem(
                                title = "Psych",
                                expanded = psychExpanded,
                                onToggle = { psychExpanded = !psychExpanded }
                            )
                        }
                        item {
                            DropdownMenuItem(
                                title = "LSRD ( End Stage Renal Disease )",
                                expanded = lsrdExpanded,
                                onToggle = { lsrdExpanded = !lsrdExpanded }
                            )
                        }
                        item {
                            DropdownMenuItem(
                                title = "Behavioral Health",
                                expanded = behavioralHealthExpanded,
                                onToggle = { behavioralHealthExpanded = !behavioralHealthExpanded }
                            )
                        }
                        item {
                            DropdownMenuItem(
                                title = "Office/outpatient",
                                expanded = officeOutpatientExpanded,
                                onToggle = { officeOutpatientExpanded = !officeOutpatientExpanded }
                            )
                        }
                        item {
                            DropdownMenuItem(
                                title = "Inpatient",
                                expanded = inpatientExpanded,
                                onToggle = { inpatientExpanded = !inpatientExpanded }
                            )
                        }
                        item {
                            DropdownMenuItem(
                                title = "Auditing",
                                expanded = auditingExpanded,
                                onToggle = { auditingExpanded = !auditingExpanded }
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Bottom buttons
                    BottomButtons()
                }
            }
        }
    }
}

@Composable
private fun BillingCodesList() {
    val billingCodes = listOf(
        "99202 - Office/Outpatient Visit New",
        "99203 - Office/Outpatient Visit New",
        "99204 - Office/Outpatient Visit New",
        "99205 - Office/Outpatient Visit New",
        "99211 - Office/Outpatient Visit New"
    )

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        billingCodes.forEach { code ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = false,
                    onClick = { },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Color.Red,
                        unselectedColor = Color.Gray
                    )
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = code,
                    color = Color.Black,
                    fontSize = 14.sp
                )
            }
        }
    }
}

@Composable
private fun DropdownMenuItem(
    title: String,
    expanded: Boolean,
    onToggle: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onToggle() },
        color = Color.White,
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = "Dropdown",
                tint = Color(0xFFE53E3E),
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
private fun BottomButtons() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Button(
            onClick = { },
            modifier = Modifier.weight(1f),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color(0xFFE53E3E)
            ),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = "Add to Favorite",
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium
            )
        }

        Button(
            onClick = { },
            modifier = Modifier.weight(1f),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color(0xFFE53E3E)
            ),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = "Remove from Favorite",
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium
            )
        }

        Button(
            onClick = { },
            modifier = Modifier.weight(1f),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color(0xFFE53E3E)
            ),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = "Next",
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ServicesBillingCodesScreenPreview() {
    ServicesBillingCodesScreen(navController = rememberNavController())
}
