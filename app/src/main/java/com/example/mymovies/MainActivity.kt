package com.example.mymovies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import com.example.mymovies.ui.screens.main.MainScreen
import com.example.mymovies.ui.theme.MyMoviesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyMoviesApp {
                MainScreen(context = this)
            }
        }
    }
}

@Composable
fun MyMoviesApp(content: @Composable () -> Unit) {
    MyMoviesTheme {
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}