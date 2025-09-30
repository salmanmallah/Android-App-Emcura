package com.app.emcura.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AISuggestedDiagnosisTextCard(
    patientName: String = "Korean Delbosquee",
    patientSymptoms: String = "Common cold - ETC - adskjsaad"
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(12.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Patient Name:",
                color = MaterialTheme.colorScheme.onPrimary,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Text(
                text = patientName,
                color = MaterialTheme.colorScheme.onPrimary,
                fontWeight = FontWeight.Normal,
                fontSize = 15.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Patient Symptoms:",
                color = MaterialTheme.colorScheme.onPrimary,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Text(
                text = patientSymptoms,
                color = MaterialTheme.colorScheme.onPrimary,
                fontWeight = FontWeight.Normal,
                fontSize = 15.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AISuggestedDiagnosisTextCardPreview() {
    AISuggestedDiagnosisTextCard()
}
