package com.example.mymovies.ui.screens.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.mymovies.R
import com.example.mymovies.model.MediaItem
import com.example.mymovies.model.MediaItemListProvider

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MediaList(modifier: Modifier = Modifier, onClick: (MediaItem) -> Unit) {
    LazyVerticalGrid(
        contentPadding = PaddingValues(dimensionResource(id = R.dimen.padding_xsmall)),
        cells = GridCells.Adaptive(dimensionResource(id = R.dimen.cell_min_width)),
        modifier = modifier
    ) {
        items(MediaItemListProvider.getMediaItems()) { mediaItem ->
            MediaListItem(
                item = mediaItem,
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium))
            ) {
                onClick.invoke(it)
            }
        }
    }
}
