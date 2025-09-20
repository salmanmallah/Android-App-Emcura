package com.app.splashscreen.ui.emr_patients

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
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
        shape = RoundedCornerShape(28.dp),
        shadowElevation = 16.dp,
        color = Color(0xFFF7F7F7),
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // First Row (First Name, Last Name)
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                CustomCenteredField(
                    value = field1,
                    onValueChange = { field1 = it },
                    placeholder = "First Name",
                    modifier = Modifier.weight(1f)
                )
                CustomCenteredField(
                    value = field2,
                    onValueChange = { field2 = it },
                    placeholder = "Last Name",
                    modifier = Modifier.weight(1f)
                )
            }

            // Second Row (Phone, Zipcode)
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                CustomCenteredField(
                    value = field3,
                    onValueChange = { field3 = it },
                    placeholder = "Phone",
                    modifier = Modifier.weight(1f)
                )
                CustomCenteredField(
                    value = field4,
                    onValueChange = { field4 = it },
                    placeholder = "Zipcode",
                    modifier = Modifier.weight(1f)
                )
            }

            // Buttons Row (DOB and Search in one row)
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                // DOB Button
                Surface(
                    shape = RoundedCornerShape(14.dp),
                    shadowElevation = 6.dp,
                    color = Color(0xFFF5F5F5),
                    modifier = Modifier
                        .weight(1f)
                        .height(44.dp)
                        .clickable { onDobClick() }
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "DOB",
                            color = Color(0xFFE94F4F),
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp
                        )
                    }
                }
                // Search Button
                Surface(
                    shape = RoundedCornerShape(14.dp),
                    shadowElevation = 6.dp,
                    color = Color(0xFFE94F4F),
                    modifier = Modifier
                        .weight(1f)
                        .height(44.dp)
                        .clickable { onSearchClick() }
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Search",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CustomCenteredField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .height(48.dp)
            .shadow(6.dp, RoundedCornerShape(20.dp))
            .background(Color(0xFFF7F7F7), RoundedCornerShape(20.dp))
            .border(0.dp, Color.Transparent, RoundedCornerShape(20.dp)),
        contentAlignment = Alignment.CenterStart
    ) {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            singleLine = true,
            textStyle = TextStyle(
                fontSize = 14.sp,
                color = Color.Black,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            ),
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp),
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    if (value.isEmpty()) {
                        Text(
                            text = placeholder,
                            fontSize = 14.sp,
                            color = Color(0xFFCCCCCC)
                        )
                    }
                    innerTextField()
                }
            }
        )

        // Trailing Search Icon
        Icon(
            painter = painterResource(id = R.drawable.ic_dashboard_search),
            contentDescription = "Search",
            tint = Color(0xFFE94F4F),
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 12.dp)
                .size(18.dp)
        )
    }
}

@Preview
@Composable
fun EmrPatientsPreview() {
    EmrPatients()
}
