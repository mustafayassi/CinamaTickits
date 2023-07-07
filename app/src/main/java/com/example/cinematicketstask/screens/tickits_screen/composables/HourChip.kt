package com.example.cinematicketstask.screens.tickits_screen.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.LightGray
import com.example.cinematicketstask.composable.Chip
import com.example.cinematicketstask.ui.theme.Black8
import com.example.cinematicketstask.ui.theme.Black

@Composable
fun HourChip(
    hour: String,
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
    doWhenSelectHour: (String) -> Unit,
) {
    Chip(
        text = hour,
        isSelected = isSelected,
        unSelectedTextColor = Black,
        backgroundColors = listOf(DarkGray, LightGray),
        borderColor = Black8,
        modifier = modifier,
        doWhenClick = {
            doWhenSelectHour(hour)
        }
    )
}