package com.app.splashscreen.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.app.splashscreen.R

@Composable
fun SearchBar(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(
                text = "Search",
                color = Color(0xFFBDBDBD),
                fontSize = 16.sp
            )
        },
        singleLine = true,
        textStyle = TextStyle(
            fontSize = 16.sp,
            lineHeight = 20.sp // 👈 ensures text sits higher
        ),
        trailingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_dashboard_search),
                contentDescription = "Search Icon",
                tint = Color(0xFFBDBDBD),
                modifier = Modifier.size(20.dp)
            )
        },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.White,
            focusedContainerColor = Color.White,
            disabledContainerColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
            .shadow(
                elevation = 6.dp,
                shape = RoundedCornerShape(24.dp),
                clip = true
            )
            .background(Color.White, RoundedCornerShape(24.dp))
            .padding(horizontal = 8.dp)
    )
}



@Preview(showBackground = true)
@Composable
fun SearchBarPreview() {
    val state = remember { mutableStateOf("") }
    SearchBar(
        value = state.value,
        onValueChange = { state.value = it },
        modifier = Modifier.padding(24.dp)
    )
}