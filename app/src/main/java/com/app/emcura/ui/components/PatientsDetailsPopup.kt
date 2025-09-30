package com.app.emcura.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.app.emcura.R

private val CustomRed = Color(0xFFFF0000)

@Composable
fun PatientsDetailsPopup(
    onDismiss: () -> Unit,
    symptoms: String = "",
    conditions: String = "Common cold",
    icdCodes: String = "J00.9 - Acute nasopharyngitis, unspecified",
    description: String = "",
    temperature: String = "30C",
    bloodSugar: String = "",
    height: String = "5.65",
    bmi: String = "",
    weight: String = "65",
    respiration: String = "",
    bp: String = "",
    o2Saturation: String = "98%",
    heartRate: String = "",
    patientImageRes: Int = R.drawable.ic_dashboard_profile
) {
    Dialog(onDismissRequest = onDismiss) {
        PatientsDetailsCard(
            symptoms = symptoms,
            conditions = conditions,
            icdCodes = icdCodes,
            description = description,
            temperature = temperature,
            bloodSugar = bloodSugar,
            height = height,
            bmi = bmi,
            weight = weight,
            respiration = respiration,
            bp = bp,
            o2Saturation = o2Saturation,
            heartRate = heartRate,
            patientImageRes = patientImageRes
        )
    }
}

@Composable
private fun PatientsDetailsCard(
    symptoms: String,
    conditions: String,
    icdCodes: String,
    description: String,
    temperature: String,
    bloodSugar: String,
    height: String,
    bmi: String,
    weight: String,
    respiration: String,
    bp: String,
    o2Saturation: String,
    heartRate: String,
    patientImageRes: Int
) {
    var editableDescription by remember { mutableStateOf(description) }
    
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(max = 600.dp)
            .padding(16.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Title
            item {
                Text(
                    text = "Review Current Symptoms:",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }

            // Sections
            item { DetailSection("Symptoms:", symptoms) }
            item { DetailSection("Conditions:", conditions) }
            item { DetailSection("ICD Codes:", icdCodes) }

            // Descriptions
            item {
                Column {
                    Text(
                        text = "Descriptions:",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = CustomRed,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    OutlinedTextField(
                        value = editableDescription,
                        onValueChange = { editableDescription = it },
                        placeholder = { 
                            Text("Enter patient description here...", fontSize = 12.sp, color = Color.Gray) 
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = CustomRed,
                            unfocusedBorderColor = Color.Gray,
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White,
                            cursorColor = CustomRed
                        ),
                        maxLines = 3
                    )
                }
            }

            // Vitals
            item {
                Column {
                    Text(
                        text = "Vitals:",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = CustomRed,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    VitalsTable(
                        temperature = temperature,
                        bloodSugar = bloodSugar,
                        height = height,
                        bmi = bmi,
                        weight = weight,
                        respiration = respiration,
                        bp = bp,
                        o2Saturation = o2Saturation,
                        heartRate = heartRate
                    )
                }
            }

            // Images
            item {
                Column {
                    Text(
                        text = "Image:",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = CustomRed,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Image(
                            painter = painterResource(id = patientImageRes),
                            contentDescription = "Patient Image",
                            modifier = Modifier
                                .size(80.dp)
                                .border(1.dp, Color.Gray, RoundedCornerShape(8.dp)),
                            contentScale = ContentScale.Crop
                        )

                    }
                }
            }
        }
    }
}
@Composable
private fun DetailSection(title: String, content: String) {
    Column {
        Text(
            text = title,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = CustomRed,
            modifier = Modifier.padding(bottom = 2.dp)
        )
        Text(
            text = content,
            fontSize = 13.sp,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 4.dp)
        )
    }
}

@Composable
private fun VitalsTable(
    temperature: String,
    bloodSugar: String,
    height: String,
    bmi: String,
    weight: String,
    respiration: String,
    bp: String,
    o2Saturation: String,
    heartRate: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFFDE6E6), RoundedCornerShape(8.dp))
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween) {
            VitalItem("Temperature", temperature, Modifier.weight(1f))
            VitalItem("Blood Sugar", bloodSugar, Modifier.weight(1f))
        }
        Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween) {
            VitalItem("Height", height, Modifier.weight(1f))
            VitalItem("BMI", bmi, Modifier.weight(1f))
        }
        Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween) {
            VitalItem("Weight(Lbs)", weight, Modifier.weight(1f))
            VitalItem("Respiration", respiration, Modifier.weight(1f))
        }
        Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween) {
            VitalItem("BP", bp, Modifier.weight(1f))
            VitalItem("O2 Saturation", o2Saturation, Modifier.weight(1f))
        }
        VitalItem("Heart Rate", heartRate, Modifier.fillMaxWidth())
    }
}
@Composable
private fun VitalItem(label: String, value: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(horizontal = 4.dp)) {
        Text(text = label, fontSize = 12.sp, fontWeight = FontWeight.Medium, color = Color.Black)
        Text(text = value, fontSize = 12.sp, color = Color.Black, modifier = Modifier.padding(top = 2.dp))
    }
}
@Preview(showBackground = true)
@Composable
fun PatientsDetailsPopupPreview() {
    PatientsDetailsCard(
        symptoms = "Headache, cough",
        conditions = "Common cold",
        icdCodes = "J00.9 - Acute nasopharyngitis, unspecified",
        description = "Patient is feeling unwell since yesterday.",
        temperature = "30C",
        bloodSugar = "120",
        height = "5.65",
        bmi = "22.5",
        weight = "65",
        respiration = "18",
        bp = "120/80",
        o2Saturation = "98%",
        heartRate = "75",
        patientImageRes = R.drawable.ic_dashboard_profile
    )
}
