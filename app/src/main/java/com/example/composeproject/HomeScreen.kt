package com.example.composeproject

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController?) {
    val task = "Random task to do..."
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Go to task screen...", modifier = Modifier.clickable {
            navController?.navigate("task?item=$task")
        })
    }
}