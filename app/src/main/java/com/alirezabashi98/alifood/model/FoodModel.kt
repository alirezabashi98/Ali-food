package com.alirezabashi98.alifood.model

import androidx.annotation.DrawableRes

data class FoodModel(
    val name: String,
    val description: String,
    @DrawableRes val image: Int,
    val route : String
)
