package com.example.sydneyeats.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector

enum class Area {
    Inner,West,North,South
}

data class Restaurant(
    @StringRes val name: Int,
    @StringRes val description: Int,
    @DrawableRes val image: Int,
    val category: Area = Area.Inner,
)

enum class ContentType {
    LIST_ONLY, LIST_AND_DETAIL
}

enum class NavType {
    BOTTOM_NAVIGATION, NAVIGATION_RAIL, PERMANENT_NAVIGATION_DRAWER
}

data class NavigationItemContent(
    val category: Area,
    val icon: ImageVector,
    val text: String
)