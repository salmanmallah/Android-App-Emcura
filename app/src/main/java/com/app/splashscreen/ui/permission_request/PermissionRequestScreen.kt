package com.app.splashscreen.ui.permission_request


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.splashscreen.R

@Composable
fun PermissionRequestScreen(navController: NavController? = null) {
    val context = LocalContext.current
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(100.dp))

            Image(
                painter = painterResource(id = R.drawable.red_logo),
                contentDescription = "Emcura Logo",
                modifier = Modifier
                    .width(280.dp)
                    .height(64.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

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

            Surface(
                shadowElevation = 8.dp,
                shape = RoundedCornerShape(12.dp),
                color = Color.Transparent
            ) {
                Button(
                    onClick = {
                        navController?.navigate("login") {
                            popUpTo("permission_request") { inclusive = true }
                        }
                    },
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
            }

            Spacer(modifier = Modifier.height(16.dp))

            Surface(
                shadowElevation = 8.dp,
                shape = RoundedCornerShape(12.dp),
                color = Color.Transparent
            ) {
                Button(
                    onClick = {
                        if (navController != null && navController.popBackStack().not()) {
                            (context as? android.app.Activity)?.finish()
                        }
                    },
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
    }


@Preview(showBackground = true)
@Composable
fun PermissionRequestScreenPreview() {
    PermissionRequestScreen()
}
