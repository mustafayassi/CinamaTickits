package com.example.cinematicketstask.screens.details_screen.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinematicketstask.R
import com.example.cinematicketstask.composable.BackgroundBlurredCard
import com.example.cinematicketstask.composable.BackIcon
import com.example.cinematicketstask.screens.utile.Space
import com.example.cinematicketstask.ui.theme.Poppins
import com.example.cinematicketstask.ui.theme.White
import com.example.cinematicketstask.ui.theme.White60


@Composable
fun DetailsScreenHeader(
    time: String,
    onClickBackIcon: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(top = 24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        BackIcon(onClickBackIcon)

        BackgroundBlurredCard(onClick = { /*TODO*/ }, modifier = Modifier) {
            Row(
                modifier = Modifier.padding(4.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_time),
                    contentDescription = "date",
                    tint = White60,
                    modifier = Modifier.size(24.dp),
                )
                Space(space = 4.dp)
                Text(
                    modifier = Modifier.padding(top = 4.dp),
                    text = time,
                    fontSize = 12.sp,
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Normal,
                    color = White
                )
            }
        }
    }
}

@Preview
@Composable
fun HeaderPreview() {
    DetailsScreenHeader(time = "21:00 AM") {

    }
}