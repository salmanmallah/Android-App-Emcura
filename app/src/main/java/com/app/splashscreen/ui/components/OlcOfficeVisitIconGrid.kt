package com.app.splashscreen.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.splashscreen.R
import androidx.compose.ui.Modifier
import androidx.compose.foundation.clickable
import androidx.navigation.NavController

@Composable
fun OlcOfficeVisitIconGrid(navController: NavController? = null) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // RealTime Notes
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.clickable {
                navController?.navigate("olcOffice")
            }
        ) {
            Surface(
                shape = CircleShape,
                color = Color.White,
                shadowElevation = 6.dp
            ) {
                Box(
                    modifier = Modifier.size(64.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.olc_screen_mic),
                        contentDescription = "RealTime Notes",
                        tint = Color(0xFFE94F4F),
                        modifier = Modifier.size(36.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "RealTime Notes",
                fontSize = 13.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )
        }
        // AI Based Notes
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Surface(
                shape = CircleShape,
                color = Color.White,
                shadowElevation = 6.dp
            ) {
                Box(
                    modifier = Modifier.size(64.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.olc_office_visit_notes),
                        contentDescription = "AI Based Notes",
                        tint = Color(0xFFE94F4F),
                        modifier = Modifier.size(36.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "AI Based Notes",
                fontSize = 13.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )
        }
        // Dictate Notes
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Surface(
                shape = CircleShape,
                color = Color.White,
                shadowElevation = 6.dp
            ) {
                Box(
                    modifier = Modifier.size(64.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.olc_office_visit_dicate_notes),
                        contentDescription = "Dictate Notes",
                        tint = Color(0xFFE94F4F),
                        modifier = Modifier.size(36.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Dictate Notes",
                fontSize = 13.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OlcOfficeVisitIconGridPreview() {
    OlcOfficeVisitIconGrid()
}
