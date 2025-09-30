
package com.app.emcura.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.emcura.R
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SendMessagePopup(
    name: String,
    online: Boolean,
    onDismiss: () -> Unit,
    onSend: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var message by remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0x80000000)) 
            .wrapContentSize(Alignment.Center)
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth(0.9f)
                .fillMaxHeight(0.4f)
                .clip(RoundedCornerShape(20.dp))
                .background(Color.White)
                .padding(18.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Box(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Send Message",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        modifier = Modifier.align(Alignment.Center)
                    )
                    IconButton(
                        onClick = onDismiss,
                        modifier = Modifier
                            .size(28.dp)
                            .align(Alignment.CenterEnd)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.call_history_rejected),
                            contentDescription = "Close",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(44.dp)
                            .clip(CircleShape)
                            .background(Color.White)
                            .border(2.dp, Color(0xFFED202E), CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_dashboard_profile),
                            contentDescription = "Profile",
                            modifier = Modifier.size(38.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Column {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = name,
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Box(
                                modifier = Modifier
                                    .size(10.dp)
                                    .clip(CircleShape)
                                    .background(if (online) Color(0xFF1ED300) else Color(0xFF757575))
                            )
                        }
                        Text(
                            text = "Doctor",
                            color = Color.Black,
                            fontSize = 13.sp
                        )
                    }
                }
                Spacer(modifier = Modifier.height(12.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .background(Color(0xFFF6F6F6), RoundedCornerShape(12.dp))
                        .border(1.5.dp, Color(0xFFBDBDBD), RoundedCornerShape(12.dp))
                        .padding(0.dp)
                ) {
                    TextField(
                        value = message,
                        onValueChange = { message = it },
                        placeholder = { Text("Type your message...", fontSize = 15.sp, color = Color(0xFFBDBDBD)) },
                        colors = TextFieldDefaults.colors(
                            unfocusedContainerColor = Color(0xFFF6F6F6),
                            focusedContainerColor = Color(0xFFF6F6F6),
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp),
                        textStyle = LocalTextStyle.current.copy(fontSize = 15.sp, color = Color.Black),
                        maxLines = 8,
                        minLines = 4,
                        singleLine = false
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(
                        onClick = onDismiss,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFEB474B),
                            contentColor = Color.White
                        ),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Cancel", fontSize = 10.sp)
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Button(
                        onClick = { onSend(message) },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFEB474B),
                            contentColor = Color.White
                        ),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Send Message", fontSize = 10.sp)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun SendMessagePopupPreview() {
    SendMessagePopup(
        name = "Elizabeth weisberg",
        online = true,
        onDismiss = {},
        onSend = {}
    )
}