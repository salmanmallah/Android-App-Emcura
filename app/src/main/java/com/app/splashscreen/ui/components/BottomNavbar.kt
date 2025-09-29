package com.app.splashscreen.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.app.splashscreen.R
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Composable
fun BottomNavbar(
    icons: List<Int>,
    onIconClick: (Int) -> Unit,
    centerImageResId: Int
) {
    Box(
        modifier = Modifier
            .height(75.dp)
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
                .align(Alignment.BottomCenter)
                .background(
                    color = colorResource( R.color.instant_connect_button),
                    shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp)
                )
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(horizontal = 24.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Left icons with press animation and action on release
            icons.take(icons.size / 2).forEachIndexed { index, iconRes ->
                var pressed by remember { mutableStateOf(false) }
                val scale by animateFloatAsState(if (pressed) 0.92f else 1f, label = "leftIconScale$index")
                Icon(
                    painter = painterResource(id = iconRes),
                    contentDescription = "Nav Icon $index",
                    tint = Color.White,
                    modifier = Modifier
                        .size(30.dp)
                        .graphicsLayer {
                            scaleX = scale
                            scaleY = scale
                        }
                        .pointerInteropFilter {
                            when (it.action) {
                                android.view.MotionEvent.ACTION_DOWN -> pressed = true
                                android.view.MotionEvent.ACTION_UP -> {
                                    pressed = false
                                    onIconClick(index)
                                }
                                android.view.MotionEvent.ACTION_CANCEL -> pressed = false
                            }
                            true
                        }
                )
            }
            Spacer(modifier = Modifier.width(38.dp))
            icons.drop(icons.size / 2).forEachIndexed { index, iconRes ->
                val actualIndex = index + icons.size / 2
                var pressed by remember { mutableStateOf(false) }
                val scale by animateFloatAsState(if (pressed) 0.92f else 1f, label = "rightIconScale$actualIndex")
                Icon(
                    painter = painterResource(id = iconRes),
                    contentDescription = "Nav Icon $actualIndex",
                    tint = Color.White,
                    modifier = Modifier
                        .size(22.dp)
                        .graphicsLayer {
                            scaleX = scale
                            scaleY = scale
                        }
                        .pointerInteropFilter {
                            when (it.action) {
                                android.view.MotionEvent.ACTION_DOWN -> pressed = true
                                android.view.MotionEvent.ACTION_UP -> {
                                    pressed = false
                                    onIconClick(actualIndex)
                                }
                                android.view.MotionEvent.ACTION_CANCEL -> pressed = false
                            }
                            true
                        }
                )
            }
        }

        var centerPressed by remember { mutableStateOf(false) }
        val centerScale by animateFloatAsState(if (centerPressed) 0.92f else 1f, label = "centerIconScale")
        Image(
            painter = painterResource(id = centerImageResId),
            contentDescription = "Center Image",
            modifier = Modifier
                .size(100.dp)
                .align(Alignment.BottomCenter)
                .offset(y = (-15).dp)
                .graphicsLayer {
                    scaleX = centerScale
                    scaleY = centerScale
                }
                .pointerInteropFilter {
                    when (it.action) {
                        android.view.MotionEvent.ACTION_DOWN -> centerPressed = true
                        android.view.MotionEvent.ACTION_UP -> {
                            centerPressed = false
                            onIconClick(4)
                        }
                        android.view.MotionEvent.ACTION_CANCEL -> centerPressed = false
                    }
                    true
                }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavbarPreview() {
    BottomNavbar(
        onIconClick = {},
        icons = listOf(
            R.drawable.ic_dashboard_power,
            R.drawable.ic_dashboard_waitingroom,
            R.drawable.ic_dashboard_support,
            R.drawable.ic_dashboard_masseges,
        ),
        centerImageResId = R.drawable.ic_dashboard_bell_patientcare
    )
}
