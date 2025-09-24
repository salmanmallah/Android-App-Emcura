package com.app.splashscreen.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
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

// ✅ Extracted content (for preview & reuse)
@Composable
private fun InstantConnectPopupContent(
    onExistingPatient: () -> Unit,
    onNewPatient: () -> Unit,
    onCancel: () -> Unit,
    onDismiss: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .wrapContentHeight()
            .clip(RoundedCornerShape(20.dp))
            .background(Color.White.copy(alpha = 0.8f))
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
        // Title and close button
        Box(modifier = Modifier.fillMaxWidth().padding(top = 18.dp, end = 18.dp)) {
            Text(
                text = "Instant Connect",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.Black,
                modifier = Modifier.align(Alignment.TopCenter)
            )
            Box(
                modifier = Modifier
                    .size(32.dp)
                    .align(Alignment.TopEnd)
                    .clickable { onDismiss() },
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(28.dp)
                        .clip(CircleShape)
                        .background(colorResource(id = R.color.instant_connect_button)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "X",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
        // Main content
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 60.dp, bottom = 24.dp, start = 16.dp, end = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = onExistingPatient,
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.instant_connect_button)),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(44.dp)
            ) {
                Text(
                    text = "Existing Patient",
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 15.sp
                )
            }
            Spacer(modifier = Modifier.height(14.dp))
            Button(
                onClick = onNewPatient,
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.instant_connect_button)),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(44.dp)
            ) {
                Text(
                    text = "New Patient",
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 15.sp
                )
            }
            Spacer(modifier = Modifier.height(18.dp))
            Button(
                onClick = onCancel,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF333333)),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(44.dp)
            ) {
                Text(
                    text = "Cancel",
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 15.sp
                )
            }
        }
    }
}

// ✅ Dialog wrapper for runtime
@Composable
fun InstantConnectPopup(
    navController: NavController?,
    onDismiss: () -> Unit,
    onNewPatient: () -> Unit,
    onCancel: () -> Unit
) {
    Dialog(onDismissRequest = onDismiss) {
        InstantConnectPopupContent(
            onExistingPatient = {
                navController?.navigate("onlineCarePatients")
                onDismiss()
            },
            onNewPatient = {
                navController?.navigate("instantconnect")
                onDismiss()
            },
            onCancel = onCancel,
            onDismiss = onDismiss
        )
    }
}

// ✅ Preview without Dialog (safe for design check)
@Preview(showBackground = true)
@Composable
fun InstantConnectPopupPreview() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        contentAlignment = Alignment.Center
    ) {
        InstantConnectPopup(
            navController = null,
            onDismiss = {},
            onNewPatient = {},
            onCancel = {}
        )
    }
}
