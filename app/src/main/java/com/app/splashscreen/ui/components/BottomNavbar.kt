package com.app.splashscreen.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.Image
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
fun BottomNavbar(
    icons: List<Int>,
    onIconClick: (Int) -> Unit,
    centerImageResId: Int
) {
        Box(
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
        ) {
            // Bottom bar background
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .align(Alignment.BottomCenter)
                    .background(
                        color = Color(0xFFE94F4F),
                        shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)
                    )
            )

            // Row for icons, with space for center card
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(horizontal = 32.dp, vertical = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Left icons
                icons.take(icons.size / 2).forEachIndexed { index, iconRes ->
                    Icon(
                        painter = painterResource(id = iconRes),
                        contentDescription = "Nav Icon $index",
                        tint = Color.White,
                        modifier = Modifier.size(32.dp)
                    )
                }

                Spacer(modifier = Modifier.width(64.dp)) // Space for center card

                // Right icons
                icons.drop(icons.size / 2).forEachIndexed { index, iconRes ->
                    Icon(
                        painter = painterResource(id = iconRes),
                        contentDescription = "Nav Icon ${index + icons.size / 2}",
                        tint = Color.White,
                        modifier = Modifier.size(32.dp)
                    )
                }
            }

            // Center circular card
            Image(
                painter = painterResource(id = centerImageResId),
                contentDescription = "Center Image",
                modifier = Modifier
                    .size(96.dp)
                    .align(Alignment.BottomCenter)
                    .offset(y = (-32).dp)
            )
        }
}

@Preview(showBackground = true)
@Composable
fun BottomNavbarPreview() {
    BottomNavbar(
        onIconClick = {},
        icons = listOf(
            R.drawable.ic_dashboard_power,
            R.drawable.ic_dashboard_waitingroom,
            R.drawable.ic_dashboard_support,
            R.drawable.ic_dashboard_masseges,
        ),
        centerImageResId = R.drawable.ic_dashboard_bell_patientcare // Replace with your image resource
    )
}
