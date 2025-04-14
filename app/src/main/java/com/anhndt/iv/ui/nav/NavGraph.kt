package com.anhndt.iv.ui.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.google.gson.Gson
import postDetailScreen
import postListScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = RouteName.PostList.route) {
        postListScreen(onItemClick = { post ->
            val jsonData = Gson().toJson(post)
            navController.navigate("post_detail/${jsonData}")
        })
        postDetailScreen {
            navController.popBackStack()
        }
    }
}