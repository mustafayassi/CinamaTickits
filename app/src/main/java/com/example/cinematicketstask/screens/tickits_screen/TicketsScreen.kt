package com.example.cinematicketstask.screens.tickits_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cinematicketstask.R
import com.example.cinematicketstask.composable.BookingButton
import com.example.cinematicketstask.composable.BottomSheet
import com.example.cinematicketstask.composable.BackIcon
import com.example.cinematicketstask.screens.tickits_screen.composables.DateChip
import com.example.cinematicketstask.screens.tickits_screen.composables.HourChip
import com.example.cinematicketstask.screens.tickits_screen.composables.RotateOfChairs
import com.example.cinematicketstask.screens.tickits_screen.model.SeatsState
import com.example.cinematicketstask.screens.utile.cinemaStyle
import com.example.cinematicketstask.ui.theme.Black
import com.example.cinematicketstask.ui.theme.BlackSecondary
import com.example.cinematicketstask.ui.theme.Poppins


@Composable
fun TicketsScreen(
    navController: NavController,
    screenPadding: PaddingValues
) {
    var ticketsUiState by remember { mutableStateOf(TicketsUiState()) }
    TicketsContent(
        listener = object : TicketsInteractionsListener {
            override fun onClickBackIcon() {
                navController.popBackStack()
            }

            override fun onClickBuy() {

            }

            override fun doWhenSelectDay(day: Days) {
                ticketsUiState = ticketsUiState.copy(selectedDay = day)
            }

            override fun doWhenSelectHour(hour: String) {
                ticketsUiState = ticketsUiState.copy(selectedTime = hour)
            }

        },
        state = ticketsUiState,
        screenPadding = screenPadding
    )
}

@Composable
fun TicketsContent(
    state: TicketsUiState,
    listener: TicketsInteractionsListener,
    screenPadding: PaddingValues
) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(screenPadding)
            .background(Color.Black)
    ) {
        val (xIcon, image, rowChairs1,
            rowChairs2, rowChairs3, rowChairs4,
            rowChairs5, information, bottomSheet) = createRefs()

        Box(modifier = Modifier.constrainAs(xIcon) {
            start.linkTo(parent.start, 16.dp)
            top.linkTo(parent.top, 16.dp)
        }) { BackIcon(listener::onClickBackIcon) }

        Image(
            painter = painterResource(id = R.drawable.header),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .cinemaStyle(clipRatio = 50f, rotationX = -50f)
                .constrainAs(image) {
                    top.linkTo(xIcon.bottom, (-16).dp)
                },
        )

        val rotationalValue = 50
        RotateOfChairs(
            pairList = listOf(
                Pair(SeatsState.Available, SeatsState.Available),
                Pair(SeatsState.Available, SeatsState.Available),
                Pair(SeatsState.Taken, SeatsState.Available),
            ),
            modifier = Modifier.constrainAs(rowChairs1) {
                top.linkTo(image.bottom, (-8).dp)
            }
        )

        RotateOfChairs(
            pairList = listOf(
                Pair(SeatsState.Available, SeatsState.Available),
                Pair(SeatsState.Selected, SeatsState.Selected),
                Pair(SeatsState.Available, SeatsState.Available),
            ),
            modifier = Modifier.constrainAs(rowChairs2) {
                top.linkTo(rowChairs1.bottom, (-rotationalValue).dp)
            }
        )

        RotateOfChairs(
            pairList = listOf(
                Pair(SeatsState.Taken, SeatsState.Available),
                Pair(SeatsState.Selected, SeatsState.Selected),
                Pair(SeatsState.Taken, SeatsState.Taken),
            ),
            modifier = Modifier.constrainAs(rowChairs3) {
                top.linkTo(rowChairs2.bottom, (-rotationalValue).dp)
            }
        )

        RotateOfChairs(
            pairList = listOf(
                Pair(SeatsState.Available, SeatsState.Available),
                Pair(SeatsState.Taken, SeatsState.Taken),
                Pair(SeatsState.Available, SeatsState.Available),
            ),
            modifier = Modifier.constrainAs(rowChairs4) {
                top.linkTo(rowChairs3.bottom, (-rotationalValue).dp)
            }
        )
        RotateOfChairs(
            pairList = listOf(
                Pair(SeatsState.Taken, SeatsState.Taken),
                Pair(SeatsState.Taken, SeatsState.Taken),
                Pair(SeatsState.Available, SeatsState.Available),
            ),
            modifier = Modifier.constrainAs(rowChairs5) {
                top.linkTo(rowChairs4.bottom, (-rotationalValue).dp)
            }
        )
        /// endregion

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(information) {
                    top.linkTo(rowChairs5.bottom, margin = (-8).dp)
                    bottom.linkTo(bottomSheet.top)
                },
            horizontalArrangement = Arrangement.SpaceAround,
        ) { }

        BottomSheet(
            modifier = Modifier.constrainAs(bottomSheet) {
                bottom.linkTo(parent.bottom)
            }
        ) {
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                items(state.days) {
                    DateChip(
                        it,
                        isSelected = it == state.selectedDay,
                        doWhenSelect = listener::doWhenSelectDay
                    )
                }
            }
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                items(state.dataList) {
                    HourChip(
                        it,
                        isSelected = it == state.selectedTime,
                        doWhenSelectHour = listener::doWhenSelectHour,
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(horizontalAlignment = Alignment.Start) {
                    Text(
                        text = "$${state.price}",
                        fontSize = 24.sp,
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Bold,
                        color = Black,
                    )
                    Text(
                        text = "${state.ticketsCount} tickets",
                        fontSize = 11.sp,
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Normal,
                        color = BlackSecondary
                    )

                }
                BookingButton(
                    painter = painterResource(id = R.drawable.ic_card),
                    onClick = listener::onClickBuy,
                    text = "Buy Tickets",
                    modifier = Modifier.height(56.dp),
                )
            }
        }
    }
}



@Preview(showBackground = true, showSystemUi = true, device = "id:pixel_3a_xl")
@Composable
fun BuyTicketsScreenPrev() {
    TicketsScreen(rememberNavController(), PaddingValues(0.dp))
}