package com.example.cinematicketstask.composable

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cinematicketstask.ui.theme.White

@Composable
fun BackIcon(
    onClickExit: () -> Unit
) {
    BackgroundBlurredCard(
        onClick = { onClickExit() },
        modifier = Modifier.padding(8.dp)
    ) {
        Box(
            modifier = Modifier
                .border(
                    1.5.dp,
                    color = White,
                    shape = CircleShape
                )
                .size(24.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                Icons.Rounded.Close,
                contentDescription = "Close",
                tint = White,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}