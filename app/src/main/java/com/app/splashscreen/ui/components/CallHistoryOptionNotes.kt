package com.app.splashscreen.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CallHistoryOptionNotes(
    notesBy: String = "Mark Victor on 08/19/2024",
    doctorName: String = "Dr. Supak Sookkasikon",
    startTime: String = "01:53:19 PM",
    endTime: String = "01:53:19 PM",
    duration: String = "00:00:27",
    encounterNotes: String = ""
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(18.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "NOTES BY:",
                color = Color(0xFFED202E),
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp
            )
            Text(
                text = notesBy,
                color = Color.Black,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp
            )
            Text(
                text = doctorName,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
            Box(
                modifier = Modifier
                    .height(2.dp)
                    .width(120.dp)
                    .background(Color(0xFFED202E), RoundedCornerShape(2.dp))
            )
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(horizontalAlignment = Alignment.Start) {
                    Text(
                        text = "Start Time",
                        color = Color(0xFFED202E),
                        fontWeight = FontWeight.Bold,
                        fontSize = 10.sp
                    )
                    Text(
                        text = startTime,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 9.sp
                    )
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "End Time",
                        color = Color(0xFFED202E),
                        fontWeight = FontWeight.Bold,
                        fontSize = 10.sp
                    )
                    Text(
                        text = endTime,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 9.sp
                    )
                }
                Column(horizontalAlignment = Alignment.End) {
                    Text(
                        text = "Duration",
                        color = Color(0xFFED202E),
                        fontWeight = FontWeight.Bold,
                        fontSize = 10.sp
                    )
                    Text(
                        text = duration,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 9.sp
                    )
                }
            }
            Spacer(modifier = Modifier.height(18.dp))
            Text(
                text = "Encounter Notes",
                color = Color(0xFFED202E),
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
                androidx.compose.material3.OutlinedTextField(
                    value = encounterNotes,
                    onValueChange = {}, // TODO: Pass a state and update logic here
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp),
                    textStyle = androidx.compose.ui.text.TextStyle(fontSize = 10.sp),
                    shape = RoundedCornerShape(24.dp),
                    singleLine = false,
                    maxLines = 6,
                    placeholder = {
                        Text("Enter notes...", fontSize = 10.sp)
                    }
                )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CallHistoryOptionNotesPreview() {
    CallHistoryOptionNotes()
}
