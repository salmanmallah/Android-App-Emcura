package com.app.splashscreen.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.splashscreen.R
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun WaitingRoomProfileCard(
    name: String,
    online: Boolean,
    modifier: Modifier = Modifier
) {
    val currentDate = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(color = androidx.compose.ui.res.colorResource(id = R.color.doc_to_cp_card), shape = RoundedCornerShape(12.dp))
            .padding(horizontal = 8.dp, vertical = 8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            // Profile Circle
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .background(Color.White)
                    .border(3.dp, Color(0xFFED202E), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_dashboard_profile),
                    contentDescription = "Profile",
                    modifier = Modifier.size(54.dp)
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            // Name, Status, Button
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 4.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(bottom = 2.dp)
                ) {
                    Text(
                        text = name,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 17.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Box(
                        modifier = Modifier
                            .size(12.dp)
                            .clip(CircleShape)
                            .background(if (online) Color(0xFF1ED300) else Color(0xFF757575))
                    )
                }
                Text(
                    text = currentDate,
                    color = Color(0xFF757575),
                    fontSize = 15.sp,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Button(
                    onClick = { /* TODO: Accept Request */ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFED202E),
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(15.dp),
                    contentPadding = PaddingValues(0.dp),
                    modifier = Modifier
                        .height(22.dp)
                        .width(120.dp)
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Accept Request", fontSize = 12.sp, modifier = Modifier.align(Alignment.Center))
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WaitingRoomProfileCardPreview() {
    WaitingRoomProfileCard(
        name = "Elizabeth weisberg",
        online = true
    )
}
