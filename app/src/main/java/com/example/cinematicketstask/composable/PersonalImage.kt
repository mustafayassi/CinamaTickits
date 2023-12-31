package com.example.cinematicketstask.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinematicketstask.R

@Composable
fun PersonalImage(
    painter: Painter,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    size: Int = 60
) {
    Image(
        painter = painter,
        contentDescription = "",
        modifier = modifier
            .size(size.dp)
            .clip(CircleShape)
            .clickable { onClick() },
        contentScale = ContentScale.Crop
    )
}

@Preview
@Composable
fun PersonalImagePreview() {
    PersonalImage(
        painter = painterResource(id = R.drawable.person_image),
        onClick = {}
    )
}