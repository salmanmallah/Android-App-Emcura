package com.app.emcura.ui.messages

import androidx.compose.foundation.Image
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
import com.app.emcura.R

@Composable
fun ProfileHeader(
    name: String,
    status: String,
    imageRes: Int
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        color = Color(0xFFFDE6E6),
        shape = RoundedCornerShape(12.dp),
        shadowElevation = 0.2.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(54.dp)
                    .background(Color.White, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .size(48.dp)
                        .background(Color.White, CircleShape)
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(
                    text = name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = Color(0xFF222222)
                )
                Text(
                    text = status,
                    fontSize = 13.sp,
                    color = Color(0xFF4CAF50)
                )
            }
        }
    }
}

@Composable
fun ChatBubble(
    message: String,
    time: String,
    isSent: Boolean
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = if (isSent) Arrangement.End else Arrangement.Start
    ) {
        Surface(
            shape = RoundedCornerShape(24.dp),
            color = Color(0xFFFDE6E6),
            shadowElevation = 1.dp,
            modifier = Modifier
                .widthIn(max = 280.dp)
                .padding(vertical = 6.dp, horizontal = 8.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = message,
                    color = Color(0xFF222222),
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = time,
                    color = Color(0xFFBDBDBD),
                    fontSize = 11.sp,
                    modifier = Modifier.align(Alignment.End)
                )
            }
        }
    }
}

@Composable
fun ImageBubble(
    imageRes: Int
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Surface(
            shape = RoundedCornerShape(24.dp),
            color = Color.White,
            shadowElevation = 2.dp,
            modifier = Modifier
                .width(260.dp)
                .height(180.dp)
                .padding(vertical = 12.dp)
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = "Chat Image",
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Composable
fun InputBar(
    value: String,
    onValueChange: (String) -> Unit,
    onSendClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFFDE6E6))
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = { 
            }
        ) {
            Image(
                painter = painterResource(id = R.drawable.clip),
                contentDescription = "Attach file",
                modifier = Modifier.size(24.dp)
            )
        }
        
        Spacer(modifier = Modifier.width(8.dp))
        
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = Color.White,
            shadowElevation = 1.dp,
            modifier = Modifier.weight(1f)
        ) {
            TextField(
                value = value,
                onValueChange = onValueChange,
                placeholder = { Text("Type your message...") },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    disabledContainerColor = Color.White,
                    errorContainerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    errorIndicatorColor = Color.Transparent
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }
        
        Spacer(modifier = Modifier.width(8.dp))
        
        IconButton(onClick = onSendClick) {
            Image(
                painter = painterResource(id = R.drawable.message_send_icon),
                contentDescription = "Send message",
                modifier = Modifier
                    .size(48.dp)
                    .background(Color.White, CircleShape)
            )
        }
    }
}
