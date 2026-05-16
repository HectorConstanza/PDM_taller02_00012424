package com.pdm0126.foodspot.screens.FoodDetail
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.pdm0126.foodspot.model.Dish

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FoodDetailScreen(
    viewModel: FoodDetailViewModel,
    onBackClick: () -> Unit
) {

    val uiState by viewModel.uiState.collectAsState()
    val context = LocalContext.current

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Color(0xFFF8F8F8)
            ),

        topBar = {

            CenterAlignedTopAppBar(
                modifier = Modifier.statusBarsPadding(),

                title = {
                    Text(
                        text = "FoodSpot",
                        fontWeight = FontWeight.Bold
                    )
                },

                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Volver"
                        )
                    }
                },

                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.White
                )
            )
        }
    ) { paddingValues ->

        uiState.restaurant?.let { restaurant ->

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),

                contentPadding = PaddingValues(16.dp),

                verticalArrangement = Arrangement.spacedBy(18.dp)
            ) {

                item {

                    Card(
                        shape = RoundedCornerShape(24.dp),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 5.dp
                        )
                    ) {

                        Column {

                            Box {

                                AsyncImage(
                                    model = restaurant.imageUrl,
                                    contentDescription = restaurant.name,
                                    contentScale = ContentScale.Crop,

                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(230.dp)
                                )

                                Box(
                                    modifier = Modifier
                                        .matchParentSize()
                                        .background(
                                            Brush.verticalGradient(
                                                colors = listOf(
                                                    Color.Transparent,
                                                    Color.Black.copy(alpha = 0.5f)
                                                )
                                            )
                                        )
                                )

                                Text(
                                    text = restaurant.name,
                                    color = Color.White,
                                    style = MaterialTheme.typography.headlineSmall,
                                    fontWeight = FontWeight.Bold,

                                    modifier = Modifier
                                        .padding(16.dp)
                                        .align(androidx.compose.ui.Alignment.BottomStart)
                                )
                            }

                            Text(
                                text = restaurant.description,
                                style = MaterialTheme.typography.bodyMedium,

                                modifier = Modifier.padding(16.dp)
                            )
                        }
                    }
                }

                items(restaurant.menu) { dish ->

                    DishCard(
                        dish = dish,

                        onAddClick = {

                            Toast.makeText(
                                context,
                                "${dish.name} agregado al carrito",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun DishCard(
    dish: Dish,
    onAddClick: () -> Unit
) {

    Card(
        modifier = Modifier.fillMaxWidth(),

        shape = RoundedCornerShape(22.dp),

        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),

        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {

        Column {

            AsyncImage(
                model = dish.imageUrl,
                contentDescription = dish.name,
                contentScale = ContentScale.Crop,

                modifier = Modifier
                    .fillMaxWidth()
                    .height(190.dp)
                    .clip(
                        RoundedCornerShape(
                            topStart = 22.dp,
                            topEnd = 22.dp
                        )
                    )
            )

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(
                    text = dish.name,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = dish.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = onAddClick,

                    modifier = Modifier.fillMaxWidth(),

                    shape = RoundedCornerShape(14.dp),

                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFF6B35)
                    )
                ) {

                    Icon(
                        imageVector = Icons.Default.ShoppingCart,
                        contentDescription = null
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "Agregar al carrito",
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
        }
    }
}