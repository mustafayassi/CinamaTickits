package com.example.cinematicketstask

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.cinematicketstask.screens.details_screen.BookingScreen
import com.example.cinematicketstask.screens.home.composable.CustomBottomNav
import com.example.cinematicketstask.screens.home.HomeScreen
import com.example.cinematicketstask.screens.tickits_screen.TicketsScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation(
    navController: NavHostController,
) {
    val navigation by navController.currentBackStackEntryAsState()
    val currentRoute = navigation?.destination?.route ?: NavScreens.Home.route

    Scaffold(
        bottomBar = {
            AnimatedVisibility(
                visible = currentRoute == NavScreens.Home.route,
                enter = slideInVertically() + fadeIn(),
                exit = slideOutVertically { it } + fadeOut()
            ) {
                CustomBottomNav { navController.navigate(NavScreens.Tickets.route) }
            }
        },
    ) { screenPadding ->
        NavHost(navController = navController, startDestination = NavScreens.Home.route) {
            composable(NavScreens.Home.route) {
                HomeScreen(navController = navController, screenPadding = screenPadding)
            }
            composable(NavScreens.Booking.route) {
                BookingScreen(navController = navController, screenPadding = screenPadding)
            }
            composable(NavScreens.Tickets.route) {
                TicketsScreen(navController = navController, screenPadding = screenPadding)
            }
        }
    }

}


sealed class NavScreens(val route: String) {
    object Booking : NavScreens("booking")
    object Tickets : NavScreens("tickets")
    object Home : NavScreens("home")
}

@Preview
@Composable
fun PreviewNavigation() {
    Navigation(rememberNavController())
}