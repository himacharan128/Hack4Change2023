package com.example.farmlease

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.farmlease.schemas.LeaseItemType
import com.example.farmlease.userRelated.UserItemList

sealed class ScreenRoute(val route: String) {
    object Home : ScreenRoute(route = "home_screen")
    object ItemDetail : ScreenRoute(route = "detail_screen")
    object UserItem : ScreenRoute(route = "user_item")
    object AddItem : ScreenRoute(route = "add_item")
}

@Composable
fun SetupNavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = ScreenRoute.Home.route,
    ) {
        composable(route = ScreenRoute.Home.route) {
            FarmLeaseApp(navController)
        }
        composable(
            route = ScreenRoute.ItemDetail.route + "/{leaseItemId}",
            arguments = listOf(navArgument("leaseItemId") { type = NavType.IntType }),
            enterTransition = { fadeIn(tween(30)) },
            exitTransition = { fadeOut(tween(durationMillis = 30)) },
        ) {
            val leaseItemId = it.arguments!!.getInt("leaseItemId")
            LeaseItemDetails(leaseItemId = leaseItemId, {}, navController)
        }
        composable(
            route = ScreenRoute.UserItem.route + "/{leaseItemType}",
            arguments = listOf(navArgument("leaseItemType") { type = NavType.StringType })
        ) {
            val leaseItemType = it.arguments!!.getString("leaseItemType")
            UserItemList(
                leaseItemTypeStr = leaseItemType ?: LeaseItemType.LAND.name,
                navController = navController
            )
        }
        composable(
            route = ScreenRoute.AddItem.route + "/{leaseItemType}",
            arguments = listOf(navArgument("leaseItemType") { type = NavType.StringType })
        ) {
            val leaseItemType = it.arguments!!.getString("leaseItemType")
            AddLeaseItem(
                leaseItemTypeStr = leaseItemType ?: LeaseItemType.LAND.name,
                navController = navController
            )
        }
    }
}


