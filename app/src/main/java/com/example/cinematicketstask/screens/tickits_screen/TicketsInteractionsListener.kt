package com.example.cinematicketstask.screens.tickits_screen


interface TicketsInteractionsListener {
    fun onClickBackIcon()
    fun onClickBuy()
    fun doWhenSelectDay(day: Days)
    fun doWhenSelectHour(hour: String)
}