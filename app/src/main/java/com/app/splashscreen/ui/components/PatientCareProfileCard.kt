package com.app.splashscreen.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
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
fun PatientCareProfileCard(
    name: String,
    online: Boolean,
    number: String,
    onArrowClick: () -> Unit = {}
) {
//    Box(
        Box(
            modifier = Modifier
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
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                        .border(2.dp, Color(0xFFED202E), CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_dashboard_profile),
                        contentDescription = "Profile",
                        modifier = Modifier.size(34.dp)
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                // Name
                Text(
                    text = name,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f)
                )
                // Number centered
                Box(
                    modifier = Modifier.weight(0.5f),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = number,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp
                    )
                }
                // Forward Arrow fully right
                IconButton(
                    onClick = onArrowClick,
                    modifier = Modifier
                        .size(36.dp)
                        .align(Alignment.CenterVertically)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_dashboard_arrow_forward),
                        contentDescription = "Forward",
                        modifier = Modifier.size(22.dp)
                    )
                }
            }
        }
}

@Preview(showBackground = true)
@Composable
fun PatientCareProfileCardPreview() {
    PatientCareProfileCard(
        name = "Elizabeth weisberg",
        online = true,
        number = "1"
    )
}
