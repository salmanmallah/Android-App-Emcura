
package com.app.emcura.ui.videocall

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.app.emcura.R
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun FloatingVideoPreview(
    modifier: Modifier = Modifier,
    imageRes: Int = R.drawable.vc_floating_image,
    initialOffset: DpOffset = DpOffset(0.dp, 0.dp),
    boxSize: Int = 96
) {
    var offsetX by remember { mutableStateOf(initialOffset.x.value) }
    var offsetY by remember { mutableStateOf(initialOffset.y.value) }
    val shape = RoundedCornerShape(18.dp)

    Box(
        modifier = modifier
            .size(boxSize.dp, (boxSize * 1.3f).dp)
            .offset(x = offsetX.dp, y = offsetY.dp)
            .shadow(10.dp, shape)
            .clip(shape)

            .pointerInput(Unit) {
                detectDragGestures { change, dragAmount ->
                    change.consume()
                    offsetX += dragAmount.x / density
                    offsetY += dragAmount.y / density
                }
            },
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "Floating Preview",
            modifier = Modifier
                .fillMaxSize()
                .clip(shape),
            alignment = Alignment.Center
        )
    }
}


@Preview
@Composable
fun FloatingVideoPreviewPreview() {
    FloatingVideoPreview()
}