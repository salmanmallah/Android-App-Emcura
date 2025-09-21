
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

fun PrescriptionProfileCard(
    doctorName: String = "Dr. Supak Sookkasikon",
    sentDate: String = "08/28/2023",
    prescription: String = "Lipitor 80 MG TABS",
    quantity: String = "2",
    direction: String = "0",
    imageRes: Int = R.drawable.ic_dashboard_profile, // Replace with actual doctor image
    signatureRes: Int = R.drawable.prescription_signature // Add this drawable to your resources
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        color = colorResource(id = R.color.cards_background_color),
        shape = RoundedCornerShape(0.dp),
        shadowElevation = 0.2.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 5.dp, vertical = 10.dp),
//            verticalAlignment = Alignment.CenterVertically
        ) {
            // Profile Image with red border
            Box(
                modifier = Modifier
                    .size(78.dp)
                    .border(4.dp, Color(0xFFE94F4F), CircleShape)
                    .clip(CircleShape)
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .size(70.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.width(18.dp))

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(vertical = 2.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = doctorName,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = Color(0xFF222222),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "Sent on $sentDate",
                    fontSize = 11.sp,
                    color = Color(0xFF666666),
                    modifier = Modifier.padding(top = 1.dp, bottom = 6.dp)
                )
                Text(
                    text = "Prescription : $prescription",
                    fontSize = 12.5.sp,
                    color = Color(0xFF222222),
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = "Quantity : $quantity",
                    fontSize = 12.5.sp,
                    color = Color(0xFF222222),
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = "Direction : $direction",
                    fontSize = 12.5.sp,
                    color = Color(0xFF222222),
                    fontWeight = FontWeight.Medium
                )

                Spacer(modifier = Modifier.height(6.dp))

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = "Prescribed by",
                        color = Color(0xFFE82A30),
                        fontWeight = FontWeight.Medium,
                        fontSize = 15.sp
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Image(
                        painter = painterResource(id = signatureRes),
                        contentDescription = "Signature",
                        modifier = Modifier
//                            .height(20.dp)
//                            .width(60.dp),
                            .size(width = 80.dp, height = 30.dp),
                        contentScale = ContentScale.Fit
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PrescriptionProfileCardPreview() {
    PrescriptionProfileCard()
}
