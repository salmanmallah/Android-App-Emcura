package com.app.emcura.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import com.app.emcura.R
import androidx.compose.ui.res.colorResource

@Composable
fun CancelPrescriptionCard(
    doctorName: String = "Gary Neville",
    sentDate: String = "08/28/2023",
    prescription: String = "Lipitor 80 MG TABS",
    quantity: String = "1",
    direction: String = "GM is not",
    status: String = "Active",
    imageRes: Int = R.drawable.ic_dashboard_profile,
    signatureRes: Int = R.drawable.prescription_signature,
    onCancelClick: () -> Unit = {}
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        color = colorResource(id = R.color.cards_background_color),
        shape = RoundedCornerShape(22.dp),
        shadowElevation = 0.2.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp, vertical = 10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top
            ) {
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
                        .align(Alignment.CenterVertically),
                    verticalArrangement = Arrangement.Top
                ) {
                    Text(
                        text = doctorName,
                        fontWeight = FontWeight.Bold,
                        fontSize = 17.sp,
                        color = Color(0xFF222222),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = "Sent on $sentDate",
                        fontSize = 12.sp,
                        color = Color(0xFF666666),
                        modifier = Modifier.padding(top = 2.dp)
                    )

                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = "Prescription : $prescription",
                            fontSize = 14.sp,
                            color = Color(0xFF222222),
                            fontWeight = FontWeight.Medium
                        )
                        Text(
                            text = "Quantity : $quantity",
                            fontSize = 14.sp,
                            color = Color(0xFF222222),
                            fontWeight = FontWeight.Medium
                        )
                        Text(
                            text = "Direction : $direction",
                            fontSize = 14.sp,
                            color = Color(0xFF222222),
                            fontWeight = FontWeight.Medium
                        )
                        Text(
                            text = "Status : $status",
                            fontSize = 14.sp,
                            color = Color(0xFF222222),
                            fontWeight = FontWeight.Medium
                        )
                        Button(
                            onClick = onCancelClick,
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE94F4F)),
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier
                                .height(38.dp)
                                .widthIn(min = 180.dp)
                        ) {
                            Text(
                                text = "Cancel Prescription",
                                color = Color.White,
                                fontWeight = FontWeight.Medium,
                                fontSize = 15.sp
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {

            }
            Spacer(modifier = Modifier.height(12.dp))

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = "Prescribed by",
                    color = Color(0xFFE94F4F),
                    fontWeight = FontWeight.Medium,
                    fontSize = 13.sp
                )
                Spacer(modifier = Modifier.width(6.dp))
                Image(
                    painter = painterResource(id = signatureRes),
                    contentDescription = "Signature",
                    modifier = Modifier
                        .size(width = 70.dp, height = 26.dp),
                    contentScale = ContentScale.Fit
                )

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CancelPrescriptionCardPreview() {
    CancelPrescriptionCard()
}
