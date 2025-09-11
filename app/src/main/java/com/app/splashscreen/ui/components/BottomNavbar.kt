package com.app.splashscreen.ui.components

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color


@Composable
fun BottomNavbar(
    items: List<BottomNavItem>,
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit
) {
    Surface(
        color = Color.White,
       
        shadowElevation = 8.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(Color.White),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            items.forEachIndexed { index, item ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                        .weight(1f)
                        .clickable { onItemSelected(index) }
                ) {
                    Icon(
                        painter = painterResource(id = item.iconRes),
                        contentDescription = item.label,
                        tint = if (selectedIndex == index) item.selectedColor else item.unselectedColor,
                        modifier = Modifier.size(28.dp)
                    )
                    Text(
                        text = item.label,
                        fontSize = 11.sp,
                        color = if (selectedIndex == index) item.selectedColor else item.unselectedColor
                    )
                }
            }
        }
    }
}


data class BottomNavItem(
    val iconRes: Int,
    val label: String,
    val selectedColor: Color = Color(0xFFE94F4F),
    val unselectedColor: Color = Color(0xFFBDBDBD)
)


@Preview(showBackground = true)
@Composable
fun BottomNavbarPreview() {
    val items = listOf(
        BottomNavItem(iconRes = android.R.drawable.ic_menu_call, label = "Call"),
        BottomNavItem(iconRes = android.R.drawable.ic_menu_camera, label = "Camera"),
        BottomNavItem(iconRes = android.R.drawable.ic_menu_compass, label = "Compass")
    )
    BottomNavbar(items = items, selectedIndex = 0, onItemSelected = {})
}