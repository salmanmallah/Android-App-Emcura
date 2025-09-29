package com.app.splashscreen.ui.servicesbilling

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
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
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.animation.core.*
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
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


// State for section ordering - true means dropdown is on top
    var dropdownOnTop by remember { mutableStateOf(false) }

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

            // Dynamic content based on section order
            if (dropdownOnTop) {
                DraggableDropdownSection(
                    myFavoritesExpanded = myFavoritesExpanded,
                    mostCommonExpanded = mostCommonExpanded,
                    psychExpanded = psychExpanded,
                    lsrdExpanded = lsrdExpanded,
                    behavioralHealthExpanded = behavioralHealthExpanded,
                    officeOutpatientExpanded = officeOutpatientExpanded,
                    inpatientExpanded = inpatientExpanded,
                    auditingExpanded = auditingExpanded,
                    onMyFavoritesToggle = { myFavoritesExpanded = !myFavoritesExpanded },
                    onMostCommonToggle = { mostCommonExpanded = !mostCommonExpanded },
                    onPsychToggle = { psychExpanded = !psychExpanded },
                    onLsrdToggle = { lsrdExpanded = !lsrdExpanded },
                    onBehavioralHealthToggle = { behavioralHealthExpanded = !behavioralHealthExpanded },
                    onOfficeOutpatientToggle = { officeOutpatientExpanded = !officeOutpatientExpanded },
                    onInpatientToggle = { inpatientExpanded = !inpatientExpanded },
                    onAuditingToggle = { auditingExpanded = !auditingExpanded },
                    onDragDown = { dropdownOnTop = false }
                )
                DraggableRadioSection(
                    onDragUp = { dropdownOnTop = true }
                )
            } else {
                DraggableRadioSection(
                    onDragUp = { dropdownOnTop = true }
                )
                DraggableDropdownSection(
                    myFavoritesExpanded = myFavoritesExpanded,
                    mostCommonExpanded = mostCommonExpanded,
                    psychExpanded = psychExpanded,
                    lsrdExpanded = lsrdExpanded,
                    behavioralHealthExpanded = behavioralHealthExpanded,
                    officeOutpatientExpanded = officeOutpatientExpanded,
                    inpatientExpanded = inpatientExpanded,
                    auditingExpanded = auditingExpanded,
                    onMyFavoritesToggle = { myFavoritesExpanded = !myFavoritesExpanded },
                    onMostCommonToggle = { mostCommonExpanded = !mostCommonExpanded },
                    onPsychToggle = { psychExpanded = !psychExpanded },
                    onLsrdToggle = { lsrdExpanded = !lsrdExpanded },
                    onBehavioralHealthToggle = { behavioralHealthExpanded = !behavioralHealthExpanded },
                    onOfficeOutpatientToggle = { officeOutpatientExpanded = !officeOutpatientExpanded },
                    onInpatientToggle = { inpatientExpanded = !inpatientExpanded },
                    onAuditingToggle = { auditingExpanded = !auditingExpanded },
                    onDragDown = { dropdownOnTop = false }
                )
            }
        }
    }


}

@Composable
private fun DraggableRadioSection(
    onDragUp: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .pointerInput(Unit) {
                detectDragGestures { _, dragAmount ->
                    if (dragAmount.y < -100) {
                        onDragUp()
                    }
                }
            },
        color = Color.White,
        shape = RoundedCornerShape(bottomStart = 0.dp, bottomEnd = 0.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .width(40.dp)
                        .height(4.dp)
                        .background(Color.Gray, RoundedCornerShape(2.dp))
                )
            }
            BillingCodesList()
        }
    }
}

