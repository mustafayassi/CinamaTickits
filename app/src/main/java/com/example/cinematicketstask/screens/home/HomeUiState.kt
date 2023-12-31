package com.example.cinematicketstask.screens.home

import com.example.cinematicketstask.R

data class HomeUiState(
    val nowShowingChip: ChipUiState = ChipUiState("Now Showing", true),
    val comingSoonChip: ChipUiState = ChipUiState("Coming Soon", false),
    val images: List<Int> = listOf(
        R.drawable.poster_1,
        R.drawable.img_3,
        R.drawable.image_6,
    ),
    val time: String = "2h 23m",
    val title: String = "Fantastic Beasts: The \nSecrets of Dumbledore",
    val genres: List<String> = listOf(
        "Fantasy",
        "Adventure",
    ),
) {
    data class ChipUiState(
        val title: String,
        val isSelected: Boolean = false
    )
}