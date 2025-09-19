package com.app.splashscreen.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.splashscreen.R
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun DoctorSearchBar(
    modifier: Modifier = Modifier,
    placeholder: String = "Search"
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .shadow(
                elevation = 6.dp, // shadow ki height
                shape = RoundedCornerShape(24.dp) // same shape jo background me use kiya
            )
            .background(Color.White, RoundedCornerShape(24.dp))
            .height(44.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Text(
                text = placeholder,
                color = Color(0xFFBDBDBD),
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                painter = painterResource(id = R.drawable.ic_dashboard_search),
                contentDescription = "Search",
                tint = Color(0xFFBDBDBD)
            )
        }
    }
}

@Preview
@Composable
fun DoctorSearchBarPreview() {
    Column(modifier = Modifier.padding(16.dp)) {
        DoctorSearchBar()
    }
}
