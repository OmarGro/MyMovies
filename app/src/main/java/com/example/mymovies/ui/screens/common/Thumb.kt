package com.example.mymovies.ui.screens.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayCircleOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import coil.compose.rememberImagePainter
import com.example.mymovies.R
import com.example.mymovies.model.MediaItem

@Composable
fun Thumb(item: MediaItem) {
    Image(
        painter = rememberImagePainter(
            data = item.thumb,
        ),
        modifier = Modifier.fillMaxSize(),
        contentDescription = "Image from the service",
        contentScale = ContentScale.Crop
    )
    if (item.type == MediaItem.Type.VIDEO) {
        Icon(
            imageVector = Icons.Default.PlayCircleOutline,
            contentDescription = "Play button",
            modifier = Modifier
                .size(dimensionResource(id = R.dimen.cell_play_icon_size)),
            tint = Color.White,
        )
    }
}