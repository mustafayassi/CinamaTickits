package com.example.cinematicketstask.screens.tickits_screen.model


enum class SeatsState {
    Available,
    Taken,
    Selected
}

fun SeatsState.nextState(): SeatsState{
    return when(this){
        SeatsState.Available -> SeatsState.Taken
        SeatsState.Taken -> SeatsState.Selected
        SeatsState.Selected -> SeatsState.Available
    }
}