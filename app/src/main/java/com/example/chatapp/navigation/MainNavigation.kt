package com.example.chatapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.chatapp.screens.ChatScreen
import com.example.chatapp.screens.HomeScreen
import com.example.chatapp.screens.StartScreen

@Composable
fun MainNavigation(modifier: Modifier = Modifier) {
    val navHostController = rememberNavController()
    NavHost(navController = navHostController, startDestination = Start) {
        composable(Start) {
            StartScreen(navHostController)
        }
        composable(Home) {
            HomeScreen(navHostController)
        }
        composable(Chat1) {
            ChatScreen(navHostController)
        }
    }
}

const val Start = "start_screen"
const val Home = "home_screen"
const val Chat1 = "chat_screen"
