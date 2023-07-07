package com.example.cinematicketstask.screens.tickits_screen.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinematicketstask.composable.Chip
import com.example.cinematicketstask.screens.tickits_screen.Days
import com.example.cinematicketstask.ui.theme.Black8
import com.example.cinematicketstask.ui.theme.Black
import com.example.cinematicketstask.ui.theme.Poppins


@Composable
fun DateChip(
    day: Days,
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
    doWhenSelect: (Days) -> Unit
) {
    Chip(
        text = day.dayNumber.toString(),
        isSelected = isSelected,
        unSelectedTextColor = Black,
        backgroundColors = listOf(DarkGray, LightGray),
        borderColor = Black8,
        modifier = modifier.padding(horizontal = 8.dp),
        doWhenClick = {
            doWhenSelect(day)
        }
    ) {
        Text(
            text = day.dayName,
            color = it.copy(0.38f),
            fontFamily = Poppins,
            fontWeight = FontWeight.Normal,
            fontSize = 11.sp
        )
    }
}
