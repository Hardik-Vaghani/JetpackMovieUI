package com.hardik.movieui.core.route

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hardik.movieui.module.detail.presentation.DetailScreen
import com.hardik.movieui.module.home.model.nowPlayingMovie
import com.hardik.movieui.module.home.presentation.HomeScreen
import com.hardik.movieui.module.seat_selector.presentation.SeatSelectorScreen

object AppRoute {
    @Composable
    fun GenerateRoute(navController: NavHostController) {
        NavHost(
            navController = navController,
            startDestination = AppRoutName.Home
        )
        {
            composable(AppRoutName.Home) {
                HomeScreen(navController = navController)
            }
            composable("${AppRoutName.Detail}/{id}") { backStackEntry ->
                val id = backStackEntry.arguments?.getString("id")
                val movie = nowPlayingMovie.first{ it.id == id }
                DetailScreen(navController = navController, movie = movie)
            }
            composable(AppRoutName.SeatSelector) {
                SeatSelectorScreen(navController = navController)
            }

        }
    }
}