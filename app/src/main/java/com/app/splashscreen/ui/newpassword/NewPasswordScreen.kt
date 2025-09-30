package com.app.splashscreen.ui.newpassword

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.splashscreen.R
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun NewPasswordScreen(navController: NavController) {
    val configuration = androidx.compose.ui.platform.LocalConfiguration.current
    val screenHeightPx = with(androidx.compose.ui.platform.LocalDensity.current) { configuration.screenHeightDp.dp.toPx() }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.White,
                        Color(0xFFFFE6E6),
                        Color(0xFFFAD2D2)
                    ),
                    startY = screenHeightPx * 0.5f,
                    endY = screenHeightPx
                )
            )
    ) {
        var newPassword by remember { mutableStateOf("") }
        var confirmPassword by remember { mutableStateOf("") }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(100.dp))

            // 🔹 Logo
            Image(
                painter = painterResource(id = R.drawable.red_logo),
                contentDescription = "Emcura Logo",
                modifier = Modifier
                    .width(280.dp)
                    .height(64.dp)
            )
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(0.8f)
            ) {
                Divider(modifier = Modifier.weight(1f), color = Color(0xFFBDBDBD))
                Text(
                    text = "  NEW PASSWORD  ",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color.Black
                )
                Divider(modifier = Modifier.weight(1f), color = Color(0xFFBDBDBD))
            }
            Spacer(modifier = Modifier.height(24.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.85f)
            ) {

                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = newPassword,
                    onValueChange = { newPassword = it },
                    label = { Text("New Password") },
                    leadingIcon = {
                        Image(
                            painter = painterResource(id = R.drawable.login_key),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    visualTransformation = PasswordVisualTransformation(),
                    shape = RoundedCornerShape(24.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFFC2185B),
                        unfocusedBorderColor = Color(0xFFE0E0E0)
                    )
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.85f)
            ) {

                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = confirmPassword,
                    onValueChange = { confirmPassword = it },
                    label = { Text("Confirm Password") },
                    leadingIcon = {
                        Image(
                            painter = painterResource(id = R.drawable.login_key),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    visualTransformation = PasswordVisualTransformation(),
                    shape = RoundedCornerShape(24.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFFC2185B),
                        unfocusedBorderColor = Color(0xFFE0E0E0)
                    )
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = { navController.navigate("dashboard") },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEB474B)),
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .height(48.dp),
                shape = RoundedCornerShape(8.dp),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 8.dp)
            ) {
                Text("Reset Password", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NewPasswordScreenPreview() {
    NewPasswordScreen(navController = rememberNavController())
}
