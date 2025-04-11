package com.example.coincapapp.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Star

sealed class BottonNavigationItem (
    val route:String,
    val unselectedIcon: ImageVector,
    val selectedIcon: ImageVector,
    val title: String
){
    data object Home: BottonNavigationItem(
        route = "home",
        unselectedIcon =  Icons.Outlined.Home,
        selectedIcon = Icons.Filled.Home,
        title = "Home"
    )
    data object Favourites: BottonNavigationItem(
        route = "favourities",
        unselectedIcon =  Icons.Outlined.Star,
        selectedIcon = Icons.Filled.Star,
        title = "Favourities"
    )
    data object Settings: BottonNavigationItem(
        route = "settings",
        unselectedIcon =  Icons.Outlined.Settings,
        selectedIcon = Icons.Filled.Settings,
        title = "Settings"
    )
}