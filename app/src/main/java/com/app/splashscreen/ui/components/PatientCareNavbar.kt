package com.app.splashscreen.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.app.splashscreen.R

@Composable
fun PatientCareNavbar(
    icons: List<Int>,
    onIconClick: (Int) -> Unit,
    centerIcon: Int,
    centerText: String
) {
    Box(
        modifier = Modifier
            .height(80.dp)
            .background(
                color = Color(0xFFE94F4F),
                shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
                .padding(horizontal = 32.dp, vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            icons.forEachIndexed { index, iconRes ->
                Icon(
                    painter = painterResource(id = iconRes),
                    contentDescription = "Nav Icon $index",
                    tint = Color.White,
                    modifier = Modifier.size(32.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PatientCareNavbarPreview() {
    PatientCareNavbar(
        onIconClick = {},
        icons = listOf(
            R.drawable.ic_dashboard_power,
            R.drawable.ic_dashboard_waitingroom,
            R.drawable.ic_dashboard_support,
            R.drawable.ic_dashboard_masseges,
        ),
        centerIcon = 0,
        centerText = ""
    )
}
