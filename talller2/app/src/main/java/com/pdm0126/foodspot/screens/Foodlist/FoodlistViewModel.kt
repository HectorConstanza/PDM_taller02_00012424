package com.pdm0126.foodspot.screens.Foodlist


import androidx.lifecycle.ViewModel
import com.pdm0126.foodspot.data.FoodRepository
import com.pdm0126.foodspot.model.Restaurant
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class RestaurantListUiState(
    val groupedRestaurants: Map<String, List<Restaurant>> = emptyMap()
)

class FoodlistViewModel(
    private val repository: FoodRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(RestaurantListUiState())
    val uiState: StateFlow<RestaurantListUiState> = _uiState.asStateFlow()

    init { loadRestaurants() }

    private fun loadRestaurants() {
        val restaurants = repository.getRestaurants()

        // Agrupación dinámica — las categorías nacen de los datos, no de una lista fija
        val grouped = linkedMapOf<String, MutableList<Restaurant>>()
        restaurants.forEach { restaurant ->
            restaurant.categories.forEach { category ->
                grouped.getOrPut(category) { mutableListOf() }.add(restaurant)
            }
        }
        _uiState.value = RestaurantListUiState(groupedRestaurants = grouped)
    }
}