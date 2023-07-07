package com.example.cinematicketstask.screens.details_screen

import com.example.cinematicketstask.R


data class BookingUiState(
    val time: String = "2h 23 AM",
    val rateOfTenIMDp: Float = 6.8f,
    val rateOfTenIGN: Float = 4.0f,
    val rottenTomatoes: Int = 63,
    val title: String = "Fantastic Beasts: The \nSecrets of Dumbledore",

    val images: List<Int> = listOf(
        R.drawable.details_image,
        R.drawable.poster_1,
        R.drawable.image_6,
        R.drawable.image_2,
        R.drawable.img_3,
        R.drawable.image_2,
        R.drawable.details_image,
        R.drawable.image_6,
    ),
    val overview: String = "Professor Albus Dumbledore knows the powerful," +
            "dark wizard Gellert Grindelwald is moving to seize" +
            "control of the wizarding world. Unable to stop him...",
)