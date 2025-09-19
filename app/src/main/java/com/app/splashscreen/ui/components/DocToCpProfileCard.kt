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

@Composable
fun DocToCpProfileCard(
    name: String,
    title: String,
    online: Boolean,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(Color(0xFFFEEBEE), RoundedCornerShape(12.dp))
            .padding(horizontal = 8.dp, vertical = 8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
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
            Spacer(modifier = Modifier.width(12.dp))
            // Name, Status, Button
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = name,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
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
                    text = title,
                    color = Color(0xFF757575),
                    fontSize = 13.sp
                )
                Button(
                    onClick = { /* TODO: Message */ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFED202E),
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .padding(top = 4.dp)
                        .height(28.dp)
                        .width(90.dp)
                ) {
                    Text("Message", fontSize = 13.sp)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DocToCpProfileCardPreview() {

        DocToCpProfileCard(
            name = "Elizabeth Weisberg",
            title = "MA",
            online = true
        )

}
