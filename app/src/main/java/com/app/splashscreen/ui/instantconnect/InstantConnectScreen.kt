package com.app.splashscreen.ui.instantconnect

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.app.splashscreen.R
import com.app.splashscreen.ui.components.DashboardTopBar
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController

@Composable
fun InstantConnectScreen(navController: NavController) {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var cellNumber by remember { mutableStateOf("") }
    var birthdate by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("Male") }
    var address by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    var state by remember { mutableStateOf("") }
    var zipcode by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // ✅ Header
        DashboardTopBar(
            title = "Instant Connect",
            backIconRes = R.drawable.ic_dashboard_arrow_backward,
            endIconRes = R.drawable.ic_dcd_hospital,
            showBackIcon = true,
            showEndIcon = true,
            onBackClick = { navController.popBackStack() }
        )

        Spacer(modifier = Modifier.height(8.dp))

        // ✅ Content
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            contentPadding = PaddingValues(horizontal = 18.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item { InputField(label = "First Name", value = firstName, onValueChange = { firstName = it }) }
            item { InputField(label = "Last Name", value = lastName, onValueChange = { lastName = it }) }
            item { InputField(label = "Email", value = email, onValueChange = { email = it }) }
            item { InputField(label = "Cell Number", value = cellNumber, onValueChange = { cellNumber = it }, placeholder = "Format: 181028020066") }
            item {
                InputField(
                    label = "Patient Birthdate",
                    value = birthdate,
                    onValueChange = { birthdate = it },
                    trailingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.callender),
                            contentDescription = "Calendar",
                            tint = Color(0xFFED202E),
                            modifier = Modifier.size(24.dp)
                        )
                    }
                )
            }
            item {
                Text("Gender", fontWeight = FontWeight.Bold, fontSize = 15.sp, color = Color.Black)
                Spacer(modifier = Modifier.height(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = gender == "Male",
                        onClick = { gender = "Male" },
                        colors = RadioButtonDefaults.colors(selectedColor = Color(0xFF00B2FF))
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Icon(painter = painterResource(id = R.drawable.male_gender), contentDescription = "Male", tint = Color(0xFF00B2FF), modifier = Modifier.size(32.dp))
                    Text("Male", fontSize = 14.sp, color = Color.Black, modifier = Modifier.padding(start = 4.dp))

                    Spacer(modifier = Modifier.width(24.dp))

                    RadioButton(
                        selected = gender == "Female",
                        onClick = { gender = "Female" },
                        colors = RadioButtonDefaults.colors(selectedColor = Color(0xFFFF2D92))
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Icon(painter = painterResource(id = R.drawable.femenine_gender), contentDescription = "Female", tint = Color(0xFFFF2D92), modifier = Modifier.size(32.dp))
                    Text("Female", fontSize = 14.sp, color = Color.Black, modifier = Modifier.padding(start = 4.dp))
                }
            }
            item { InputField(label = "Address", value = address, onValueChange = { address = it }, singleLine = false, minLines = 2) }
            item {
                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    InputField(
                        label = "City",
                        value = city,
                        onValueChange = { city = it },
                        modifier = Modifier.weight(1f),
                        trailingIcon = {
                            Icon(painter = painterResource(id = R.drawable.dropdown_red), contentDescription = "Dropdown", tint = Color(0xFFED202E))
                        }
                    )
                    InputField(
                        label = "State",
                        value = state,
                        onValueChange = { state = it },
                        modifier = Modifier.weight(1f),
                        trailingIcon = {
                            Icon(painter = painterResource(id = R.drawable.dropdown_red), contentDescription = "Dropdown", tint = Color(0xFFED202E))
                        }
                    )
                }
            }
            item { InputField(label = "Zipcode", value = zipcode, onValueChange = { zipcode = it }) }

            item {
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { /* TODO: Send instant connect invitation */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFED202E)),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.fillMaxWidth().height(48.dp)
                ) {
                    Text("Send instant connect invitation", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                }
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = { /* TODO: Not Now */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.fillMaxWidth().height(48.dp)
                ) {
                    Text("Not Now", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color.White)
                }
            }
        }
    }
}

@Composable
fun InputField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "",
    trailingIcon: @Composable (() -> Unit)? = null,
    singleLine: Boolean = true,
    minLines: Int = 1
) {
    Column(modifier = modifier) {
        Text(label, fontWeight = FontWeight.Bold, fontSize = 15.sp, color = Color.Black)
        Spacer(modifier = Modifier.height(6.dp))
        TextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = { if (placeholder.isNotEmpty()) Text(placeholder, color = Color(0xFFBDBDBD)) },
            trailingIcon = trailingIcon,
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(24.dp),
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 48.dp)
                .background(Color.White, RoundedCornerShape(24.dp)),
            singleLine = singleLine,
            minLines = minLines,
            textStyle = LocalTextStyle.current.copy(fontSize = 15.sp, color = Color.Black)
        )
    }
}

@Preview
@Composable
fun InstantConnectScreenPreview() {
    InstantConnectScreen(navController = rememberNavController())
}
