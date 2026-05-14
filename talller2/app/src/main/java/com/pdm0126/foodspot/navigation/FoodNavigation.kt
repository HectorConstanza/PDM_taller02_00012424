package com.pdm0126.foodspot.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pdm0126.foodspot.data.FoodRepositoryImpl
import com.pdm0126.foodspot.screens.Foodlist.FoodListScreen
import com.pdm0126.foodspot.screens.Foodlist.FoodlistViewModel
import com.pdm0126.foodspot.screens.FoodDetail.FoodDetailScreen
import com.pdm0126.foodspot.screens.FoodDetail.FoodDetailViewModel


@SuppressLint("ViewModelConstructorInComposable")
@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "food_list"
    ) {

        // ───── Pantalla 1 ─────────────────────────────
        composable("food_list") {

            val viewModel = FoodlistViewModel(
                FoodRepositoryImpl()
            )

            FoodListScreen(
                viewModel = viewModel,

                onRestaurantClick = { restaurantId ->
                    navController.navigate("restaurant_detail/$restaurantId")
                },

                onSearchClick = {
                    navController.navigate("search")
                }
            )
        }

        // ───── Pantalla 2 ─────────────────────────────
        composable(
            route = "restaurant_detail/{restaurantId}",
            arguments = listOf(
                navArgument("restaurantId") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->

            val restaurantId =
                backStackEntry.arguments?.getInt("restaurantId") ?: 0

            val viewModel = FoodDetailViewModel(restaurantId)

            FoodDetailScreen(
                viewModel = viewModel,

                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        // ───── Pantalla 3 ─────────────────────────────

    }
}