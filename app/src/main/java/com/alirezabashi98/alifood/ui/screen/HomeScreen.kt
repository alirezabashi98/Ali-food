package com.alirezabashi98.alifood.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.alirezabashi98.alifood.R
import com.alirezabashi98.alifood.model.FoodModel
import com.alirezabashi98.alifood.ui.theme.Text1
import com.alirezabashi98.alifood.ui.theme.Text2
import com.alirezabashi98.alifood.ui.theme.White
import com.alirezabashi98.alifood.ui.theme.White2
import com.alirezabashi98.alifood.utility.getAllPopularFood

@ExperimentalFoundationApi
@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White2),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        AppBar()
        Carousel()
        PopularFoodList(navController = navController)
    }
}

@Composable
private fun AppBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Icon(
            modifier = Modifier
                .size(24.dp)
                .align(Alignment.CenterStart),
            painter = painterResource(id = R.drawable.ic_menu), contentDescription = "Menu"
        )
        Row(modifier = Modifier.align(Alignment.CenterEnd)) {
            Icon(
                modifier = Modifier.size(24.dp),
                painter = painterResource(id = R.drawable.ic_shopping_cart),
                contentDescription = "shopping"
            )
            Spacer(modifier = Modifier.width(40.dp))
            Icon(
                modifier = Modifier.size(24.dp),
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "search"
            )
        }
    }
}

@Composable
private fun Carousel() {
    Image(
        modifier = Modifier.padding(start = 20.dp, end = 10.dp),
        painter = painterResource(id = R.drawable.carousel),
        contentDescription = "carousel"
    )
}

@ExperimentalFoundationApi
@Composable
private fun PopularFoodList(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(text = "Popular Items", style = TextStyle(fontSize = 19.sp))

        var listPopularFood = getAllPopularFood();
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            contentPadding = PaddingValues(top = 8.dp, start = 7.5.dp, end = 7.dp, bottom = 7.5.dp)
        ) {
            items(listPopularFood.size) {
                ItemFood(food = listPopularFood[it], navController = navController)
            }
        }
    }
}

@Composable
private fun ItemFood(food: FoodModel, navController: NavController) {
    Spacer(modifier = Modifier.height(5.dp))

    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 8.dp, top = 8.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp)
                .background(White),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                modifier = Modifier
                    .size(100.dp),
                painter = painterResource(id = food.image),
                contentDescription = food.name
            )

            Text(
                text = food.name,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Text1
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = food.description,
                style = TextStyle(
                    fontSize = 13.sp,
                    color = Text2
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            Box(modifier = Modifier.fillMaxWidth()) {
                Button(
                    onClick = {
                        navController.navigate(food.route)
                    },
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .clip(RoundedCornerShape(50))
                ) {
                    Text(text = "Order Now")
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}







