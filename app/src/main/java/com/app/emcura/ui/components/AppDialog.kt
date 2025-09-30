package com.app.emcura.ui.components

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppDialog(
    title: String,
    message: String,
    confirmText: String = "OK",
    onConfirm: () -> Unit,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(text = title) },
        text = { Text(text = message) },
        confirmButton = {
            Button(onClick = onConfirm) {
                Text(confirmText)
            }
        },
        dismissButton = {
            Button(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun AppDialogPreview() {
    val open = remember { mutableStateOf(true) }
    if (open.value) {
        AppDialog(
            title = "Dialog Title",
            message = "This is a sample dialog message.",
            confirmText = "OK",
            onConfirm = { open.value = false },
            onDismiss = { open.value = false }
        )
    }
}