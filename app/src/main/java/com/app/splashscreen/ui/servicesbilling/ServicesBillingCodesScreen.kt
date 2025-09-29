
package com.app.splashscreen.ui.servicesbilling

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
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

            // White section for billing codes (fixed white background)
            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = Color.White,
                shape = RoundedCornerShape(bottomStart = 0.dp, bottomEnd = 0.dp)
            ) {
                BillingCodesList()
            }

            // Red section with curved top edges for dropdowns only
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Color(0xFFE53E3E),
                        RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                    )
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // Expandable dropdown items
                item {
                    ExpandableDropdownItem(
                        title = "My Favorites",
                        expanded = myFavoritesExpanded,
                        onToggle = { myFavoritesExpanded = !myFavoritesExpanded },
                        items = listOf("Favorite Item 1", "Favorite Item 2", "Favorite Item 3")
                    )
                }
                item {
                    ExpandableDropdownItem(
                        title = "Most Common",
                        expanded = mostCommonExpanded,
                        onToggle = { mostCommonExpanded = !mostCommonExpanded },
                        items = listOf("Common Code 1", "Common Code 2", "Common Code 3")
                    )
                }
                item {
                    ExpandableDropdownItem(
                        title = "Psych",
                        expanded = psychExpanded,
                        onToggle = { psychExpanded = !psychExpanded },
                        items = listOf(
                            "90832 - Psytx Pt&/Family 30 Minutes",
                            "90832 - Psytx Pt&/Family 30 Minutes", 
                            "90832 - Psytx Pt&/Family 30 Minutes",
                            "90832 - Psytx Pt&/Family 30 Minutes",
                            "90832 - Psytx Pt&/Family 30 Minutes"
                        )
                    )
                }
                item {
                    ExpandableDropdownItem(
                        title = "LSRD ( End Stage Renal Disease )",
                        expanded = lsrdExpanded,
                        onToggle = { lsrdExpanded = !lsrdExpanded },
                        items = listOf("LSRD Code 1", "LSRD Code 2", "LSRD Code 3")
                    )
                }
                item {
                    ExpandableDropdownItem(
                        title = "Behavioral Health",
                        expanded = behavioralHealthExpanded,
                        onToggle = { behavioralHealthExpanded = !behavioralHealthExpanded },
                        items = listOf("Behavioral Code 1", "Behavioral Code 2", "Behavioral Code 3")
                    )
                }
                item {
                    ExpandableDropdownItem(
                        title = "Office/outpatient",
                        expanded = officeOutpatientExpanded,
                        onToggle = { officeOutpatientExpanded = !officeOutpatientExpanded },
                        items = listOf("Office Code 1", "Office Code 2", "Office Code 3")
                    )
                }
                item {
                    ExpandableDropdownItem(
                        title = "Inpatient",
                        expanded = inpatientExpanded,
                        onToggle = { inpatientExpanded = !inpatientExpanded },
                        items = listOf("Inpatient Code 1", "Inpatient Code 2", "Inpatient Code 3")
                    )
                }
                item {
                    ExpandableDropdownItem(
                        title = "Auditing",
                        expanded = auditingExpanded,
                        onToggle = { auditingExpanded = !auditingExpanded },
                        items = listOf("Audit Code 1", "Audit Code 2", "Audit Code 3")
                    )
                }

                // Bottom buttons
                item {
                    Spacer(modifier = Modifier.height(16.dp))
                    BottomButtons()
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}

@Composable
private fun BillingCodesList() {
    val billingCodes = listOf(
        "99203 Office/outpatient visit, new patient, 30-44 minutes",
        "99213 Office/outpatient visit, established patient, 20-29 minutes",
        "99214 Office/outpatient visit, established patient, 30-39 minutes", 
        "99215 Office/outpatient visit, established patient, 40-54 minutes",
        "99243 Office consultation for a new or established patient"
    )

    var selectedIndex by remember { mutableStateOf(-1) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        billingCodes.forEachIndexed { index, code ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top
            ) {
                RadioButton(
                    selected = selectedIndex == index,
                    onClick = { selectedIndex = index },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Color(0xFFE53E3E),
                        unselectedColor = Color.Gray
                    )
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = code,
                    color = Color.Black,
                    fontSize = 14.sp,
                    modifier = Modifier.weight(1f),
                    lineHeight = 20.sp
                )
            }
        }
    }
}

@Composable
private fun ExpandableDropdownItem(
    title: String,
    expanded: Boolean,
    onToggle: () -> Unit,
    items: List<String>
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color.White,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            // Header row (clickable)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onToggle() }
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
                    imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                    contentDescription = if (expanded) "Collapse" else "Expand",
                    tint = Color(0xFFE53E3E),
                    modifier = Modifier.size(24.dp)
                )
            }
            
            // Expandable content
            if (expanded) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFF5F5F5))
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(1.dp)
                ) {
                    items.forEach { item ->
                        Surface(
                            modifier = Modifier.fillMaxWidth(),
                            color = Color.White,
                            shape = RoundedCornerShape(4.dp)
                        ) {
                            Text(
                                text = item,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(12.dp),
                                fontSize = 13.sp,
                                color = Color.Black,
                                lineHeight = 16.sp
                            )
                        }
                    }
                }
            }
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
