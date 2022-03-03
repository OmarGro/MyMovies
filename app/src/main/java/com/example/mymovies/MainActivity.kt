package com.example.mymovies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mymovies.ui.screens.detail.DetailScreen
import com.example.mymovies.ui.screens.main.MainScreen
import com.example.mymovies.ui.theme.MyMoviesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyMoviesApp {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "main") {
                    composable("main") {
                        MainScreen(context = this@MainActivity) {
                            navController.navigate("detail/${it.id}")
                        }
                    }
                    composable(
                        route = "detail/{mediaId}",
                        arguments = listOf(navArgument("mediaId") { type = NavType.IntType })
                    ) { backStackEntry ->
                        val id = backStackEntry.arguments?.getInt("mediaId")
                        requireNotNull(id)
                        DetailScreen(id)
                    }
                }
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