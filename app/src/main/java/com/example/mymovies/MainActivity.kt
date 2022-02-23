package com.example.mymovies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckBoxOutlineBlank
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.PlayCircleOutline
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.mymovies.ui.theme.MyMoviesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyMoviesTheme {
                MediaList()
            }
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MediaList() {
    LazyVerticalGrid(
        contentPadding = PaddingValues(2.dp),
        cells = GridCells.Adaptive(150.dp)
    ) {
        items(getMediaItems()) { item ->
            MediaListItem(item, Modifier.padding(2.dp))
        }
    }
}

@Composable
fun MediaListItem(item: MediaItem, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ){
        Box(
            modifier = Modifier
                .height(150.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center,
        ){
            Image(
                painter = rememberImagePainter(
                    data = item.thumb,
                ),
                modifier = Modifier.fillMaxSize(),
                contentDescription = "Image from the service",
                contentScale = ContentScale.Crop
            )
            if(item.type == MediaItem.Type.VIDEO) {
                Icon(
                    imageVector = Icons.Default.PlayCircleOutline,
                    contentDescription = "Play button",
                    modifier = Modifier.size(92.dp),
                    tint = Color.White
                )
            }
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.secondary)
                .padding(16.dp)
        ) {
            Text(
                text = item.title,
                style = MaterialTheme.typography.h6
            )
        }
    }
}