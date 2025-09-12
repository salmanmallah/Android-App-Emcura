package com.app.splashscreen.ui.dashboard


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.app.splashscreen.R
import com.app.splashscreen.ui.components.SearchBar
import com.app.splashscreen.ui.components.DashboardIconGrid
import com.app.splashscreen.ui.components.BottomNavbar
import androidx.compose.runtime.Composable



@Composable
fun DashboardScreen() {
	Box(
		modifier = Modifier.fillMaxSize().background(Color(0xFFF5F5F5)),
		contentAlignment = Alignment.Center
	) {
		Text(
			text = "Dashboard",
			color = Color(0xFFEB474B),
			fontWeight = FontWeight.Bold,
			fontSize = 32.sp
		)
	}
}


