package com.pdm0126.foodspot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.pdm0126.foodspot.ui.theme.FoodSpotTheme
import com.pdm0126.foodspot.data.FoodRepositoryImpl
import com.pdm0126.foodspot.screens.Foodlist.FoodListScreen
import com.pdm0126.foodspot.screens.Foodlist.FoodlistViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FoodSpotTheme {
                val repository = FoodRepositoryImpl()
                val viewModel = FoodlistViewModel(repository)

                FoodListScreen(
                    viewModel = viewModel,
                    onRestaurantClick = { },
                    onSearchClick = { }
                )
            }
        }
    }
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FoodSpotTheme {
        Greeting("Android")
    }
}