package com.example.coincapapp.views

import android.annotation.SuppressLint
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.coincapapp.navigation.BottonNavigationItem
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(){
    val navController= rememberNavController()
    Scaffold (bottomBar = {BottonTabBar(navController)}){
        NavigationGraph(navController)
    }
}

@Composable
fun NavigationGraph(navControler: NavHostController){
    NavHost(navControler, startDestination = BottonNavigationItem.Home.route) {
        composable (BottonNavigationItem.Home.route){ AssetsList() }
        composable (BottonNavigationItem.Favourites.route){ Favourities() }
        composable (BottonNavigationItem.Settings.route){ Settings() }
    }
}

@Composable
fun BottonTabBar(navController: NavHostController){
    val items = listOf(
        BottonNavigationItem.Home,
        BottonNavigationItem.Favourites,
        BottonNavigationItem.Settings
    )

    BottomAppBar {
        val navBackStack by navController.currentBackStackEntryAsState()
        val currentsRoute = navBackStack?.destination?.route

        items.forEach { barItem ->
            val selected = barItem.route == currentsRoute
            NavigationBarItem(
                selected = selected,
                label = {
                    Text(barItem.title)
                },
                onClick = {
                    navController.navigate(barItem.route){
                        navController.graph.startDestinationRoute.let { route ->
                            if(route != null){
                                popUpTo(route){
                                    saveState= true
                                }
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }, icon = {
                    Icon(
                        imageVector = if(selected) barItem.selectedIcon else barItem.unselectedIcon,
                        contentDescription = null
                    )
                }
            )
        }
    }
}