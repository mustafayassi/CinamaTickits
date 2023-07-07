package com.example.cinematicketstask.composable

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinematicketstask.R
import com.example.cinematicketstask.ui.theme.Poppins
import com.example.cinematicketstask.ui.theme.PrimaryColor
import com.example.cinematicketstask.ui.theme.White


@Composable
fun BookingButton(
    painter: Painter,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    text: String? = null,
    iconSize: Int = 24,
) {
    val isVisibleText by remember { mutableStateOf(false) }
    val iconRotateDegree by animateFloatAsState(
        targetValue = if (isVisibleText) 0f else 360f,
        animationSpec = tween(500)
    )

    Button(
        onClick = {
            onClick()
        },
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = PrimaryColor,
            contentColor = White,
        ),
        shape = if (text != null) MaterialTheme.shapes.extraLarge else CircleShape
    ) {
        Icon(
            painter = painter,
            contentDescription = "",
            tint = White,
            modifier = Modifier
                .size(iconSize.dp)
                .rotate(iconRotateDegree)
        )
        text?.let {
                Text(
                    text = it,
                    fontSize = 16.sp,
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
    }


@Preview(device = "id:pixel", showBackground = true, showSystemUi = true)
@Composable
fun PrimaryButtonPreview() {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        BookingButton(
            painter = painterResource(id = R.drawable.ic_card),
            onClick = { /*TODO*/ },
            text = "Booking",
            modifier = Modifier.height(56.dp),
        )
    }
}