@Composable
private fun DraggableDropdownSection(
    myFavoritesExpanded: Boolean,
    mostCommonExpanded: Boolean,
    psychExpanded: Boolean,
    lsrdExpanded: Boolean,
    behavioralHealthExpanded: Boolean,
    officeOutpatientExpanded: Boolean,
    inpatientExpanded: Boolean,
    auditingExpanded: Boolean,
    onMyFavoritesToggle: () -> Unit,
    onMostCommonToggle: () -> Unit,
    onPsychToggle: () -> Unit,
    onLsrdToggle: () -> Unit,
    onBehavioralHealthToggle: () -> Unit,
    onOfficeOutpatientToggle: () -> Unit,
    onInpatientToggle: () -> Unit,
    onAuditingToggle: () -> Unit,
    onDragDown: () -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Color(0xFFE53E3E),
                RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
            )
            .padding(16.dp)
            .pointerInput(Unit) {
                detectDragGestures { _, dragAmount ->
                    if (dragAmount.y > 100) {
                        onDragDown()
                    }
                }
            },
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .width(40.dp)
                        .height(4.dp)
                        .background(Color.White, RoundedCornerShape(2.dp))
                )
            }
        }
        item {
            ExpandableDropdownItem(
                title = "My Favorites",
                expanded = myFavoritesExpanded,
                onToggle = onMyFavoritesToggle,
                items = listOf("Favorite Item 1", "Favorite Item 2", "Favorite Item 3")
            )
        }
        item {
            ExpandableDropdownItem(
                title = "Most Common",
                expanded = mostCommonExpanded,
                onToggle = onMostCommonToggle,
                items = listOf("Common Code 1", "Common Code 2", "Common Code 3")
            )
        }
        item {
            ExpandableDropdownItem(
                title = "Psych",
                expanded = psychExpanded,
                onToggle = onPsychToggle,
                items = listOf(
                    "90832 - Psytx Pt&/Family 30 Minutes",
                    "90834 - Psytx Pt&/Family 45 Minutes",
                    "90837 - Psytx Pt&/Family 60 Minutes"
                )
            )
        }
        item {
            ExpandableDropdownItem(
                title = "LSRD (End Stage Renal Disease)",
                expanded = lsrdExpanded,
                onToggle = onLsrdToggle,
                items = listOf("LSRD Code 1", "LSRD Code 2", "LSRD Code 3")
            )
        }
        item {
            ExpandableDropdownItem(
                title = "Behavioral Health",
                expanded = behavioralHealthExpanded,
                onToggle = onBehavioralHealthToggle,
                items = listOf("Behavioral Code 1", "Behavioral Code 2", "Behavioral Code 3")
            )
        }
        item {
            ExpandableDropdownItem(
                title = "Office/outpatient",
                expanded = officeOutpatientExpanded,
                onToggle = onOfficeOutpatientToggle,
                items = listOf("Office Code 1", "Office Code 2", "Office Code 3")
            )
        }
        item {
            ExpandableDropdownItem(
                title = "Inpatient",
                expanded = inpatientExpanded,
                onToggle = onInpatientToggle,
                items = listOf("Inpatient Code 1", "Inpatient Code 2", "Inpatient Code 3")
            )
        }
        item {
            ExpandableDropdownItem(
                title = "Auditing",
                expanded = auditingExpanded,
                onToggle = onAuditingToggle,
                items = listOf("Audit Code 1", "Audit Code 2", "Audit Code 3")
            )
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
            BottomButtons()
            Spacer(modifier = Modifier.height(16.dp))
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
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            ),
        color = Color.White,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
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
                
                // Animated arrow rotation
                val rotationAngle: Float by animateFloatAsState(
                    targetValue = if (expanded) 180f else 0f,
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessMedium
                    ),
                    label = "arrow_rotation"
                )
                
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = if (expanded) "Collapse" else "Expand",
                    tint = Color(0xFFE53E3E),
                    modifier = Modifier
                        .size(24.dp)
                        .graphicsLayer { 
                            rotationZ = rotationAngle 
                        }
                )
            }
            
            // Expandable content with smooth animation
            AnimatedVisibility(
                visible = expanded,
                enter = expandVertically(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                ) + slideInVertically(
                    initialOffsetY = { -it / 2 },
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                ),
                exit = shrinkVertically(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                ) + slideOutVertically(
                    targetOffsetY = { -it / 2 },
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFF5F5F5))
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    items.forEach { item ->
                        Surface(
                            modifier = Modifier.fillMaxWidth(),
                            color = Color.White,
                            shape = RoundedCornerShape(6.dp),
                            shadowElevation = 2.dp
                        ) {
                            Text(
                                text = item,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable { /* Handle item click */ }
                                    .padding(14.dp),
                                fontSize = 13.sp,
                                color = Color.Black,
                                lineHeight = 18.sp
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
            Text("Add to Favorite", fontSize = 12.sp, fontWeight = FontWeight.Medium)
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
            Text("Remove from Favorite", fontSize = 12.sp, fontWeight = FontWeight.Medium)
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
            Text("Next", fontSize = 12.sp, fontWeight = FontWeight.Medium)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ServicesBillingCodesScreenPreview() {
    ServicesBillingCodesScreen(navController = rememberNavController())
}
