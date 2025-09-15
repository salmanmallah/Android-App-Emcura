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
import androidx.compose.ui.res.colorResource
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
import com.app.splashscreen.ui.components.DashboardStatusCard



@Composable
fun DashboardScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.dashboard_background))
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_dashboard_background_pattern),
            contentDescription = null,
            modifier = Modifier
                .size(280.dp)
                .align(Alignment.TopEnd)
                .offset(x = (-16).dp, y = -16.dp),
            alpha = 0.25f // subtle overlay
        )
        // Top icons row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp, start = 24.dp, end = 24.dp)
                .align(Alignment.TopCenter),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_dashboard_top_sider),
                contentDescription = "Menu",
                modifier = Modifier.size(40.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_dashboard_bell),
                contentDescription = "Notifications",
                modifier = Modifier.size(40.dp)
            )
        }
        // Add DashboardStatusCard below top icons

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Top icons ke liye space
            Spacer(modifier = Modifier.height(80.dp))

            // Dashboard Status Card
            DashboardStatusCard()

            // Card aur neeche container ke beech gap
            Spacer(modifier = Modifier.height(16.dp))

            // White rounded container
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f) // bacha hua height le lega, har screen pe adjust hoga
                    .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                    .background(Color.White)
            ) {
                // Add your grid/content here
                SearchBar(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp, vertical = 24.dp)
                )
//                Spacer(modifier = Modifier.height(120.dp))
//                DashboardIconGrid(
//                    icons = listOf(
//                        R.drawable.ic_dashboard_connect,
//                        R.drawable.ic_dashboard_mic,
//                        R.drawable.ic_dashboard_prescription,
//                        R.drawable.ic_dashboard_call,
//                        R.drawable.ic_dashboard_connect,
//                        R.drawable.ic_dashboard_refill
//                    )
//                )



                // dashboard icons grid

            }
        }




        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        ) {
            BottomNavbar(
                icons = listOf(
                    R.drawable.ic_dashboard_power,
                    R.drawable.ic_dashboard_waitingroom,
                    R.drawable.ic_dashboard_support,
                    R.drawable.ic_dashboard_masseges,
                ),
                centerImageResId = R.drawable.ic_dashboard_bell_patientcare,
                onIconClick = {}
            )
        }


    }
}

@Preview(
    showBackground = true,
//    widthDp = 1080,
//    heightDp = 2400,
)
@Composable
fun DashboardScreenPreview() {
	DashboardScreen()
}


