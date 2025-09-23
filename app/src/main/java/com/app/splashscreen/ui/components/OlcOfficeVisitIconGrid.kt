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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.navigation.NavController
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


@Composable
fun OlcOfficeVisitIconGrid(navController: NavController? = null) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // RealTime Notes
        var pressed1 by remember { mutableStateOf(false) }
        val scale1 by androidx.compose.animation.core.animateFloatAsState(if (pressed1) 0.92f else 1f, label = "olcOfficeIconScale1")
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .graphicsLayer {
                    scaleX = scale1
                    scaleY = scale1
                }
                .pointerInteropFilter {
                    when (it.action) {
                        android.view.MotionEvent.ACTION_DOWN -> pressed1 = true
                        android.view.MotionEvent.ACTION_UP -> {
                            pressed1 = false
                            navController?.navigate("olcOffice")
                        }
                        android.view.MotionEvent.ACTION_CANCEL -> pressed1 = false
                    }
                    true
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
        var pressed2 by remember { mutableStateOf(false) }
        val scale2 by androidx.compose.animation.core.animateFloatAsState(if (pressed2) 0.92f else 1f, label = "olcOfficeIconScale2")
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .graphicsLayer {
                    scaleX = scale2
                    scaleY = scale2
                }
                .pointerInteropFilter {
                    when (it.action) {
                        android.view.MotionEvent.ACTION_DOWN -> pressed2 = true
                        android.view.MotionEvent.ACTION_UP -> {
                            pressed2 = false
                            navController?.navigate("selectsymptoms")
                        }
                        android.view.MotionEvent.ACTION_CANCEL -> pressed2 = false
                    }
                    true
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
        var pressed3 by remember { mutableStateOf(false) }
        val scale3 by androidx.compose.animation.core.animateFloatAsState(if (pressed3) 0.92f else 1f, label = "olcOfficeIconScale3")
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .graphicsLayer {
                    scaleX = scale3
                    scaleY = scale3
                }
                .pointerInteropFilter {
                    when (it.action) {
                        android.view.MotionEvent.ACTION_DOWN -> pressed3 = true
                        android.view.MotionEvent.ACTION_UP -> {
                            pressed3 = false
                            navController?.navigate("encounternotes")
                        }
                        android.view.MotionEvent.ACTION_CANCEL -> pressed3 = false
                    }
                    true
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
