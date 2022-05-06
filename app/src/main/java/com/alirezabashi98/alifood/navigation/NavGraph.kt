package com.alirezabashi98.alifood.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.alirezabashi98.alifood.ui.screen.HomeScreen
import com.alirezabashi98.alifood.ui.screen.OrderScreen
import com.alirezabashi98.alifood.ui.screen.SplashScreen

@ExperimentalFoundationApi
@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.splash.route) {
        composable(route = Screen.splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.home.route) {
            HomeScreen(navController = navController)
        }
        composable(route = Screen.order.route) {
            OrderScreen(navController = navController)
        }
    }
}