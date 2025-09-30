package com.app.emcura.ui.messages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.emcura.R
import com.app.emcura.ui.components.DashboardTopBar
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable

fun MessageChatScreen(navController: NavController? = null, onBackClick: (() -> Unit)? = null) {



    androidx.compose.runtime.LaunchedEffect(Unit) {}
    var chatInput by androidx.compose.runtime.remember { androidx.compose.runtime.mutableStateOf("") }
    var loadedMessages by androidx.compose.runtime.remember {
        androidx.compose.runtime.mutableStateOf(
            20
        )
    }
    val allMessages = List(100) {
        if (it == 5) {
            Triple("image", "", "")
        } else {
            Triple(
                "Dr. Deniel James",
                "I trust this message finds you in good spirits. As part of our ongoing commitment to your health, it's time for some routine lab work",
                "06:57"
            )
        }
    }
    val messages = allMessages.take(loadedMessages)

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
                    title = "Message Chat",
                    backIconRes = R.drawable.ic_dashboard_arrow_backward,
                    endIconRes = R.drawable.ic_dcd_hospital,
                    showBackIcon = true,
                    showEndIcon = true,
                    onBackClick = { 
                        onBackClick?.invoke() ?: navController?.popBackStack()
                    },
                    onEndIconClick = { navController?.navigate("dashboard") }
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            ProfileHeader(
                name = "Dr. Deniel James",
                status = "Online",
                imageRes = R.drawable.ic_dashboard_profile
            )

            Spacer(modifier = Modifier.height(8.dp))

            Box(modifier = Modifier.weight(1f)) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(bottom = 100.dp),
                    reverseLayout = false
                ) {
                    items(messages.size) { idx ->
                        val msg = messages[idx]
                        if (msg.first == "image") {
                            ImageBubble(imageRes = R.drawable.ic_dashboard_profile)
                        } else {
                            ChatBubble(
                                message = msg.second,
                                time = msg.third,
                                isSent = idx % 2 == 0
                            )
                        }
                        if (idx == messages.size - 1 && messages.size < allMessages.size) {
                            androidx.compose.runtime.LaunchedEffect(messages.size) {
                                loadedMessages += 20
                            }
                        }
                    }
                }
            }

            InputBar(
                value = chatInput,
                onValueChange = { chatInput = it },
                onSendClick = {
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MessageChatScreenPreview() {
    MessageChatScreen(navController = rememberNavController())
}
