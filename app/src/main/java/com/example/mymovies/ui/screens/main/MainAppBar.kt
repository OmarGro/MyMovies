package com.example.mymovies.ui.screens.main

import android.content.Context
import android.widget.Toast
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.mymovies.R

@Composable
fun MainAppBar(context: Context) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.app_name)
            )
        },
        navigationIcon = {
            IconButton(onClick = {
                Toast.makeText(
                    context,
                    "menu clicked",
                    Toast.LENGTH_LONG
                ).show()
            }) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "")
            }
        },
        actions = {
            IconButton(onClick = {
                Toast.makeText(
                    context,
                    "search clicked",
                    Toast.LENGTH_LONG
                ).show()
            }) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "search"
                )
            }
            IconButton(onClick = {
                Toast.makeText(
                    context,
                    "share clicked",
                    Toast.LENGTH_LONG
                ).show()
            }) {
                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = "share"
                )
            }
        }
    )
}