package com.app.emcura.ui.start

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.emcura.R
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.with
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.style.TextAlign

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun StartScreen(onStartClick: () -> Unit) {
    val steps = 3
    var currentStep by remember { mutableStateOf(0) }
    var direction by remember { mutableStateOf(1) }

    val imageRes = R.drawable.ic_dashboard_card
    val titles = listOf(
        "Here to Heal\nHere to Help",
        "Book Appointments\nwith Top Doctors",
        "Your Health,\nOur Priority"
    )
    val subtitles = listOf(
        "Clinical Care",
        "Instant Scheduling",
        "Seamless Experience"
    )
    val configuration = androidx.compose.ui.platform.LocalConfiguration.current
    val screenHeightPx =
        with(androidx.compose.ui.platform.LocalDensity.current) { configuration.screenHeightDp.dp.toPx() }
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
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AnimatedContent(
                targetState = currentStep,
                transitionSpec = {
                    if (direction > 0) {
                        slideInHorizontally(
                            initialOffsetX = { it }, animationSpec = tween(350)
                        ) with slideOutHorizontally(
                            targetOffsetX = { -it }, animationSpec = tween(350)
                        )
                    } else {
                        slideInHorizontally(
                            initialOffsetX = { -it }, animationSpec = tween(350)
                        ) with slideOutHorizontally(
                            targetOffsetX = { it }, animationSpec = tween(350)
                        )
                    }
                }, label = "OnboardingAnimation"
            ) { step ->
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Spacer(modifier = Modifier.height(80.dp))
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = imageRes),
                            contentDescription = "Onboarding Image",
                            modifier = Modifier.fillMaxWidth(0.85f) // 85% width
                        )
                    }
                    Spacer(modifier = Modifier.height(32.dp))
                    Text(
                        text = titles[step],
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF222222),
                        lineHeight = 38.sp,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = subtitles[step],
                        fontSize = 18.sp,
                        color = Color(0xFF888888),
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                }
            }

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                repeat(steps) { index ->
                    Box(
                        modifier = Modifier
                            .size(
                                width = if (index == currentStep) 40.dp else 16.dp,
                                height = 8.dp
                            )
                            .background(
                                if (index == currentStep) Color(0xFFE94F4F) else Color(0xFFE0E0E0),
                                RoundedCornerShape(4.dp)
                            )
                            .clickable {
                                direction = if (index > currentStep) 1 else -1
                                currentStep = index
                            }
                    )
                    if (index < steps - 1) {
                        Spacer(modifier = Modifier.width(8.dp))
                    }
                }
            }

            Spacer(modifier = Modifier.height(80.dp))

            if (currentStep < steps - 1) {
                Button(
                    onClick = {
                        direction = 1
                        currentStep++
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE94F4F)),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .fillMaxWidth(0.7f)
                        .height(56.dp)
                ) {
                    Text(text = "Next", color = Color.White, fontSize = 20.sp)
                }
            } else {
                Button(
                    onClick = onStartClick,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE94F4F)),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .fillMaxWidth(0.7f)
                        .height(56.dp)
                ) {
                    Text(text = "Start", color = Color.White, fontSize = 20.sp)
                }
            }
        }


    }
}

@Preview(showBackground = true)
@Composable
fun StartScreenPreview() {
    StartScreen(onStartClick = {})
}
