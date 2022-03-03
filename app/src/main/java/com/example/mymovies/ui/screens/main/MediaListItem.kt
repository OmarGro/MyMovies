package com.example.mymovies.ui.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.mymovies.R
import com.example.mymovies.model.MediaItem
import com.example.mymovies.ui.screens.common.Thumb


@Composable
fun MediaListItem(item: MediaItem, modifier: Modifier = Modifier, onClick: (MediaItem) -> Unit) {
    Card(
        modifier = modifier,
        elevation = 8.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column {
            Box(
                modifier = Modifier
                    .height(dimensionResource(id = R.dimen.cell_thumb_height))
                    .fillMaxWidth()
                    .clickable {
                        onClick.invoke(item)
                    },
                contentAlignment = Alignment.Center,
            ) {
                Thumb(item = item)
            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colors.primary)
                    .padding(dimensionResource(id = R.dimen.padding_medium))
            ) {
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.h6,
                    color = Color.LightGray
                )
            }
        }
    }
}