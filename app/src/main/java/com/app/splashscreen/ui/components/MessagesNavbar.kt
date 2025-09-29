package com.app.splashscreen.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.splashscreen.R

@Composable
fun MessagesNavbar(
    modifier: Modifier = Modifier,
    centerLogoRes: Int = R.drawable.ic_dashboard_bell_patientcare,
    onPowerClick: (() -> Unit)? = null,
    onDotsClick: (() -> Unit)? = null,
    onCenterClick: (() -> Unit)? = null
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp),
        contentAlignment = Alignment.Center
    ) {
        // Navbar background
        Surface(
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .height(48.dp)
                .align(Alignment.BottomCenter),
            color = Color.White,
            shape = RoundedCornerShape(24.dp),
            shadowElevation = 4.dp
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                NavbarIcon(
                    iconRes = R.drawable.message_navbar_power,
                    contentDesc = "Power",
                    onClick = onPowerClick
                )
                NavbarIcon(
                    iconRes = R.drawable.message_nav_three_dot,
                    contentDesc = "More",
                    onClick = onDotsClick
                )
            }
        }

        // Center logo (clickable for patient care navigation)
        Image(
            painter = painterResource(id = centerLogoRes),
            contentDescription = "Center Logo - Patient Care",
            modifier = Modifier
                .size(80.dp)
                .align(Alignment.TopCenter)
                .let { m -> 
                    if (onCenterClick != null) 
                        m.clickable(
                            indication = null, // No ripple effect
                            interactionSource = remember { MutableInteractionSource() }
                        ) { onCenterClick() } 
                    else m 
                }
        )
    }
}

@Composable
private fun NavbarIcon(
    iconRes: Int,
    contentDesc: String,
    onClick: (() -> Unit)? = null
) {
    Image(
        painter = painterResource(id = iconRes),
        contentDescription = contentDesc,
        modifier = Modifier
            .size(28.dp)
            .let { m -> 
                if (onClick != null) 
                    m.clickable(
                        indication = null, // No ripple effect
                        interactionSource = remember { MutableInteractionSource() }
                    ) { onClick() } 
                else m 
            }
    )
}

@Preview(showBackground = true)
@Composable
fun MessagesNavbarPreview() {
    MessagesNavbar()
}
