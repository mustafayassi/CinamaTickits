package com.example.cinematicketstask.screens.details_screen.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinematicketstask.R
import com.example.cinematicketstask.ui.theme.PrimaryColor
import com.example.cinematicketstask.ui.theme.White

@Composable
fun PlayButton(
    onClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .size(56.dp)
            .clip(CircleShape)
            .clickable { onClick() }
            .background(PrimaryColor)
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_paly),
            contentDescription = "",
            tint = White,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Preview
@Composable
fun PlayButtonPrev() {
    PlayButton()
}