package com.app.splashscreen.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.splashscreen.R

@Composable
fun DashboardStatusCard(
    name: String = "John Paul",
    location: String = "Michigon, United States"
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 32.dp, start = 16.dp, end = 16.dp)
    ) {
        // Card background
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(170.dp)
                .clip(RoundedCornerShape(32.dp))
                .background(Color.White.copy(alpha = 0.7f))
        )
        // Card content
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(170.dp)
                .padding(horizontal = 28.dp, vertical = 24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Profile image with border
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(Color.White)
                    .border(1.dp, Color(0xFFEB474B), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_dashboard_profile),
                    contentDescription = "Profile",
                    modifier = Modifier.size(86.dp)
                )
            }
            Spacer(modifier = Modifier.width(18.dp))
            // Name and location
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Hello, $name",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 32.sp
                )
                Spacer(modifier = Modifier.height(6.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_dashboard_top_sider), // Replace with location pin icon
                        contentDescription = "Location Pin",
                        modifier = Modifier.size(26.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = location,
                        color = Color.White,
                        fontSize = 20.sp
                    )
                }
            }
            Spacer(modifier = Modifier.width(18.dp))
            // Edit icon
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_dashboard_edit),
                    contentDescription = "Edit",
                    modifier = Modifier.size(34.dp)
                )
            }
        }
        // Removed bell and sider icons from top left and right
    }
}

@Preview
@Composable
fun DashboardStatusCardPreview() {
    DashboardStatusCard()
}
