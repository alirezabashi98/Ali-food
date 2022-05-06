package com.alirezabashi98.alifood.navigation

sealed class Screen(val route:String){
    object splash : Screen(route = "splash_screen")
    object home : Screen(route = "home_screen")
    object order : Screen(route = "order_screen")
}
