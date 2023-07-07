//package com.example.cinematicketstask.screens.tickits_screen.composables
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color.Companion.DarkGray
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.example.cinematicketstask.screens.tickits_screen.model.SeatsState
//import com.example.cinematicketstask.screens.utile.Space
//import com.example.cinematicketstask.ui.theme.Poppins
//import com.example.cinematicketstask.ui.theme.PrimaryColor
//import com.example.cinematicketstask.ui.theme.White
//import com.example.cinematicketstask.ui.theme.White60
//
//
//@Composable
//fun SelectedRadioItem(
//    seatsState: SeatsState
//) {
//    val name = when (seatsState) {
//        SeatsState.Available -> "Available"
//        SeatsState.Taken -> "Taken"
//        SeatsState.Selected -> "Selected"
//    }
//    val color = when (seatsState) {
//        SeatsState.Available -> White
//        SeatsState.Taken -> DarkGray
//        SeatsState.Selected -> PrimaryColor
//    }
//
//    Row(verticalAlignment = Alignment.CenterVertically) {
//        Box(
//            modifier = Modifier
//                .size(12.dp)
//                .clip(CircleShape)
//                .background(color)
//        )
//        Space(space = 8.dp)
//        Text(
//            text = name,
//            fontFamily = Poppins,
//            fontWeight = FontWeight.Normal,
//            color = White60,
//            fontSize = 14.sp
//        )
//    }
//}