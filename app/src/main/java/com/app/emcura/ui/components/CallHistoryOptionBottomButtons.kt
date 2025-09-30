package com.app.emcura.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.app.emcura.R

@Composable
fun CallHistoryOptionBottomButtons(
    modifier: Modifier = Modifier,

    recallIcon: Int = R.drawable.ic_recall,
    notesIcon: Int = R.drawable.ic_encounter_notes,
    labIcon: Int = R.drawable.ic_lab_requests,
    messageIcon: Int = R.drawable.ic_message,
    prescriptionIcon: Int = R.drawable.ic_prescription,
    dischargeIcon: Int = R.drawable.ic_discharge_summary
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(Color(0xFFDE3C4B))
            .padding(horizontal = 12.dp, vertical = 16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CallHistoryOptionButton(iconRes = recallIcon, text = "Recall")
                CallHistoryOptionButton(iconRes = notesIcon, text = "Add Encounter Notes")
                CallHistoryOptionButton(iconRes = labIcon, text = "Send Lab Requests")
            }
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CallHistoryOptionButton(iconRes = messageIcon, text = "Message")
                CallHistoryOptionButton(iconRes = prescriptionIcon, text = "Send Prescription")
                CallHistoryOptionButton(iconRes = dischargeIcon, text = "View Discharge Summary")
            }
        }
    }
}

@Composable
fun CallHistoryOptionButton(iconRes: Int, text: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(38.dp)
            .background(Color.White, RoundedCornerShape(12.dp))
            .padding(horizontal = 8.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = text,
                modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = text,
                color = Color(0xFF222222),
                fontWeight = FontWeight.Medium,
                fontSize = 10.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CallHistoryOptionBottomButtonsPreview() {
    CallHistoryOptionBottomButtons(
        recallIcon = R.drawable.ic_recall,
        notesIcon = R.drawable.ic_encounter_notes,
        labIcon = R.drawable.ic_lab_requests,
        messageIcon = R.drawable.ic_message,
        prescriptionIcon = R.drawable.ic_prescription,
        dischargeIcon = R.drawable.ic_discharge_summary
    )
}

