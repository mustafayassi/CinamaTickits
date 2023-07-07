package com.example.cinematicketstask.screens.home.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinematicketstask.R
import com.example.cinematicketstask.screens.utile.Space
import com.example.cinematicketstask.ui.theme.Black
import com.example.cinematicketstask.ui.theme.Poppins
import com.example.cinematicketstask.ui.theme.PrimaryColor
import com.example.cinematicketstask.ui.theme.White


@Composable
fun CustomBottomNav(
    onNavigateToBuyTicketsScreen: () -> Unit
) {
    BottomNavigation(
        backgroundColor = Color.Transparent,
        elevation = 0.dp,
        modifier = Modifier.padding(bottom = 4.dp)
    ) {
        NavigationItem(painter = painterResource(id = R.drawable.ic_cinama), isSelected = true)
        NavigationItem(painter = painterResource(id = R.drawable.ic_search))
        NavigationItem(
            painter = painterResource(id = R.drawable.ic_ticket),
            onClick = onNavigateToBuyTicketsScreen,
        ) { Badge(count = 5) }
        NavigationItem(painter = painterResource(id = R.drawable.ic_user))
    }
}

@Composable
private fun RowScope.NavigationItem(
    painter: Painter,
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
    onClick: () -> Unit = {},
    moreContent: (@Composable () -> Unit)? = null,
) {
    BottomNavigationItem(
        selected = isSelected,
        onClick = { onClick() },
        icon = {
            Row(
                modifier = modifier
                    .size(52.dp)
                    .clip(if (isSelected) CircleShape else RoundedCornerShape(0.dp))
                    .background(if (isSelected) PrimaryColor else Color.Transparent),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ) {
                Icon(
                    painter = painter,
                    contentDescription = "",
                    tint = if (isSelected) White else Black
                )
                moreContent?.let {
                    Space(space = 4.dp)
                    it()
                }
            }

        },
    )
}

@Composable
private fun Badge(
    count: Int,
    modifier: Modifier = Modifier
) {
    Text(
        text = count.toString(),
        textAlign = TextAlign.Center,
        fontFamily = Poppins,
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal,
        color = White,
        modifier = modifier
            .size(18.dp)
            .clip(CircleShape)
            .background(PrimaryColor),
    )
}