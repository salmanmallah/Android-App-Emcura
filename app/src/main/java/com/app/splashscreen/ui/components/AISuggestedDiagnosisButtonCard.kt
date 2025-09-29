package com.app.splashscreen.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AISuggestedDiagnosisButtonCard(
    onGenerateDiagnosis: () -> Unit = {},
    onGenerateCarePlan: () -> Unit = {},
    onPrescriptions: () -> Unit = {}
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = onGenerateDiagnosis,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEB474B)),
            shape = RoundedCornerShape(24.dp),
            modifier = Modifier
                .weight(1f)
                .height(36.dp)
        ) {
            Text(
                "Generate Diagnosis",
                color = Color.White,
                fontSize = 7.sp,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(),
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )
        }

        Button(
            onClick = onGenerateCarePlan,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEB474B)),
            shape = RoundedCornerShape(24.dp),
            modifier = Modifier
                .weight(1f)
                .height(36.dp)
        ) {
            Text(
                "Generate Care Plan",
                color = Color.White,
                fontSize = 7.sp,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(),
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )
        }

        Button(
            onClick = onPrescriptions,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEB474B)),
            shape = RoundedCornerShape(24.dp),
            modifier = Modifier
                .weight(1f)
                .height(36.dp)
        ) {
            Text(
                "Prescriptions",
                color = Color.White,
                fontSize = 7.sp,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(),
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AISuggestedDiagnosisButtonCardPreview() {
    AISuggestedDiagnosisButtonCard()
}
