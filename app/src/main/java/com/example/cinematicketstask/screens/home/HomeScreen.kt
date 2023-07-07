package com.example.cinematicketstask.screens.home

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlurEffect
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.cinematicketstask.NavScreens
import com.example.cinematicketstask.R
import com.example.cinematicketstask.composable.Chip
import com.example.cinematicketstask.screens.home.composable.Carousel
import com.example.cinematicketstask.screens.home.composable.GradientOverlay
import com.example.cinematicketstask.screens.utile.Space
import com.example.cinematicketstask.ui.theme.Black38
import com.example.cinematicketstask.ui.theme.Black8
import com.example.cinematicketstask.ui.theme.Black
import com.example.cinematicketstask.ui.theme.Poppins


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    navController: NavController,
    screenPadding: PaddingValues,
) {
    val pagerState = rememberPagerState(initialPage = 1)
    var homeUiState by remember { mutableStateOf(HomeUiState()) }
    HomeScreenContent(
        screenPadding = screenPadding,
        pagerState = pagerState,
        state = homeUiState,
        listener = object : HomeScreenInteractionsListener {
            override fun onClickItem() {
                navController.navigate(NavScreens.Booking.route)
            }
            
            override fun onClickFirstChip() {
                homeUiState =
                    homeUiState.copy(
                        nowShowingChip = homeUiState.nowShowingChip.copy(isSelected = true),
                        comingSoonChip = homeUiState.comingSoonChip.copy(isSelected = false)
                    )
            }

            override fun onClickSecondChip() {
                homeUiState =
                    homeUiState.copy(
                        nowShowingChip = homeUiState.nowShowingChip.copy(isSelected = false),
                        comingSoonChip = homeUiState.comingSoonChip.copy(isSelected = true)
                    )
            }

            override fun onNavigateToBuyTicketsScreen() {
                navController.navigate(NavScreens.Tickets.route)
            }
        },
    )
}


@OptIn(
    ExperimentalFoundationApi::class,
    ExperimentalLayoutApi::class,
)
@Composable
fun HomeScreenContent(
    screenPadding: PaddingValues,
    pagerState: PagerState,
    state: HomeUiState,
    listener: HomeScreenInteractionsListener
) {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(screenPadding)) {
        Crossfade(
            targetState = state.images[pagerState.currentPage],
            animationSpec = tween(200, easing = FastOutSlowInEasing),
            label = "Cross Fade Animation For Background"
        ) { selectedImageRes ->
            GradientOverlay {
                Image(
                    painter = painterResource(id = selectedImageRes),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.5f)
                        .graphicsLayer {
                            renderEffect = BlurEffect(
                                100f,
                                100f,
                            )
                            clip = false
                        }
                )
            }
        }
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
                horizontalArrangement = Arrangement.Center,
            ) {
                Chip(
                    text = state.nowShowingChip.title,
                    isSelected = state.nowShowingChip.isSelected,
                    modifier = Modifier.padding(horizontal = 8.dp),
                    doWhenClick = listener::onClickFirstChip,
                    fontSize = 14.sp
                )
                Space(space = 8.dp)
                Chip(
                    text = state.comingSoonChip.title,
                    isSelected = state.comingSoonChip.isSelected,
                    modifier = Modifier.padding(horizontal = 8.dp),
                    doWhenClick = listener::onClickSecondChip,
                    fontSize = 14.sp
                )
            }
            Carousel(
                onClickImage = listener::onClickItem,
                pagerState = pagerState,
                images = state.images,
                modifier = Modifier.padding(top = 24.dp)
            )

            Row(
                modifier = Modifier.padding(top = 24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_time),
                    contentDescription = "time",
                    tint = Black38,
                    modifier = Modifier.size(16.dp),
                )
                Space(space = 4.dp)
                Text(
                    text = state.time,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = Poppins,
                    color = Black,
                )
            }

            Text(
                text = state.title,
                fontFamily = Poppins,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                modifier = Modifier.padding(top = 16.dp)
            )

            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                modifier = Modifier.padding(top = 16.dp),
            ) {
                state.genres.forEach {
                    Chip(
                        text = it,
                        isEnabled = false,
                        unSelectedTextColor = Black,
                        borderColor = Black8,
                        fontSize = 12.sp
                    )
                }
            }
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun HomeScreenPrev() {
    HomeScreenContent(
        screenPadding = PaddingValues(vertical = 0.dp),
        pagerState = PagerState(initialPage = 1),
        state = HomeUiState(),
        listener = object : HomeScreenInteractionsListener {
            override fun onClickItem() {
                TODO("Not yet implemented")
            }

            override fun onClickFirstChip() {
                TODO("Not yet implemented")
            }

            override fun onClickSecondChip() {
                TODO("Not yet implemented")
            }


            override fun onNavigateToBuyTicketsScreen() {
                TODO("Not yet implemented")
            }

        }
    )
}