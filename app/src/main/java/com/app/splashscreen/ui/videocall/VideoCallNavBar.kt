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
    val navBarHeight = 88.dp
    val hangupButtonSize = 72.dp
    val hangupButtonElevation = 16.dp
    val navBarColor = Color(0xFFF45B5B)
    val iconSize = 32.dp
    val iconPadding = 18.dp

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(navBarHeight)
            .background(Color.Transparent),
        contentAlignment = Alignment.BottomCenter
    ) {
        // Custom background with curved cutout
        androidx.compose.foundation.Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(navBarHeight)
        ) {
            val hangupButtonSizePx = hangupButtonSize.toPx()
            val cutoutRadius = hangupButtonSizePx / 2f + 12.dp.toPx()
            val width = size.width
            val height = size.height
            val cutoutCenterX = width / 2f
            val path = Path().apply {
                moveTo(0f, 0f)
                lineTo(cutoutCenterX - cutoutRadius, 0f)
                cubicTo(
                    cutoutCenterX - cutoutRadius / 2, 0f,
                    cutoutCenterX - cutoutRadius / 2, cutoutRadius,
                    cutoutCenterX, cutoutRadius
                )
                cubicTo(
                    cutoutCenterX + cutoutRadius / 2, cutoutRadius,
                    cutoutCenterX + cutoutRadius / 2, 0f,
                    cutoutCenterX + cutoutRadius, 0f
                )
                lineTo(width, 0f)
                lineTo(width, height)
                lineTo(0f, height)
                close()
            }
            drawPath(path, color = navBarColor, style = Fill)
        }

        // Icons and hangup button
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 0.dp)
                .height(navBarHeight),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Spacer(modifier = Modifier.width(iconPadding))
            // Left Camera
            Image(
                painter = painterResource(id = R.drawable.vc_camera),
                contentDescription = "Camera",
                modifier = Modifier
                    .size(iconSize)
                    .clickable { onLeftCamera() }
            )
            Spacer(modifier = Modifier.width(8.dp))
            // Star
            Image(
                painter = painterResource(id = R.drawable.vc_shooting_star),
                contentDescription = "Star",
                modifier = Modifier
                    .size(iconSize)
                    .clickable { onStar() }
            )
            Spacer(modifier = Modifier.width(8.dp))
            // More
            Image(
                painter = painterResource(id = R.drawable.vc_three_dots),
                contentDescription = "More",
                modifier = Modifier
                    .size(iconSize)
                    .clickable { onMore() }
            )
            Spacer(modifier = Modifier.width(hangupButtonSize / 2 + 8.dp)) // Space for hangup button
            // Right Camera
            Image(
                painter = painterResource(id = R.drawable.vc_camera),
                contentDescription = "Camera",
                modifier = Modifier
                    .size(iconSize)
                    .clickable { onRightCamera() }
            )
            Spacer(modifier = Modifier.width(8.dp))
            // Mic
            Image(
                painter = painterResource(id = R.drawable.vc_mic),
                contentDescription = "Mic",
                modifier = Modifier
                    .size(iconSize)
                    .clickable { onMic() }
            )
            Spacer(modifier = Modifier.width(iconPadding))
        }

        // Hangup button (center, above curve)
        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = (-hangupButtonElevation))
                .size(hangupButtonSize)
                .clip(CircleShape)
                .background(navBarColor)
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
