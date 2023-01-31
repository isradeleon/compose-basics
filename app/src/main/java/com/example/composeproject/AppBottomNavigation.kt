package com.example.composeproject

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun AppBottomNavigation(
    navController: NavController
) {
    val navItems = listOf(
        NavItem.Home, NavItem.Favs,
        NavItem.Feed, NavItem.Profile
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    BottomNavigation(
        backgroundColor = Color.LightGray
    ) {
        navItems.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painter = painterResource(id = item.icon), contentDescription = item.navRoute) },
                selected = currentRoute == item.navRoute,
                label = { Text(text = stringResource(id = item.title)) },
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Black.copy(0.4f),
                onClick = {
                    navController.navigate(item.navRoute)
                }
            )
        }
    }
}