package com.app.splashscreen.ui.messages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.splashscreen.R
import com.app.splashscreen.ui.components.DashboardTopBar
import com.app.splashscreen.ui.components.MessageCard
import com.app.splashscreen.ui.components.MessagesNavbar
import androidx.navigation.NavController


@Composable
fun MessagesScreen(navController: NavController, onBackClick: (() -> Unit)? = null) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F8F8))
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            // Top bar
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(vertical = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                DashboardTopBar(
                    title = "Messages",
                    backIconRes = R.drawable.ic_dashboard_arrow_backward,
                    endIconRes = R.drawable.ic_dcd_hospital,
                    showBackIcon = true,
                    showEndIcon = true,
                    onBackClick = onBackClick,
                    onEndIconClick = { navController.navigate("dashboard") }
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Dummy messages
            val messages = listOf(
                Triple("Dr. Supak Sookkasikon", "I trust this message finds you in good spirits. As part of our ongoing commitment to your health, it's time for some routine lab work", "12:58 PM"),
                Triple("Dr. Diallo S Jabari", "I trust this message finds you in good spirits. As part of our ongoing commitment to your health, it's time for some routine lab work", "YESTERDAY"),
                Triple("Dr. Bobby Anderson", "I trust this message finds you in good spirits. As part of our ongoing commitment to your health, it's time for some routine lab work", "07/30/2024"),
                Triple("Dr. Ariana Chloe", "I trust this message finds you in good spirits. As part of our ongoing commitment to your health, it's time for some routine lab work", "07/30/2024"),
                Triple("Dr. Deniel James", "I trust this message finds you in good spirits. As part of our ongoing commitment to your health, it's time for some routine lab work", "07/30/2024"),
                Triple("Dr. Gerard Lucas", "I trust this message finds you in good spirits. As part of our ongoing commitment to your health, it's time for some routine lab work", "07/30/2024")
            )

            // Messages list
            Box(modifier = Modifier.weight(1f)) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(bottom = 100.dp),
                ) {
                    items(messages.size) { idx ->
                        val (name, msg, time) = messages[idx]
                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .clickable { navController?.navigate("messagechat") }) {
                            MessageCard(
                                name = name,
                                message = msg,
                                time = time,
                                imageRes = R.drawable.ic_dashboard_profile,
                                unreadCount = if (idx == 0) 3 else 0
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                    item {
                        Spacer(modifier = Modifier.height(200.dp))
                    }
                }
            }
        }

        // Floating navbar at bottom
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter) // ✅ ye sahi jagah
                .padding(bottom = 24.dp),
            contentAlignment = Alignment.Center
        ) {
            MessagesNavbar()
        }
    }
}

@Composable
@Preview(showBackground = true)
fun MessagesScreenPreview() {
    MessagesScreen(navController = androidx.navigation.compose.rememberNavController())
}
