package com.alirezabashi98.alifood.ui.screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.alirezabashi98.alifood.R
import com.alirezabashi98.alifood.ui.theme.*
import com.gowtham.ratingbar.RatingBar
import com.gowtham.ratingbar.RatingBarConfig
import com.gowtham.ratingbar.RatingBarStyle

@Composable
fun OrderScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White2),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        AppBar(navController = navController)
        Body()
    }
}


@Composable
private fun AppBar(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Icon(
            modifier = Modifier
                .size(24.dp)
                .align(Alignment.CenterStart)
                .clickable {
                    navController.popBackStack()
                },
            painter = painterResource(id = R.drawable.ic_chevron_left),
            contentDescription = "chevron_left"
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
private fun Body() {
    var rating: Float by remember { mutableStateOf(4f) }
    var numberSelectFood by remember {
        mutableStateOf(1)
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            painter = painterResource(id = R.drawable.ic_3),
            contentDescription = "Food"
        )
        Spacer(modifier = Modifier.height(20.dp))
        Image(
            painter = painterResource(id = R.drawable.ic_carosaltabs),
            contentDescription = "carosaltabs"
        )
        Spacer(modifier = Modifier.height(10.dp))
        Column(
            Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp))
                .background(White)
        ) {
            Spacer(modifier = Modifier.height(28.dp))
            Column(
                modifier = Modifier.padding(start = 25.dp)
            ) {
                Text(
                    style = TextStyle(
                        fontSize = 24.sp,
                        color = Text1,
                        fontWeight = FontWeight.Bold
                    ),
                    text = "Popular Items"
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    style = TextStyle(fontSize = 15.sp, color = Text2),
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quis scelerisque sit eu accumsan, egestas in tempus, elit tristique. Est leo convallis quisque."
                )
                Spacer(modifier = Modifier.height(10.dp))
                RatingBar(
                    value = rating,
                    config = RatingBarConfig()
                        .activeColor(Orange500)
                        .style(RatingBarStyle.HighLighted),
                    onValueChange = {
//                        rating = it
                    },
                    onRatingChanged = {
                        Log.d("TAG", "onRatingChanged: $it")
                    }
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "$${numberSelectFood * 10}",
                        style = TextStyle(
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold,
                            color = Text2,
                            textDecoration = TextDecoration.LineThrough
                        )
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "$${numberSelectFood * 10 / 2}",
                        style = TextStyle(
                            fontSize = 21.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Red
                        )
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_plus),
                        contentDescription = "add",
                        modifier = Modifier
                            .clickable {
                                numberSelectFood++
                            }
                            .size(34.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "$numberSelectFood",
                        style = TextStyle(
                            color = Orange,
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Image(
                        painter = painterResource(id = R.drawable.ic_minus),
                        contentDescription = "subtraction",
                        modifier = Modifier
                            .clickable {
                                if (numberSelectFood > 1)
                                    numberSelectFood--
                            }
                            .size(34.dp)
                    )
                }
                Spacer(modifier = Modifier.height(25.dp))
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp)
                        .height(43.dp)
                        .clip(RoundedCornerShape(50))
                ) {
                    Text(text = "Place Order")
                }
            }
        }
    }
}