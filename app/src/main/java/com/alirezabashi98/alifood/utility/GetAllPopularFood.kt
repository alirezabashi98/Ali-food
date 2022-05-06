package com.alirezabashi98.alifood.utility

import com.alirezabashi98.alifood.R
import com.alirezabashi98.alifood.model.FoodModel
import com.alirezabashi98.alifood.navigation.Screen

fun getAllPopularFood():List<FoodModel> = listOf(
    FoodModel(
        name = "Double Layer Burger",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Et, interdum leo, urna amet.",
        image = R.drawable.ic_1,
        route = Screen.order.route
    ),
    FoodModel(
        name = "Double Layer Burger",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Et, interdum leo, urna amet.",
        image = R.drawable.ic_2,
        route = Screen.order.route
    ),
    FoodModel(
        name = "Double Layer Burger",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Et, interdum leo, urna amet.",
        image = R.drawable.ic_3,
        route = Screen.order.route
    ),
    FoodModel(
        name = "Double Layer Burger",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Et, interdum leo, urna amet.",
        image = R.drawable.ic_4,
        route = Screen.order.route
    ),
)