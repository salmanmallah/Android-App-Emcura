package com.app.splashscreen.ui.password_otp

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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.splashscreen.R
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PasswordOtpScreen() {
    var code1 by remember { mutableStateOf("") }
    var code2 by remember { mutableStateOf("") }
    var code3 by remember { mutableStateOf("") }
    var code4 by remember { mutableStateOf("") }

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
                    endY = 2500f
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
                    text = "  VERIFICATION  ",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color.Black
                )
                Divider(modifier = Modifier.weight(1f), color = Color(0xFFBDBDBD))
            }
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = "Enter Verification Code:",
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                color = Color(0xFF222222),
                modifier = Modifier.align(Alignment.Start).padding(start = 55.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(14.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 48.dp)
            ) {
                OtpTextField(value = code1, onValueChange = { if (it.length <= 1) code1 = it })
                OtpTextField(value = code2, onValueChange = { if (it.length <= 1) code2 = it })
                OtpTextField(value = code3, onValueChange = { if (it.length <= 1) code3 = it })
                OtpTextField(value = code4, onValueChange = { if (it.length <= 1) code4 = it })
            }
            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = { /* TODO: Confirm action */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE94F4F)),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .height(48.dp)
            ) {
                Text(text = "Confirm", color = Color.White, fontSize = 18.sp)
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "If you didn't Receive a Code. ",
                    color = Color.Black,
                    fontSize = 13.sp
                )
                Text(
                    text = "Resend",
                    color = Color(0xFFE94F4F),
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp,
                    modifier = Modifier.padding(start = 2.dp)
                )
            }
        }
    }
}

@Composable
fun OtpTextField(value: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        shape = RoundedCornerShape(50),
        modifier = Modifier
            .width(46.dp)
            .height(46.dp),
        textStyle = LocalTextStyle.current.copy(
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        ),
//        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        visualTransformation = VisualTransformation.None
    )
}

@Preview(showBackground = true)
@Composable
fun PasswordOtpScreenPreview() {
    PasswordOtpScreen()
}