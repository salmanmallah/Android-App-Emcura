package com.app.splashscreen.ui.permission_request

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
fun PermissionRequestScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.White,
                        Color(0xFFFFE6E6),
                        Color(0xFFFAD2D2),
                        Color(0xFFFAD2D2)
                    ),
                    startY = 0f,
                    endY = 1200f
                )
            ),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp))

            // 🔹 Logo
            Image(
                painter = painterResource(id = R.drawable.red_logo),
                contentDescription = "Emcura Logo",
                modifier = Modifier
                    .size(200.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            // 🔹 Title
            Text(
                text = "PERMISSIONS REQUIRED",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            Divider(
                color = Color(0xFFEB474B),
                thickness = 2.dp,
                modifier = Modifier.width(80.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // 🔹 Description
            Text(
                text = "Please allow the required permissions. Please note that certain app features will not work until you allow the required permissions.",
                color = Color.Black,
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(horizontal = 8.dp),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(32.dp))

            // 🔹 Review & Allow Button
            Button(
                onClick = { /* TODO: Handle permission review */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE94F4F)),
                modifier = Modifier
                    .width(300.dp)
                    .height(48.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "Review and Allow Permission",
                    color = Color.White,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // 🔹 Exit Button
            Button(
                onClick = { /* TODO: Handle exit */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE94F4F)),
                modifier = Modifier
                    .width(300.dp)
                    .height(48.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "Exit Now",
                    color = Color.White,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PermissionRequestScreenPreview() {
    PermissionRequestScreen()
}
