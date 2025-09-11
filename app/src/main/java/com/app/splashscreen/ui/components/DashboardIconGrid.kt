package com.app.splashscreen.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.app.splashscreen.R

@Composable
fun DashboardIconGrid(
    icons: List<Int>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            DashboardCircleIcon(icons[0], Modifier.weight(1f))
            DashboardCircleIcon(icons[1], Modifier.weight(1f))
            DashboardCircleIcon(icons[2], Modifier.weight(1f))
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            DashboardCircleIcon(icons[3], Modifier.weight(1f))
            DashboardCircleIcon(icons[4], Modifier.weight(1f))
            DashboardCircleIcon(icons[5], Modifier.weight(1f))
        }
    }
}

@Composable
fun DashboardCircleIcon(iconResId: Int, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .aspectRatio(1f)
            .padding(8.dp)
            .shadow(12.dp, CircleShape)
            .background(color = MaterialTheme.colorScheme.background, shape = CircleShape)
            .clip(CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = iconResId),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize(0.65f)
                .clip(CircleShape)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DashboardIconGridPreview() {
    DashboardIconGrid(
        icons = listOf(
            R.drawable.ic_dashboard_connect,
            R.drawable.ic_dashboard_mic,
            R.drawable.ic_dashboard_prescription,
            R.drawable.ic_dashboard_call,
            R.drawable.ic_dashboard_connect,
            R.drawable.ic_dashboard_refill
        ),
        modifier = Modifier.padding(24.dp)
    )
}
