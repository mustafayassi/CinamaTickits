package com.example.cinematicketstask.screens.tickits_screen

data class TicketsUiState(

    val ticketsCount: Int = 5,
    val days: List<Days> = listOf(
        Days(14, "Thu"),
        Days(15, "Fri"),
        Days(16, "Sat"),
        Days(17, "Sun"),
        Days(18, "Mon"),
        Days(19, "Tue"),
        Days(20, "Tue"),
        Days(21, "Tue"),
        Days(22, "Tue"),
        ),

    val selectedDay: Days = Days(20, "Sun"),
    val selectedTime: String = "10:00",
    val price: Double = 100.00,

    val dataList: List<String> = listOf(
        "11:00 Am",
        "12:30 AM",
        "16:30 Am",
        "18:00 AM",
        "18:30 PM",
        "20:00 Pm",
        "22:00 Pm",
    )
)

data class Days(
    val dayNumber: Int,
    val dayName: String
    )