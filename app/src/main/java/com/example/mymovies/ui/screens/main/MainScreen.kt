package com.example.mymovies.ui.screens.main

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.mymovies.model.MediaItem

@Composable
fun MainScreen(context: Context, onClick: (MediaItem) -> Unit)  {
    Scaffold(
        topBar = {
            MainAppBar(context = context)
        }
    ) { padding ->
        MediaList(modifier = Modifier.padding(padding)) {
            onClick.invoke(it)
        }
    }
}