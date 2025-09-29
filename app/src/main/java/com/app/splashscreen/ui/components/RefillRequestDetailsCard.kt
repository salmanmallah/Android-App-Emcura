package com.app.splashscreen.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.app.splashscreen.R

@Composable
fun RefillRequestDetailsCard(
    title: String = "Lipitor 80 MG Oral TABS",
    patient: String = "Jack Denial",
    date: String = "11/02/2017 to 11/09/2017",
    pharmacy: String = "ITC Pharmacy 2",
    navController: NavController? = null,
    onRefillClick: () -> Unit = { navController?.navigate("servicesbillingcodes") }
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color(0xFFFFEBEB),
        shape = RoundedCornerShape(6.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(4.dp))

                Box(
                    modifier = Modifier
                        .width(60.dp)
                        .height(3.dp)
                        .background(Color(0xFFE94F4F), RoundedCornerShape(2.dp))
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Patient: $patient",
                    fontSize = 12.sp,
                    color = Color.Black
                )
                Text(
                    text = "Date: $date",
                    fontSize = 12.sp,
                    color = Color.Black
                )
                Text(
                    text = "Pharmacy: $pharmacy",
                    fontSize = 12.sp,
                    color = Color.Black
                )
            }

            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = onRefillClick,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE94F4F)),
                shape = RoundedCornerShape(50),
                contentPadding = PaddingValues(horizontal = 18.dp),
                modifier = Modifier
                    .height(30.dp)
                    .width(150.dp)
            ) {
                Text(
                    text = "Refill Requests",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 10.sp
                )
                Spacer(modifier = Modifier.weight(1f))

                Icon(
                    painter = painterResource(id = R.drawable.refile_request_arrow_forward),
                    contentDescription = "Arrow",
                    tint = Color.White,
                    modifier = Modifier.size(13.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RefillRequestDetailsCardPreview() {
    RefillRequestDetailsCard()
}
