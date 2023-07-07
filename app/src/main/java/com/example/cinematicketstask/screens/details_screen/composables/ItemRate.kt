package com.example.cinematicketstask.screens.details_screen.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.example.cinematicketstask.ui.theme.Black38
import com.example.cinematicketstask.ui.theme.Black
import com.example.cinematicketstask.ui.theme.Poppins

import kotlin.math.roundToInt

@Composable
fun ItemRate(
    rateOfTen: Float,
    type: String
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = buildAnnotatedString {
                withStyle(SpanStyle(color = Black)) {
                    append(((rateOfTen * 10.0).roundToInt() / 10.0).toString())
                }
                withStyle(SpanStyle(color = Black38)) {
                    append("/10")
                }
            },
            fontFamily = Poppins,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp
        )
        Text(
            text = type,
            color = Black38,
            fontFamily = Poppins,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp
        )
    }

}