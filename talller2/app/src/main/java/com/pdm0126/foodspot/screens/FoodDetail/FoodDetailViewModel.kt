package com.pdm0126.foodspot.screens.FoodDetail

import androidx.lifecycle.ViewModel
import com.pdm0126.foodspot.data.FoodRepositoryImpl
import com.pdm0126.foodspot.model.Restaurant
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class RestaurantDetailUiState(
    val restaurant: Restaurant? = null
)

class FoodDetailViewModel(
    restaurantId: Int
) : ViewModel() {

    private val repository = FoodRepositoryImpl()

    private val _uiState = MutableStateFlow(RestaurantDetailUiState())
    val uiState: StateFlow<RestaurantDetailUiState> = _uiState.asStateFlow()

    init {
        _uiState.value = RestaurantDetailUiState(
            restaurant = repository.getRestaurantById(restaurantId)
        )
    }
}