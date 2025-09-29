package com.app.splashscreen.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.splashscreen.R

@Composable
fun ReviewCurrentSymptomsButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .background(
                color = Color(0xFFFDE6EA),
                shape = RoundedCornerShape(12.dp)
            )
            .padding(horizontal = 18.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Review Current Symptoms:",
            color = Color(0xFFED202E),
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
        Image(
            painter = painterResource(id = R.drawable.ic_dashboard_arrow_forward),
            contentDescription = "Go",
            modifier = Modifier.size(28.dp)
        )
    }
}

@Preview
@Composable
fun ReviewCurrentSymptomsButtonPreview() {
    ReviewCurrentSymptomsButton()
}
