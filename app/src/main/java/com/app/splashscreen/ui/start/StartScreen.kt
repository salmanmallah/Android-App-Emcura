package com.app.splashscreen.ui.start

//import StartScreen
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.splashscreen.R
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.with
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.LaunchedEffect

@Composable
fun StartScreen(onStartClick: () -> Unit) {
    val steps = 3
    var currentStep by remember { mutableStateOf(0) }
    val imageRes = R.drawable.ic_dashboard_card


    @OptIn(ExperimentalAnimationApi::class)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFDF6F6))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 60.dp, bottom = 40.dp)
                .pointerInput(currentStep) {
                    detectHorizontalDragGestures { change, dragAmount ->
                        if (dragAmount > 0) {
                            // Swipe right
                            if (currentStep > 0) currentStep--
                        } else if (dragAmount < 0) {
                            // Swipe left
                            if (currentStep < steps - 1) currentStep++
                        }
                    }
                },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var prevStep by remember { mutableStateOf(currentStep) }
            val direction = if (currentStep > prevStep) 1 else -1
            LaunchedEffect(currentStep) { prevStep = currentStep }
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
                }
            ) { step ->
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Box(
                        modifier = Modifier
                            .height(180.dp)
                            .fillMaxWidth()
                    ) {
                        Image(
                            painter = painterResource(id = imageRes),
                            contentDescription = "Onboarding Image",
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Spacer(modifier = Modifier.height(32.dp))
                    Text(
                        text = "Here to Heal\nHere to Help",
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF222222)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Clinical Care",
                        fontSize = 18.sp,
                        color = Color(0xFF888888)
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                }
            }

            // Dots
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                repeat(steps) { index ->
                    Box(
                        modifier = Modifier
                            .size(width = if (index == currentStep) 40.dp else 16.dp, height = 8.dp)
                            .background(
                                if (index == currentStep) Color(0xFFE94F4F) else Color(0xFFE0E0E0),
                                RoundedCornerShape(4.dp)
                            )
                            .clickable { currentStep = index }
                    )
                    if (index < steps - 1) {
                        Spacer(modifier = Modifier.width(8.dp))
                    }
                }
            }

            Spacer(modifier = Modifier.height(40.dp))
            if (currentStep < steps - 1) {
                Button(
                    onClick = { currentStep++ },
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