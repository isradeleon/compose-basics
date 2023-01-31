package com.example.composeproject

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.composeproject.ui.theme.NAV_FAVS
import com.example.composeproject.ui.theme.NAV_FEED
import com.example.composeproject.ui.theme.NAV_HOME
import com.example.composeproject.ui.theme.NAV_PROFILE

@Composable
fun MainContentV2() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { AppBottomNavigation(navController = navController) }
    ) {
        NavHost(
            navController = navController, startDestination = NAV_HOME,
            modifier = Modifier.padding(it)
        ) {
            composable(NAV_HOME) { AppScreen(title = "Home screen") }
            composable(NAV_FEED) { AppScreen(title = "Feed screen") }
            composable(NAV_FAVS) { AppScreen(title = "Favs screen") }
            composable(NAV_PROFILE) { AppScreen(title = "Profile screen") }
        }
    }
}

@Composable
fun MainContent() {
    val navController = rememberNavController()
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        NavHost(navController = navController, startDestination = "home") {
            composable("home") { HomeScreen(navController = navController) }
            composable(
                "task?item={item}",
                arguments = listOf(
                    navArgument("item") {
                        type = NavType.StringType
//                        defaultValue = "No item specified."
                        nullable = true
                    }
                )
            ) {
                val item = it.arguments?.getString("item")
                TaskScreen(task = item ?: "", navController = navController)
            }
        }
    }
}

@Preview
@Composable
fun PreviewMainContent() {
    MainContent()
}