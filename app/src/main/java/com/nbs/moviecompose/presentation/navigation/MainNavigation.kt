package com.nbs.moviecompose.presentation.navigation

import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.nbs.moviecompose.composable.style.MovieComposeTheme
import com.nbs.moviecompose.presentation.main.HomeScreen
import com.nbs.moviecompose.presentation.NavGraphs
import com.nbs.moviecompose.presentation.main.AwardScreen
import com.nbs.moviecompose.presentation.destinations.HomeScreenDestination
import com.nbs.moviecompose.presentation.destinations.ProfileScreenDestination
import com.nbs.moviecompose.presentation.destinations.AwardScreenDestination
import com.nbs.moviecompose.presentation.main.ProfileScreen
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.manualcomposablecalls.composable
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
fun MainNavigationGraph(
    navigator: DestinationsNavigator,
    navController: NavHostController
) {
    DestinationsNavHost(navGraph = NavGraphs.root.copy(
        startRoute = HomeScreenDestination
    ), navController = navController) {
        composable(HomeScreenDestination) {
            HomeScreen(navigator)
        }
        composable(AwardScreenDestination) {
            AwardScreen(navigator)
        }
        composable(ProfileScreenDestination) {
            ProfileScreen(navigator)
        }
    }
}

@Composable
fun BottomNavigationMain(navController: NavController) {
    val items = listOf(
        MainBottomNavItem.Home,
        MainBottomNavItem.Award,
        MainBottomNavItem.Profile
    )
    BottomNavigation(
        backgroundColor = MovieComposeTheme.colors.colorPrimaryDark,
        contentColor = MovieComposeTheme.colors.colorTextPrimary
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEachIndexed { i, item ->
            if (i == 3) Spacer(modifier = Modifier.weight(0.8f, true))

            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                selectedContentColor = MovieComposeTheme.colors.colorAccent,
                unselectedContentColor = MovieComposeTheme.colors.colorTextPrimary,
                selected = currentRoute == item.route,
                alwaysShowLabel = true,
                onClick = {
                    navController.navigate(item.route)
                }
            )
        }
    }
}