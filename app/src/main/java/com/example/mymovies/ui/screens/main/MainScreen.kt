package com.example.mymovies.ui.screens.main

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MainScreen(context: Context)  {
    Scaffold(
        topBar = {
            MainAppBar(context = context)
        }
    ) { padding ->
        MediaList(modifier = Modifier.padding(padding)) {
            Toast.makeText(context, "${it.title} selected", Toast.LENGTH_LONG).show()
        }
    }
}