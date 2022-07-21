package com.nbs.moviecompose.presentation.navigation

import com.nbs.moviecompose.R
import com.nbs.moviecompose.presentation.destinations.HomeScreenDestination
import com.nbs.moviecompose.presentation.destinations.SearchScreenDestination

sealed class MainBottomNavItem(val title : String, val icon : Int, val route : String){
    object Home : MainBottomNavItem("Beranda", R.drawable.ic_home, HomeScreenDestination.route)
    object Search: MainBottomNavItem("Search", R.drawable.ic_award, SearchScreenDestination.route)
}