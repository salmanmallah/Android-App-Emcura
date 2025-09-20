package com.app.splashscreen.ui.emr_patients

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.splashscreen.R



@Composable
fun EmrPatients(
    onSearchClick: () -> Unit = {},
    onDobClick: () -> Unit = {}
) {
    var field1 by remember { mutableStateOf("") }
    var field2 by remember { mutableStateOf("") }
    var field3 by remember { mutableStateOf("") }
    var field4 by remember { mutableStateOf("") }

    Surface(
        shape = RoundedCornerShape(32.dp),
        shadowElevation = 20.dp,
        color = Color(0xFFF7F7F7),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            // First Row
            Row(
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                OutlinedTextField(
                    value = field1,
                    onValueChange = { field1 = it },
                    placeholder = { Text("First Name", color = Color(0xFFCCCCCC)) },
                    singleLine = true,
                    modifier = Modifier
                        .weight(1f)
                        .height(60.dp)
                        .shadow(10.dp, RoundedCornerShape(24.dp)),
                    trailingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_dashboard_search),
                            contentDescription = "Search",
                            tint = Color(0xFFE94F4F)
                        )
                    },
                    shape = RoundedCornerShape(24.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color.Transparent,
                        focusedBorderColor = Color.Transparent,
                        disabledBorderColor = Color.Transparent,
                        errorBorderColor = Color.Transparent,
                        focusedContainerColor = Color(0xFFF7F7F7),
                        unfocusedContainerColor = Color(0xFFF7F7F7)
                    ),
                    textStyle = LocalTextStyle.current.copy(fontSize = 16.sp)
                )
                OutlinedTextField(
                    value = field2,
                    onValueChange = { field2 = it },
                    placeholder = { Text("Last Name", color = Color(0xFFCCCCCC)) },
                    singleLine = true,
                    modifier = Modifier
                        .weight(1f)
                        .height(60.dp)
                        .shadow(10.dp, RoundedCornerShape(24.dp)),
                    trailingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_dashboard_search),
                            contentDescription = "Search",
                            tint = Color(0xFFE94F4F)
                        )
                    },
                    shape = RoundedCornerShape(24.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color.Transparent,
                        focusedBorderColor = Color.Transparent,
                        disabledBorderColor = Color.Transparent,
                        errorBorderColor = Color.Transparent,
                        focusedContainerColor = Color(0xFFF7F7F7),
                        unfocusedContainerColor = Color(0xFFF7F7F7)
                    ),
                    textStyle = LocalTextStyle.current.copy(fontSize = 16.sp)
                )
            }
            // Second Row
            Row(
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                OutlinedTextField(
                    value = field3,
                    onValueChange = { field3 = it },
                    placeholder = { Text("Phone", color = Color(0xFFCCCCCC)) },
                    singleLine = true,
                    modifier = Modifier
                        .weight(1f)
                        .height(60.dp)
                        .shadow(10.dp, RoundedCornerShape(24.dp)),
                    trailingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_dashboard_search),
                            contentDescription = "Search",
                            tint = Color(0xFFE94F4F)
                        )
                    },
                    shape = RoundedCornerShape(24.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color.Transparent,
                        focusedBorderColor = Color.Transparent,
                        disabledBorderColor = Color.Transparent,
                        errorBorderColor = Color.Transparent,
                        focusedContainerColor = Color(0xFFF7F7F7),
                        unfocusedContainerColor = Color(0xFFF7F7F7)
                    ),
                    textStyle = LocalTextStyle.current.copy(fontSize = 16.sp)
                )
                OutlinedTextField(
                    value = field4,
                    onValueChange = { field4 = it },
                    placeholder = { Text("Zipcode", color = Color(0xFFCCCCCC)) },
                    singleLine = true,
                    modifier = Modifier
                        .weight(1f)
                        .height(60.dp)
                        .shadow(10.dp, RoundedCornerShape(24.dp)),
                    trailingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_dashboard_search),
                            contentDescription = "Search",
                            tint = Color(0xFFE94F4F)
                        )
                    },
                    shape = RoundedCornerShape(24.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color.Transparent,
                        focusedBorderColor = Color.Transparent,
                        disabledBorderColor = Color.Transparent,
                        errorBorderColor = Color.Transparent,
                        focusedContainerColor = Color(0xFFF7F7F7),
                        unfocusedContainerColor = Color(0xFFF7F7F7)
                    ),
                    textStyle = LocalTextStyle.current.copy(fontSize = 16.sp)
                )
            }
            // Buttons Row
            Row(
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                // DOB Button
                Surface(
                    shape = RoundedCornerShape(16.dp),
                    shadowElevation = 8.dp,
                    color = Color(0xFFF5F5F5),
                    modifier = Modifier
                        .weight(1f)
                        .height(60.dp)
                        .clickable { onDobClick() }
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Text(
                            text = "DOB",
                            color = Color(0xFFE94F4F),
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                    }
                }
                // Search Button
                Surface(
                    shape = RoundedCornerShape(16.dp),
                    shadowElevation = 8.dp,
                    color = Color(0xFFE94F4F),
                    modifier = Modifier
                        .weight(1f)
                        .height(60.dp)
                        .clickable { onSearchClick() }
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Text(
                            text = "Search",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EmrPatientsPreview() {
    EmrPatients()
}
