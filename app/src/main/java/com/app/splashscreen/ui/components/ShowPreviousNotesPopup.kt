package com.app.splashscreen.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.splashscreen.R
import androidx.compose.foundation.Image

@Composable
fun ShowPreviousNotesPopup(onDismiss: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0x80000000)),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(0.93f)
                .fillMaxHeight(0.85f)
                .clip(RoundedCornerShape(40.dp))
                .background(Color.White)
                .verticalScroll(rememberScrollState())
        ) {
            Box(modifier = Modifier.fillMaxWidth()) {
                IconButton(
                    onClick = onDismiss,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(12.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.call_history_rejected),
                        contentDescription = "Close",
                        modifier = Modifier
                            .size(24.dp)
                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(15.dp))
                CallHistoryOptionNotes()
                Spacer(modifier = Modifier.height(15.dp))
                CallHistoryOptionNotes()
                Spacer(modifier = Modifier.height(200.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowPreviousNotesPopupPreview() {
    ShowPreviousNotesPopup(onDismiss = {})
}
