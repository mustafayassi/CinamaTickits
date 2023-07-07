package com.example.cinematicketstask.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinematicketstask.R
import com.example.cinematicketstask.screens.utile.Space
import com.example.cinematicketstask.ui.theme.Gray

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BackgroundBlurredCard(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = MaterialTheme.shapes.extraLarge,
    content: @Composable () -> Unit
) {
    Card(
        onClick = { onClick() },
        modifier = Modifier,
        elevation = CardDefaults.elevatedCardElevation(0.dp),
        shape = shape,
        colors = CardDefaults.cardColors(
            containerColor = Gray
        ),
    ) {
        Box(
            modifier = modifier
                .wrapContentWidth()
                .wrapContentHeight(), contentAlignment = Alignment.Center
        ) {
            content()
        }
    }
}

@Preview(showSystemUi = true, showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun BlurredCardPreview() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.poster_1),
            contentDescription = "",
            modifier = Modifier.fillMaxSize()
        )
        BackgroundBlurredCard(
            onClick = { },
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_paly),
                    contentDescription = null,
                    modifier = Modifier.size(16.dp)
                )
                Space(space = 4.dp)
                Text(text = "2h 23m")

            }
        }
    }
}
