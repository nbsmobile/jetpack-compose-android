package com.nbs.moviecompose.presentation.navigation

import com.nbs.moviecompose.R
import com.nbs.moviecompose.presentation.destinations.HomeScreenDestination
import com.nbs.moviecompose.presentation.destinations.AwardScreenDestination

sealed class MainBottomNavItem(val title : String, val icon : Int, val route : String){
    object Home : MainBottomNavItem("Beranda", R.drawable.ic_home, HomeScreenDestination.route)
    object Award: MainBottomNavItem("Award", R.drawable.ic_award, AwardScreenDestination.route)
}