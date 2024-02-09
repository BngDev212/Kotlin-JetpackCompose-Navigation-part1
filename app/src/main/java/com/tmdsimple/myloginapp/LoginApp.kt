package com.tmdsimple.myloginapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun LoginApp(navController:NavHostController){
     //
    NavHost(navController = navController, startDestination = Screen.LoginScreen.route) {
        composable(Screen.LoginScreen.route) {
            LoginScreen {
                navController.navigate(Screen.MainScreen.route)
            }
        }
        composable(route=Screen.MainScreen.route) {
            MainScreen {
                navController.navigate(Screen.LoginScreen.route)
            }
        }
    }
}