package com.example.mymovies.ui.screens.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.mymovies.model.MediaItemListProvider
import com.example.mymovies.ui.screens.common.Thumb

@Composable
fun DetailScreen(mediaId: Int) {
    val mediaItem = remember { MediaItemListProvider.getMediaItems().first { it.id == mediaId }}

    Scaffold(
        topBar = { TopAppBar( title = { Text(text = mediaItem.title)})}
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Thumb(item = mediaItem)
        }
    }
}