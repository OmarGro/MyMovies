package com.example.mymovies.ui.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayCircleOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.mymovies.R
import com.example.mymovies.model.MediaItem


@Composable
fun MediaListItem(item: MediaItem, modifier: Modifier = Modifier, onClick: (MediaItem) -> Unit) {
    Column(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .height(dimensionResource(id = R.dimen.cell_thumb_height))
                .fillMaxWidth()
                .clickable {
                    onClick.invoke(item)
                },
            contentAlignment = Alignment.Center,
        ) {
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
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.secondary)
                .padding(dimensionResource(id = R.dimen.padding_medium))
        ) {
            Text(
                text = item.title,
                style = MaterialTheme.typography.h6
            )
        }
    }
}