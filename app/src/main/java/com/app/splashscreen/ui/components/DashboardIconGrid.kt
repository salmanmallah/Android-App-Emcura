package com.app.splashscreen.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material3.Text
import com.app.splashscreen.R

@Composable
fun DashboardIconGrid(
    icons: List<Pair<Int, String>>,
    modifier: Modifier = Modifier,
    onIconClick: ((Int) -> Unit)? = null
) {
    val iconsPerRow = 3
    val rows = icons.chunked(iconsPerRow)

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(18.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        rows.forEachIndexed { rowIndex, rowIcons ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                rowIcons.forEachIndexed { colIndex, (iconResId, label) ->
                    val iconIndex = rowIndex * iconsPerRow + colIndex
                    DashboardCircleIconWithLabel(
                        iconResId = iconResId,
                        label = label,
                        modifier = Modifier.then(
                            if (onIconClick != null) Modifier.clickable { onIconClick(iconIndex) } else Modifier
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun DashboardCircleIconWithLabel(iconResId: Int, label: String, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.wrapContentSize() // Column apni height expand karega
    ) {
        // Circle Icon
        Box(
            modifier = Modifier
                .size(62.dp) // ✅ sirf circle icon ke liye size
                .shadow(6.dp, CircleShape)
                .background(color = MaterialTheme.colorScheme.background, shape = CircleShape)
                .clip(CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = iconResId),
                contentDescription = label,
                modifier = Modifier
                    .fillMaxSize(0.62f)
                    .clip(CircleShape)
            )
        }

        Spacer(modifier = Modifier.height(6.dp))

        // Text Label
        Text(
            text = label,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            color = androidx.compose.ui.graphics.Color(0xFF222222),
            maxLines = 2
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DashboardIconGridPreview() {
    DashboardIconGrid(
        icons = listOf(
            R.drawable.ic_dashboard_connect to "Doc to Doc",
            R.drawable.ic_dashboard_mic to "Clinic Patient",
            R.drawable.ic_dashboard_prescription to "My Prescriptions",
            R.drawable.ic_dashboard_call to "Call History",
            R.drawable.ic_dashboard_connect to "Instant Connect",
            R.drawable.ic_dashboard_refill to "Refill Request"
        ),
        modifier = Modifier.padding(18.dp)
    )
}
