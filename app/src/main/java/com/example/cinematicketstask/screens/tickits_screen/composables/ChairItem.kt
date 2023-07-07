package com.example.cinematicketstask.screens.tickits_screen.composables

import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.size
import androidx.compose.material.IconButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinematicketstask.R
import com.example.cinematicketstask.screens.tickits_screen.model.SeatsState
import com.example.cinematicketstask.ui.theme.PrimaryColor
import com.example.cinematicketstask.ui.theme.White

@Composable
fun ChairItem(
    chairState: SeatsState,
    modifier: Modifier = Modifier,
    ocClickChair: (SeatsState) -> Unit,
) {
    val tintColor = when (chairState) {
        SeatsState.Available -> White
        SeatsState.Taken -> DarkGray
        SeatsState.Selected -> PrimaryColor
    }

    val animatedTintColor by animateColorAsState(
        targetValue = tintColor,
        animationSpec = tween(200, easing = FastOutSlowInEasing)
    )

    Crossfade(
        targetState = chairState,
        animationSpec = tween(200, easing = FastOutSlowInEasing),
    ) { state ->
        IconButton(
            onClick = { ocClickChair(state) },
            modifier = modifier,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_chair),
                contentDescription = null,
                tint = animatedTintColor,
                modifier = modifier,
            )
        }
    }
}

@Preview
@Composable
fun ChairItemPreview() {
    ChairItem(chairState = SeatsState.Selected, modifier = Modifier.size(75.dp)){}
}