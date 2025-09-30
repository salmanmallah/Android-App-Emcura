package com.app.emcura.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.emcura.R

@Composable
fun DoctorCard(
    name: String,
    title: String,
    online: Boolean,
    modifier: Modifier = Modifier,
    onArrowClick: (() -> Unit)? = null
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
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = name,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    text = title,
                    color = Color(0xFF757575),
                    fontSize = 13.sp
                )
                Box(
                    modifier = Modifier
                        .padding(top = 2.dp)
                        .background(
                            if (online) Color(0xFF1ED300) else Color(0xFF757575),
                            RoundedCornerShape(8.dp)
                        )
                        .padding(horizontal = 8.dp, vertical = 2.dp)
                ) {
                    Text(
                        text = if (online) "Online" else "Offline",
                        color = Color.White,
                        fontSize = 10.sp
                    )
                }
            }
            IconButton(onClick = { onArrowClick?.invoke() }) {
                Image(
                    painter = painterResource(id = R.drawable.ic_dashboard_arrow_forward),
                    contentDescription = "Go",
                    modifier = Modifier.size(25.dp)
                )
            }
            Spacer(modifier = Modifier.height(200.dp))
        }
    }
}

@Composable
fun DoctorCardList(
    doctors: List<Triple<String, String, Boolean>>,
    modifier: Modifier = Modifier,
    onArrowClick: ((Int) -> Unit)? = null
) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        doctors.forEachIndexed { i, (name, title, online) ->
            DoctorCard(
                name = name,
                title = title,
                online = online,
                onArrowClick = { onArrowClick?.invoke(i) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DoctorCardPreview() {
    DoctorCard(
        name = "Dr. Supak Sookkaskon",
        title = "Doctor",
        online = true
    )
}
