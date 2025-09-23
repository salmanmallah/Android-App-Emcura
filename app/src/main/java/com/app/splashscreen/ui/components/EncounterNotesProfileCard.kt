package com.app.splashscreen.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.splashscreen.R
import androidx.compose.ui.res.colorResource

@Composable
fun EncounterNotesProfileCard(
    name: String = "Susan Edward",
    dob: String = "01/01/1970",
    gender: String = "F",
    mobile: String = "5555655555",
    home: String = "5555535355",
    email: String = "email2jamal3@yahoo.com",
    address: String = "3636 Hawthrone Dr MI MI 48502",
    imageRes: Int = R.drawable.ic_dashboard_profile,
    micRes: Int = R.drawable.ic_dashboard_mic
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
            // Profile Image
            Box(
                modifier = Modifier
                    .size(54.dp)
                    .border(2.dp, Color(0xFFE94F4F), CircleShape)
                    .clip(CircleShape)
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = "Profile Picture",
                    modifier = Modifier.size(48.dp).clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = Color(0xFF222222),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "DOB: $dob",
                        fontSize = 12.sp,
                        color = Color(0xFF222222)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    // Gender red dot
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .clip(CircleShape)
                            .background(Color(0xFFE94F4F))
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Gender: $gender",
                        fontSize = 12.sp,
                        color = Color(0xFF222222)
                    )
                }
                Text(
                    text = "Mobil: $mobile | Home: $home",
                    fontSize = 12.sp,
                    color = Color(0xFF222222)
                )
                Text(
                    text = "Email: $email",
                    fontSize = 12.sp,
                    color = Color(0xFF222222)
                )
                Text(
                    text = "Address: $address",
                    fontSize = 12.sp,
                    color = Color(0xFF222222)
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            // Mic Icon
            Box(
                modifier = Modifier
                    .size(38.dp)
                    .clip(CircleShape)
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = micRes),
                    contentDescription = "Mic",
                    modifier = Modifier.size(28.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EncounterNotesProfileCardPreview() {
    EncounterNotesProfileCard()
}
