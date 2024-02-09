package com.tmdsimple.myloginapp



sealed class Screen(val route:String) {

    object LoginScreen:Screen("loginscreen")
    object MainScreen:Screen("mainscreen")

}