package com.pdm0126.foodspot.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pdm0126.foodspot.data.FoodRepositoryImpl
import com.pdm0126.foodspot.screens.Foodlist.FoodListScreen
import com.pdm0126.foodspot.screens.Foodlist.FoodlistViewModel
import com.pdm0126.foodspot.screens.FoodDetail.FoodDetailScreen
import com.pdm0126.foodspot.screens.FoodDetail.FoodDetailViewModel
import com.pdm0126.foodspot.screens.FoodSearch.FoodSearchScreen
import com.pdm0126.foodspot.screens.FoodSearch.FoodSearchViewModel


@SuppressLint("ViewModelConstructorInComposable")
@Composable
fun AppNavigation() {

    val navController = rememberNavController()
    val repository = FoodRepositoryImpl()   // ← una sola instancia para todos

    NavHost(
        navController = navController,
        startDestination = "food_list"
    ) {

        // ───── Pantalla 1 ─────────────────────────────
        composable("food_list") {
            FoodListScreen(
                viewModel = FoodlistViewModel(repository),
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
                navArgument("restaurantId") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val restaurantId = backStackEntry.arguments?.getInt("restaurantId") ?: 0
            FoodDetailScreen(
                viewModel = FoodDetailViewModel(restaurantId),
                onBackClick = { navController.popBackStack() }
            )
        }

        // ───── Pantalla 3 ─────────────────────────────
        composable("search") {
            FoodSearchScreen(
                viewModel = FoodSearchViewModel(repository),
                onRestaurantClick = { restaurantId ->
                    navController.navigate("restaurant_detail/$restaurantId")
                },
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}