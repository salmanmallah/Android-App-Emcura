package com.app.splashscreen.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.app.splashscreen.R

// ✅ Final Popup
@Composable
fun DocToDocPopup(
    onDismiss: () -> Unit,
    onDocToDocClick: () -> Unit,
    onDocToCpClick: () -> Unit
) {
    Dialog(onDismissRequest = onDismiss) {
        Box(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .wrapContentHeight()
                .clip(RoundedCornerShape(20.dp))
                .background(Color.White.copy(alpha = 0.8f)) // 20% transparent white background
        ) {
            // Pattern background
            Image(
                painter = painterResource(id = R.drawable.ic_dashboard_background_pattern),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .matchParentSize()
                    .clip(RoundedCornerShape(20.dp))
            )
            // White scrim overlay for readability (remove or reduce alpha)
            // Box(
            //     modifier = Modifier
            //         .matchParentSize()
            //         .background(Color.White.copy(alpha = 0.85f))
            // )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp, horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Please Select a below option  to view\nDoctor Care Providers",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(14.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(2.dp)
                        .background(colorResource(id = R.color.instant_connect_button))
                )

                Spacer(modifier = Modifier.height(14.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Button(
                        onClick = onDocToDocClick,
                        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.instant_connect_button)),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier.weight(1f).height(44.dp)
                    ) {
                        IconWithText(text = "DOC TO DOC")
                    }
                    Button(
                        onClick = onDocToCpClick,
                        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.instant_connect_button)),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier.weight(1f).height(44.dp)
                    ) {
                        IconWithText(text = "DOC TO CP")
                    }
                }
            }
        }
    }
}

// ✅ Extracted content (for preview & reuse)
@Composable
private fun DocToDocPopupContent(
    onDocToDocClick: () -> Unit,
    onDocToCpClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .width(320.dp)
            .wrapContentHeight()
            .clip(RoundedCornerShape(20.dp))
    ) {
        // Background with overlay
        Box {
            Image(
                painter = painterResource(id = R.drawable.ic_dashboard_background_pattern),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .matchParentSize()
                    .clip(RoundedCornerShape(20.dp))
            )
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .background(Color.White.copy(alpha = 0.85f))
            )
        }

        // Main content
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp, horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Please Select a below option to view\nDoctor Care Providers",
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                color = Color.Black,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(14.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
                    .background(Color(0xFFE94F4F))
            )

            Spacer(modifier = Modifier.height(14.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Button(
                    onClick = onDocToDocClick,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.instant_connect_button)
                    ),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
//                        .weight(1f)
                        .height(44.dp)
                ) {
                    IconWithText(text = "DOC TO DOC")
                }

                Button(
                    onClick = onDocToCpClick,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.instant_connect_button)
                    ),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
//                        .weight(1f)
                        .height(44.dp)
                ) {
                    IconWithText(text = "DOC TO CP")
                }
            }
        }
    }
}

// ✅ Icon + Text inside button
@Composable
private fun IconWithText(text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = R.drawable.ic_dashboard_bell),
            contentDescription = null,
            modifier = Modifier.size(18.dp)
        )
        Spacer(modifier = Modifier.width(2.dp)) // Reduced space between icon and text
        Text(
            text = text,
            color = Color.White,
            fontWeight = FontWeight.SemiBold,
            fontSize = 9.sp
        )
    }
}

// ✅ Preview without Dialog (safe for design check)
@Preview(showBackground = true)
@Composable
fun DocToDocPopupPreview() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        contentAlignment = Alignment.Center
    ) {
        DocToDocPopupContent(
            onDocToDocClick = {},
            onDocToCpClick = {}
        )
    }
}
