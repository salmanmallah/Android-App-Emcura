package com.app.splashscreen.ui.login

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
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun LoginScreen(navController: NavController = rememberNavController()) {
    val configuration = androidx.compose.ui.platform.LocalConfiguration.current
    val screenHeightPx = with(androidx.compose.ui.platform.LocalDensity.current) { configuration.screenHeightDp.dp.toPx() }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.White,           // top 70% pure white
                        Color(0xFFFFE6E6),    // start pink
                        Color(0xFFFAD2D2)     // darker pink
                    ),
                    startY = screenHeightPx * 0.5f,   // 70% height se gradient start
                    endY = screenHeightPx            // bottom tak
                )
            )
    ) {
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
//            Spacer(modifier = Modifier.height(8.dp))
//            Text(
//                text = "emcura medical",
//                color = Color(0xFFC2185B),
//                fontSize = 28.sp,
//                fontWeight = FontWeight.Bold
//            )
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(0.8f)
            ) {
                Divider(modifier = Modifier.weight(1f), color = Color(0xFFBDBDBD))
                Text(
                    text = "  Log in  ",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color.Black
                )
                Divider(modifier = Modifier.weight(1f), color = Color(0xFFBDBDBD))
            }
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Sign in using email if or username:",
                fontWeight = FontWeight.W600,
                fontSize = 14.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(16.dp))
            var email by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }
            var passwordVisible by remember { mutableStateOf(false) }
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email/Username") },
                leadingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.login_profile),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                },
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .height(56.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFFC2185B),
                    unfocusedBorderColor = Color(0xFFE0E0E0)
                )
            )
            Spacer(modifier = Modifier.height(12.dp))
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                leadingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.login_key),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                },
                trailingIcon = {
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            painter = painterResource(
                                id = if (passwordVisible) R.drawable.visibility else R.drawable.visibility_off
                            ),
                            contentDescription = if (passwordVisible) "Hide password" else "Show password"
                        )
                    }
                },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                singleLine = true,
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .height(56.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFFC2185B),
                    unfocusedBorderColor = Color(0xFFE0E0E0)
                )
            )
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
                Text("Login", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            }
            Spacer(modifier = Modifier.height(16.dp))
            TextButton(onClick = { navController.navigate("forget_password_email") }) {
                Text("Forget Password?", color = Color.Gray, fontWeight = FontWeight.Bold, fontSize = 15.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}
