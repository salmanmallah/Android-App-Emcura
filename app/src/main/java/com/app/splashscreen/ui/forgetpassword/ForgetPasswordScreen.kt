package com.app.splashscreen.ui.forgetpassword

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.splashscreen.R
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Composable
fun ForgetPasswordScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFF8F8F8),
                        Color.White,
                        Color(0xFFF8F8F8),
                        Color(0xFFFDE6EA),
                        Color(0xFFD3A8AC)
                    ),
                    startY = 0f,
                    endY = 2000f
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .padding(top = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            // Logo
            Image(
                painter = painterResource(id = R.drawable.red_logo),
                contentDescription = "Emcura Logo",
                modifier = Modifier.width(200.dp).height(100.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(0.8f)
            ) {
                Divider(modifier = Modifier.weight(1f), color = Color(0xFFBDBDBD))
                Text(
                    text = "  FORGET PASSWORD  ",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color.Black
                )
                Divider(modifier = Modifier.weight(1f), color = Color(0xFFBDBDBD))
            }
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Enter Email Address:",
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                color = Color(0xFF222222),
                modifier = Modifier.align(Alignment.Start).padding(start = 32.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                leadingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.email_username),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                },
                placeholder = { Text("Email/Username") },
                shape = RoundedCornerShape(50),
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(56.dp)
            )
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = { navController.navigate("password_otp") },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE94F4F)),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .height(48.dp)
            ) {
                Text(text = "Send", color = Color.White, fontSize = 18.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ForgetPasswordScreenPreview() {
    // ForgetPasswordScreen()
}
