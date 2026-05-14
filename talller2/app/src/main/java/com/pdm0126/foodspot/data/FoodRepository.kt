package com.pdm0126.foodspot.data

import com.pdm0126.foodspot.model.Restaurant

interface FoodRepository{
    fun getRestaurants(): List<Restaurant>
    fun getRestaurantById(id: Int): Restaurant?
    fun searchRestaurants(query: String): List<Restaurant>
}