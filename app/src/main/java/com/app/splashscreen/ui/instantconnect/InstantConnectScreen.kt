package com.app.splashscreen.ui.instantconnect

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.app.splashscreen.R
import com.app.splashscreen.ui.components.DashboardTopBar

@Composable
fun InstantConnectScreen(navController: NavController) {
    // painters (callable from a Composable)
    val calendarIcon: Painter = painterResource(id = R.drawable.callender)
    val maleIcon: Painter = painterResource(id = R.drawable.male_gender)
    val femaleIcon: Painter = painterResource(id = R.drawable.femenine_gender)
    val dropdownIcon: Painter = painterResource(id = R.drawable.dropdown_red)

    // form state
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var cellNumber by remember { mutableStateOf("") }
    var birthdate by remember { mutableStateOf("") }
    var showDatePicker by remember { mutableStateOf(false) }
    var gender by remember { mutableStateOf("Male") }
    var address by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    var showCityDropdown by remember { mutableStateOf(false) }
    var state by remember { mutableStateOf("") }
    var showStateDropdown by remember { mutableStateOf(false) }
    var zipcode by remember { mutableStateOf("") }

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(scrollState)
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        // Top bar
        DashboardTopBar(
            title = "Instant Connect",
            backIconRes = R.drawable.ic_dashboard_arrow_backward,
            endIconRes = R.drawable.ic_dcd_hospital,
            showBackIcon = true,
            showEndIcon = true,
            onBackClick = { navController.popBackStack() }
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Form fields
        InputField(label = "First Name", value = firstName, onValueChange = { firstName = it })
        Spacer(modifier = Modifier.height(12.dp))
        InputField(label = "Last Name", value = lastName, onValueChange = { lastName = it })
        Spacer(modifier = Modifier.height(12.dp))
        InputField(label = "Email", value = email, onValueChange = { email = it })
        Spacer(modifier = Modifier.height(12.dp))
        InputField(
            label = "Cell Number",
            value = cellNumber,
            onValueChange = { cellNumber = it },
            placeholder = "Format: 181028020066"
        )
        Spacer(modifier = Modifier.height(12.dp))

        InputField(
            label = "Patient Birthdate",
            value = birthdate,
            onValueChange = { birthdate = it },
            trailingIcon = {
                Icon(
                    painter = calendarIcon,
                    contentDescription = "Calendar",
                    tint = Color(0xFFED202E),
                    modifier = Modifier
                        .size(24.dp)
                        .clickable { showDatePicker = true }
                )
            }
        )

        if (showDatePicker) {
            DatePickerDialog(
                onDateSelected = {
                    birthdate = it
                    showDatePicker = false
                },
                onDismiss = { showDatePicker = false }
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        GenderSelector(
            selectedGender = gender,
            onGenderSelected = { gender = it },
            maleIcon = maleIcon,
            femaleIcon = femaleIcon
        )

        Spacer(modifier = Modifier.height(12.dp))

        InputField(label = "Address", value = address, onValueChange = { address = it }, singleLine = false, minLines = 2)

        Spacer(modifier = Modifier.height(12.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(12.dp), modifier = Modifier.fillMaxWidth()) {
            // City with dropdown
            Box(modifier = Modifier.weight(1f)) {
                InputField(
                    label = "City",
                    value = city,
                    onValueChange = { city = it },
                    trailingIcon = {
                        Icon(
                            painter = dropdownIcon,
                            contentDescription = "Dropdown",
                            tint = Color(0xFFED202E),
                            modifier = Modifier
                                .size(22.dp)
                                .clickable { showCityDropdown = true }
                        )
                    }
                )

                DropdownMenu(
                    expanded = showCityDropdown,
                    onDismissRequest = { showCityDropdown = false },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    DropdownMenuItem(text = { Text("City Option 1") }, onClick = { city = "City Option 1"; showCityDropdown = false })
                    DropdownMenuItem(text = { Text("City Option 2") }, onClick = { city = "City Option 2"; showCityDropdown = false })
                }
            }

            // State with dropdown
            Box(modifier = Modifier.weight(1f)) {
                InputField(
                    label = "State",
                    value = state,
                    onValueChange = { state = it },
                    trailingIcon = {
                        Icon(
                            painter = dropdownIcon,
                            contentDescription = "Dropdown",
                            tint = Color(0xFFED202E),
                            modifier = Modifier
                                .size(22.dp)
                                .clickable { showStateDropdown = true }
                        )
                    }
                )

                DropdownMenu(
                    expanded = showStateDropdown,
                    onDismissRequest = { showStateDropdown = false },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    DropdownMenuItem(text = { Text("State Option 1") }, onClick = { state = "State Option 1"; showStateDropdown = false })
                    DropdownMenuItem(text = { Text("State Option 2") }, onClick = { state = "State Option 2"; showStateDropdown = false })
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        InputField(label = "Zipcode", value = zipcode, onValueChange = { zipcode = it })

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { /* TODO: Send instant connect invitation */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFED202E)),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .shadow(8.dp, RoundedCornerShape(12.dp))
        ) {
            Text("Send instant connect invitation", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color.White)
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = { /* TODO: Not Now */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .shadow(8.dp, RoundedCornerShape(12.dp))
        ) {
            Text("Not Now", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color.White)
        }

        Spacer(modifier = Modifier.height(24.dp))
    }
}

/* ---------- Helpers / sub-composables ---------- */

@Composable
fun GenderSelector(selectedGender: String, onGenderSelected: (String) -> Unit, maleIcon: Painter, femaleIcon: Painter) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        GenderCard(
            selected = selectedGender == "Male",
            icon = maleIcon,
            label = "Male",
            color = Color(0xFF00B2FF),
            onClick = { onGenderSelected("Male") }
        )
        GenderCard(
            selected = selectedGender == "Female",
            icon = femaleIcon,
            label = "Female",
            color = Color(0xFFFF2D92),
            onClick = { onGenderSelected("Female") }
        )
    }
}

@Composable
fun GenderCard(
    selected: Boolean,
    icon: Painter,
    label: String,
    color: Color,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
//            .weight(1f) // ✅ Yaha lagao (Row ke andar jab call hoga)
            .clip(RoundedCornerShape(12.dp))
            .background(if (selected) color.copy(alpha = 0.08f) else Color.White)
            .border(
                width = 2.dp,
                color = if (selected) color else Color(0xFFE0E0E0),
                shape = RoundedCornerShape(12.dp)
            )
            .clickable { onClick() }
            .padding(vertical = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center // ✅ Center align karega
    ) {
        Icon(
            painter = icon,
            contentDescription = label,
            tint = color,
            modifier = Modifier.size(32.dp)
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = label,
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp,
            color = color
        )
    }
}


/**
 * Simple date picker dialog stub for preview/testing.
 * Replace with MaterialDatePicker or AndroidView-based date picker if you need a real calendar.
 */
@Composable
fun DatePickerDialog(onDateSelected: (String) -> Unit, onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Select Date") },
        text = {
            Column {
                Spacer(modifier = Modifier.height(6.dp))
                Button(onClick = { onDateSelected("01/01/2000") }) { Text("01/01/2000") }
                Spacer(modifier = Modifier.height(6.dp))
                Button(onClick = { onDateSelected("24/09/2025") }) { Text("24/09/2025") }
            }
        },
        confirmButton = {},
        dismissButton = {}
    )
}

@Composable
fun InputField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "",
    trailingIcon: (@Composable () -> Unit)? = null,
    singleLine: Boolean = true,
    minLines: Int = 1
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(label, fontWeight = FontWeight.Bold, fontSize = 15.sp, color = Color.Black)
        Spacer(modifier = Modifier.height(6.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(6.dp, RoundedCornerShape(24.dp))
                    .border(1.5.dp, Color(0xFFED202E), RoundedCornerShape(24.dp))
                    .background(Color.White, RoundedCornerShape(24.dp))
            ) {
                TextField(
                    value = value,
                    onValueChange = onValueChange,
                    placeholder = { if (placeholder.isNotEmpty()) Text(placeholder, color = Color(0xFFBDBDBD)) },
                    trailingIcon = trailingIcon,
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    shape = RoundedCornerShape(24.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(min = 48.dp),
                    singleLine = singleLine,
                    minLines = minLines,
                    textStyle = LocalTextStyle.current.copy(fontSize = 15.sp, color = Color.Black)
                )
            }
    }
}

/* ---------- Preview ---------- */
@Preview(showBackground = true)
@Composable
fun InstantConnectScreenPreview() {
    // preview uses a fake nav controller
    InstantConnectScreen(navController = rememberNavController())
}
