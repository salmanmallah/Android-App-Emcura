package com.app.emcura.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInteropFilter
import com.app.emcura.R
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Composable
fun DashboardIconGrid(
    icons: List<Pair<Int, String>>,
    modifier: Modifier = Modifier,
    onIconClick: ((Int) -> Unit)? = null,
    onInstantConnectClick: (() -> Unit)? = null
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
                    val showRedBorder = iconIndex == 1 || iconIndex == 4 // Center icons
                    // --- Press animation and action on release ---
                    var pressed by remember { mutableStateOf(false) }
                    val scale by animateFloatAsState(if (pressed) 0.92f else 1f, label = "dashboardIconScale$iconIndex")
                    val pressModifier = Modifier
                        .graphicsLayer {
                            scaleX = scale
                            scaleY = scale
                        }
                        .pointerInteropFilter {
                            when (it.action) {
                                android.view.MotionEvent.ACTION_DOWN -> pressed = true
                                android.view.MotionEvent.ACTION_UP -> {
                                    pressed = false
                                    if (label == "Instant Connect" && onInstantConnectClick != null) onInstantConnectClick()
                                    else if (onIconClick != null) onIconClick(iconIndex)
                                }
                                android.view.MotionEvent.ACTION_CANCEL -> pressed = false
                            }
                            true
                        }
                    DashboardCircleIconWithLabel(
                        iconResId = iconResId,
                        label = label,
                        showRedBorder = showRedBorder,
                        modifier = pressModifier
                    )
                }
            }
        }
    }
}

@Composable
fun DashboardCircleIconWithLabel(
    iconResId: Int,
    label: String,
    showRedBorder: Boolean = false,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.wrapContentSize()
    ) {
        // Circle Icon
        Box(
            modifier = Modifier
                .size(62.dp)
                .shadow(6.dp, CircleShape)
                .background(color = MaterialTheme.colorScheme.background, shape = CircleShape)
                .clip(CircleShape)
                .then(
                    if (showRedBorder) Modifier.border(2.dp, Color(0xFFEB474B), CircleShape) else Modifier
                ),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = iconResId),
                contentDescription = label,
                modifier = Modifier
                    .fillMaxSize(0.62f)
            )
        }

        Spacer(modifier = Modifier.height(6.dp))

        // Text Label
        Text(
            text = label,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF222222),
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
