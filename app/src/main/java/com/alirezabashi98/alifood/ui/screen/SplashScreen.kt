package com.alirezabashi98.alifood.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import com.alirezabashi98.alifood.navigation.Screen
import com.alirezabashi98.alifood.ui.theme.Orange
import com.alirezabashi98.alifood.ui.theme.Text2
import com.alirezabashi98.alifood.ui.theme.White
import com.alirezabashi98.alifood.ui.theme.White2

@Composable
fun SplashScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize().background(White2)) {
        Image(
            painter = painterResource(id = R.drawable.user),
            contentDescription = "user",
            modifier = Modifier
                .align(Alignment.TopCenter)
                .fillMaxWidth()
                .fillMaxHeight(0.6f)
        )
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(topEnd = 50.dp, topStart = 50.dp))
                .fillMaxWidth()
                .fillMaxHeight(0.45f)
                .background(White)
                .align(Alignment.BottomCenter)

        ) {
            Body(navController)
        }
    }
}

@Composable
private fun Body(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "#1",
                style = TextStyle(
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    color = Orange,
                    textDecoration = TextDecoration.Underline
                )
            )
            Text(
                text = "Worlds best Food \n Ordering app",
                style = MaterialTheme.typography.h1,
                textAlign = TextAlign.Center
            )
            Text(
                text = "We are awarded with best food \n ordering app world wide",
                style = MaterialTheme.typography.body1.copy(color = Text2),
                textAlign = TextAlign.Center
            )
        }
        Button(
            onClick = {
                navController.popBackStack()
                navController.navigate(Screen.home.route)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp)
                .height(43.dp)
                .clip(RoundedCornerShape(50))
        ) {
            Text(text = "Get Started Now")
        }
    }
}