package com.anhndt.iv.ui.nav

sealed class RouteName(val route: String) {
    object PostList : RouteName("post_list")
    object PostDetail : RouteName("post_detail/{item}")

}