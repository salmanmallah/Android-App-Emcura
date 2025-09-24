package com.app.splashscreen.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Text
import com.app.splashscreen.R

@Composable
fun DashboardTopBar(
    title: String,
    onBackClick: (() -> Unit)? = null,
    onEndIconClick: (() -> Unit)? = null,
    modifier: Modifier = Modifier,
    backIconRes: Int = R.drawable.ic_dashboard_arrow_backward,
    endIconRes: Int = R.drawable.ic_dcd_hospital,
    showBackIcon: Boolean = true,
    showEndIcon: Boolean = true,
    textColor: androidx.compose.ui.graphics.Color = androidx.compose.ui.graphics.Color.Black
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 24.dp, start = 24.dp, end = 24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (showBackIcon) {
            Image(
                painter = painterResource(id = backIconRes),
                contentDescription = "Back",
                modifier = Modifier
                    .size(25.dp)
                    .let { m ->
                        if (onBackClick != null) m.clickable { onBackClick() } else m
                    }
            )
        } else {
            Spacer(modifier = Modifier.width(25.dp))
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = title,
            color = textColor,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.weight(1f))
        if (showEndIcon) {
            Image(
                painter = painterResource(id = endIconRes),
                contentDescription = "End Icon",
                modifier = Modifier
                    .size(25.dp)
                    .let { m ->
                        if (onEndIconClick != null) m.clickable { onEndIconClick() } else m
                    }
            )
        } else {
            Spacer(modifier = Modifier.width(25.dp))
        }
    }
}


