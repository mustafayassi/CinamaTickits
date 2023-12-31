package com.example.cinematicketstask.screens.tickits_screen.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinematicketstask.R
import com.example.cinematicketstask.screens.tickits_screen.model.SeatsState
import com.example.cinematicketstask.screens.tickits_screen.model.nextState
import com.example.cinematicketstask.ui.theme.PrimaryColor


@Composable
fun PairSeats(
    pair: Pair<SeatsState, SeatsState>,
    modifier: Modifier = Modifier,
    size: Int = 75
) {
    var pairState by remember {
        mutableStateOf(pair)
    }
    
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_chair_container),
            contentDescription = "icon chairs",
            modifier = Modifier.size((size * 2 + 38).dp),
            tint = if ((pairState.first == pairState.second) && (pairState.second == SeatsState.Selected)) {
                PrimaryColor.copy(alpha = 0.38f)
            } else if ((pairState.first == pairState.second) && (pairState.second == SeatsState.Taken)) {
                DarkGray.copy(alpha = 0.2f)
            } else {
                DarkGray.copy(alpha = 0.6f)
            }
        )
        Row(
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            ChairItem(chairState = pairState.first, modifier = Modifier.size(size.dp)){
                pairState = pairState.copy(first = it.nextState())
            }
            ChairItem(chairState = pairState.second, modifier = Modifier.size(size.dp)){
                pairState = pairState.copy(second = it.nextState())
            }
        }
    }
}


@Preview
@Composable
fun PairChairsPreview() {
    PairSeats(Pair(SeatsState.Taken, SeatsState.Taken))
}