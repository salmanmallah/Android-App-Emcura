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

@Composable
fun StartScreen(onStartClick: () -> Unit) {
    val images = listOf(
        R.drawable.start_screen,
        R.drawable.splash_logo,
        R.drawable.red_logo
        // Add more drawable resources as needed
    )
    var currentImage by remember { mutableStateOf(0) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFDF6F6))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 60.dp, bottom = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Carousel Image
            Box(
                modifier = Modifier
                    .height(180.dp)
                    .fillMaxWidth()
                    .pointerInput(currentImage) {
                        detectHorizontalDragGestures { change, dragAmount ->
                            if (dragAmount > 0) {
                                // Swipe right
                                currentImage = (currentImage - 1 + images.size) % images.size
                            } else if (dragAmount < 0) {
                                // Swipe left
                                currentImage = (currentImage + 1) % images.size
                            }
                        }
                    }
            ) {
                Image(
                    painter = painterResource(id = images[currentImage]),
                    contentDescription = "Carousel Image",
                    modifier = Modifier.fillMaxSize()
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            // Carousel Indicators

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


            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                images.forEachIndexed { index, _ ->
                    Box(
                        modifier = Modifier
                            .size(width = if (index == currentImage) 40.dp else 16.dp, height = 8.dp)
                            .background(
                                if (index == currentImage) Color(0xFFE94F4F) else Color(0xFFE0E0E0),
                                RoundedCornerShape(4.dp)
                            )
                            .clickable { currentImage = index }
                    )
                    if (index < images.size - 1) {
                        Spacer(modifier = Modifier.width(8.dp))
                    }
                }
            }




            Spacer(modifier = Modifier.height(40.dp))
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



@Preview(showBackground = true)
@Composable
fun StartScreenPreview() {
    StartScreen(onStartClick = {})
}