package com.app.splashscreen.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.splashscreen.R
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


@Composable
fun PatientCareProfileCard(
    name: String = "Elizabeth weisberg",
    number: String = "1",
    profileImageRes: Int = R.drawable.ic_dashboard_profile,
    online: Boolean = true,
    onArrowClick: () -> Unit = {}
) {
//    Box(
        // --- Press animation and action on release for the whole card ---
        var pressed by remember { mutableStateOf(false) }
        val scale by animateFloatAsState(if (pressed) 0.96f else 1f, label = "profileCardScale")
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                }
                .background(color = androidx.compose.ui.res.colorResource(id = R.color.doc_to_cp_card), shape = RoundedCornerShape(12.dp))
                .padding(horizontal = 8.dp, vertical = 8.dp)
                .pointerInteropFilter {
                    when (it.action) {
                        android.view.MotionEvent.ACTION_DOWN -> pressed = true
                        android.view.MotionEvent.ACTION_UP -> {
                            pressed = false
                            onArrowClick()
                        }
                        android.view.MotionEvent.ACTION_CANCEL -> pressed = false
                    }
                    true // consume event, no .clickable needed
                }
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                // Profile Circle
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                        .border(2.dp, Color(0xFFED202E), CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = profileImageRes),
                        contentDescription = "Profile",
                        modifier = Modifier.size(34.dp)
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                // Name
                Text(
                    text = name,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f)
                )
                // Number centered
                Box(
                    modifier = Modifier.weight(0.5f),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = number,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp
                    )
                }
                // Forward Arrow fully right
                IconButton(
                    onClick = onArrowClick,
                    modifier = Modifier
                        .size(36.dp)
                        .align(Alignment.CenterVertically)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_dashboard_arrow_forward),
                        contentDescription = "Forward",
                        modifier = Modifier.size(22.dp)
                    )
                }
            }
        }
}

@Preview(showBackground = true)
@Composable
fun PatientCareProfileCardPreview() {
    PatientCareProfileCard()
}
