package com.pdm0126.foodspot.screens.FoodSearch

import androidx.lifecycle.ViewModel
import com.pdm0126.foodspot.data.FoodRepository
import com.pdm0126.foodspot.model.Restaurant
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class SearchUiState(
    val query: String = "",
    val results: List<Restaurant> = emptyList(),
    val hasSearched: Boolean = false
)

class FoodSearchViewModel(
    private val repository: FoodRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(SearchUiState())
    val uiState: StateFlow<SearchUiState> = _uiState.asStateFlow()

    fun onQueryChange(newQuery: String) {
        val results = repository.searchRestaurants(newQuery)
        _uiState.value = SearchUiState(
            query = newQuery,
            results = results,
            hasSearched = newQuery.isNotBlank()
        )
    }
}