package com.example.cinematicketstask.screens.tickits_screen.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import com.example.cinematicketstask.screens.tickits_screen.model.SeatsState

@Composable
fun RotateOfChairs(
    pairList: List<Pair<SeatsState, SeatsState>>,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        repeat(pairList.size) {
            PairSeats(
                pair = pairList[it],
                size = 35,
                modifier = Modifier.graphicsLayer {
                    rotationZ =  if (it == 0) 10f else if (it == 1) 0f else -10f
                    translationY = if (it == 1) 20f else 0f
                },
            )
        }
    }
}


@Preview(showBackground = true, showSystemUi = true, backgroundColor = 0xFF000000)
@Composable
fun RowOfPairOfChairsPreview() {
    RotateOfChairs(
        pairList = listOf(
            Pair(SeatsState.Taken, SeatsState.Available),
            Pair(SeatsState.Selected, SeatsState.Selected),
            Pair(SeatsState.Taken, SeatsState.Taken),
        )
    )
}