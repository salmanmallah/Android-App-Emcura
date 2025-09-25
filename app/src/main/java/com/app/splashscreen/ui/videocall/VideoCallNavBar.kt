package com.app.splashscreen.ui.videocall

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.splashscreen.R

@Composable
fun VideoCallNavBar(
    modifier: Modifier = Modifier,
    onHangup: () -> Unit = {},
    onLeftCamera: () -> Unit = {},
    onStar: () -> Unit = {},
    onMore: () -> Unit = {},
    onRightCamera: () -> Unit = {},
    onMic: () -> Unit = {}
) {
    val navBarHeight = 68.dp
    val hangupButtonSize = 64.dp
    val hangupButtonElevation = 10.dp
    val navBarColor = Color(0xFFF45B5B)
    val iconSize = 24.dp // smaller icons for better fit
    val iconPadding = 12.dp

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(navBarHeight)
            .background(Color.Transparent),
        contentAlignment = Alignment.BottomCenter
    ) {
        // Custom background with deeper curved cutout
        androidx.compose.foundation.Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(navBarHeight)
        ) {
            val hangupButtonSizePx = hangupButtonSize.toPx()
            val cutoutRadius = hangupButtonSizePx * 1.05f // even more curve
            val width = size.width
            val height = size.height
            val cutoutCenterX = width / 2f
            val curveDepth = hangupButtonSizePx * 1.05f // much deeper
            val path = Path().apply {
                moveTo(0f, 0f)
                lineTo(cutoutCenterX - cutoutRadius, 0f)
                cubicTo(
                    cutoutCenterX - cutoutRadius / 1.2f, 0f,
                    cutoutCenterX - cutoutRadius * 0.7f, curveDepth,
                    cutoutCenterX, curveDepth
                )
                cubicTo(
                    cutoutCenterX + cutoutRadius * 0.7f, curveDepth,
                    cutoutCenterX + cutoutRadius / 1.2f, 0f,
                    cutoutCenterX + cutoutRadius, 0f
                )
                lineTo(width, 0f)
                lineTo(width, height)
                lineTo(0f, height)
                close()
            }
            drawPath(path, color = navBarColor, style = Fill)
        }

        // Left side buttons
        Row(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = iconPadding)
                .height(navBarHeight),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.vc_camera),
                contentDescription = "Camera",
                modifier = Modifier
                    .size(iconSize)
                    .clickable { onLeftCamera() }
            )
            Image(
                painter = painterResource(id = R.drawable.vc_shooting_star),
                contentDescription = "Star",
                modifier = Modifier
                    .size(iconSize)
                    .clickable { onStar() }
            )
            Image(
                painter = painterResource(id = R.drawable.vc_three_dots),
                contentDescription = "More",
                modifier = Modifier
                    .size(iconSize)
                    .clickable { onMore() }
            )
        }

        // Right side buttons
        Row(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = iconPadding)
                .height(navBarHeight),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.vc_camera),
                contentDescription = "Camera",
                modifier = Modifier
                    .size(iconSize)
                    .clickable { onRightCamera() }
            )
            Image(
                painter = painterResource(id = R.drawable.vc_mic),
                contentDescription = "Mic",
                modifier = Modifier
                    .size(iconSize)
                    .clickable { onMic() }
            )
        }

        // Hangup button (center, above curve) with no background behind
        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = (-hangupButtonElevation))
                .size(hangupButtonSize)
                .clip(CircleShape)
                .clickable { onHangup() },
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.video_call_drop),
                contentDescription = "Hangup",
                modifier = Modifier.size(48.dp),
                contentScale = ContentScale.Fit
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VideoCallNavBarPreview() {
    VideoCallNavBar()
}
