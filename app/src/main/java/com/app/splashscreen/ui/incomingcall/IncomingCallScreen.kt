package com.app.splashscreen.ui.incomingcall

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.splashscreen.R
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.ui.draw.clip

@Composable
fun IncomingCallScreen(
    doctorName: String = "Dr. Diallo S Jabari",
    doctorImageRes: Int = R.drawable.ic_dashboard_profile,
    onAccept: () -> Unit = {},
    onReject: () -> Unit = {},
    onSendMessage: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(48.dp))
            Text(
                text = "incoming call",
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(32.dp))
            Box(
                modifier = Modifier.size(120.dp),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(120.dp)
                        .background(Color.Transparent)
                        .border(6.dp, Color(0xFFE94F4F), CircleShape)
                )
                Image(
                    painter = painterResource(id = doctorImageRes),
                    contentDescription = "Doctor Image",
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .background(Color.White, CircleShape)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = doctorName,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(90.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(64.dp)

                        .clickable { onAccept() },
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.call_accept),
                        contentDescription = "Accept Call",
                        modifier = Modifier.size(100.dp)
                    )
                }
                Spacer(modifier = Modifier.width(48.dp))
                Box(
                    modifier = Modifier
                        .size(64.dp)

                        .clickable { onReject() },
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.call_reject),
                        contentDescription = "Reject Call",
                        modifier = Modifier.size(100.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(60.dp))
            Button(
                onClick = onSendMessage,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE94F4F)),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .width(180.dp)
                    .height(38.dp)
            ) {
                Text("Send Message", color = Color.White, fontSize = 14.sp)
            }
        }
        // Bottom gradient overlay
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(320.dp)
                .align(Alignment.BottomCenter)
                .background(
                    brush = androidx.compose.ui.graphics.Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color(0xFFFDE6E6)),
                        startY = 0f,
                        endY = 320f
                    )
                )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun IncomingCallScreenPreview() {
    IncomingCallScreen()
}
