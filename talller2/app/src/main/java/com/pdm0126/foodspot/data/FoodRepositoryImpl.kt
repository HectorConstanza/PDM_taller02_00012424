package com.pdm0126.foodspot.data

import com.pdm0126.foodspot.model.Dish
import com.pdm0126.foodspot.model.Restaurant

class FoodRepositoryImpl : FoodRepository {

    private val restaurants = listOf(
        Restaurant(
            id = 1,
            name = "Burger House",
            description = "Las hamburguesas más jugosas de la ciudad, hechas con carne 100% de res.",
            imageUrl = "https://images.unsplash.com/photo-1568901346375-23c9450c58cd?w=800",
            categories = listOf("Comida Rápida"),
            menu = listOf(
                Dish(1, "Classic Burger", "Carne de res, lechuga, tomate y mayonesa casera",
                    "https://images.unsplash.com/photo-1572802419224-296b0aeee0d9?w=600"),
                Dish(2, "BBQ Bacon Burger", "Carne doble, tocino crujiente y salsa BBQ ahumada",
                    "https://images.unsplash.com/photo-1553979459-d2229ba7433b?w=600"),
                Dish(3, "Veggie Burger", "Hamburguesa de garbanzos con aguacate y pico de gallo",
                    "https://images.unsplash.com/photo-1520072959219-c595dc870360?w=600")
            )
        ),
        Restaurant(
            id = 2,
            name = "Pollo Loco",
            description = "Pollo a la parrilla marinado con especias secretas de la abuela.",
            imageUrl = "https://images.unsplash.com/photo-1598514982901-ae62764ae75e?w=800",
            categories = listOf("Comida Rápida"),
            menu = listOf(
                Dish(4, "Pollo a la Parrilla", "Pechuga entera marinada con hierbas frescas",
                    "https://images.unsplash.com/photo-1607532941433-304659e8198a?w=600"),
                Dish(5, "Alitas BBQ", "Alitas crujientes bañadas en salsa BBQ casera",
                    "https://images.unsplash.com/photo-1567620832903-9fc6debc209f?w=600"),
                Dish(6, "Combo Familiar", "1 pollo entero + 4 acompañamientos a elegir",
                    "https://images.unsplash.com/photo-1632778149955-e80f8ceca2e8?w=600")
            )
        ),
        Restaurant(
            id = 3,
            name = "Tacos Mex",
            description = "Auténticos tacos mexicanos preparados con recetas tradicionales de Oaxaca.",
            imageUrl = "https://images.unsplash.com/photo-1565299585323-38d6b0865b47?w=800",
            categories = listOf("Comida Rápida", "Mexicana"),
            menu = listOf(
                Dish(7, "Taco al Pastor", "Carne de cerdo adobada con piña y cilantro",
                    "https://images.unsplash.com/photo-1551504734-5ee1c4a1479b?w=600"),
                Dish(8, "Taco de Birria", "Carne de res estofada con consomé para dippear",
                    "https://images.unsplash.com/photo-1624300629298-e9de39c13be5?w=600"),
                Dish(9, "Quesadilla de Rajas", "Tortilla con queso y rajas de chile poblano",
                    "https://images.unsplash.com/photo-1615870216519-2f9fa575fa5c?w=600")
            )
        ),
        Restaurant(
            id = 4,
            name = "Pizza Place",
            description = "Las mejores pizzas artesanales de la ciudad, con ingredientes frescos e importados.",
            imageUrl = "https://images.unsplash.com/photo-1611915365928-565c527a0590?w=800",
            categories = listOf("Italiana", "Pizzas"),
            menu = listOf(
                Dish(10, "Pizza Margarita", "Mozzarella fresca, albahaca y salsa de tomate casera",
                    "https://images.unsplash.com/photo-1565299624946-b28f40a0ae38?w=600"),
                Dish(11, "Pizza Pepperoni", "Pepperoni, mozzarella y salsa picante opcional",
                    "https://images.unsplash.com/photo-1534308983496-4fabb1a015ee?w=600"),
                Dish(12, "Pizza Cuatro Quesos", "Mozzarella, parmesano, gorgonzola y ricotta",
                    "https://images.unsplash.com/photo-1513104890138-7c749659a591?w=600")
            )
        ),
        Restaurant(
            id = 5,
            name = "Bella Pasta",
            description = "Pasta fresca hecha a mano cada día con harinas italianas importadas.",
            imageUrl = "https://images.unsplash.com/photo-1555949258-eb67b1ef0ceb?w=800",
            categories = listOf("Italiana"),
            menu = listOf(
                Dish(13, "Spaghetti Carbonara", "Pasta con huevo, guanciale, pecorino y pimienta negra",
                    "https://images.unsplash.com/photo-1612874742237-6526221588e3?w=600"),
                Dish(14, "Fettuccine Alfredo", "Pasta con salsa cremosa de mantequilla y parmesano",
                    "https://images.unsplash.com/photo-1645112411341-6c4fd023882c?w=600"),
                Dish(15, "Lasaña Clásica", "Capas de pasta, carne boloñesa y bechamel gratinada",
                    "https://images.unsplash.com/photo-1574894709920-11b28e7367e3?w=600")
            )
        ),
        Restaurant(
            id = 6,
            name = "Sushi Bar",
            description = "Sushi fresco preparado por chefs japoneses con pescado traído diariamente.",
            imageUrl = "https://images.unsplash.com/photo-1579871494447-9811cf80d66c?w=800",
            categories = listOf("Asiática", "Japonesa"),
            menu = listOf(
                Dish(16, "Roll California", "Cangrejo, aguacate y pepino con semillas de ajonjolí",
                    "https://images.unsplash.com/photo-1617196034183-421b4040ed20?w=600"),
                Dish(17, "Salmon Nigiri", "Arroz de sushi con láminas de salmón fresco",
                    "https://images.unsplash.com/photo-1617196034199-be44ebb56f74?w=600"),
                Dish(18, "Ramen Tonkotsu", "Caldo de cerdo, chashu, huevo marinado y nori",
                    "https://images.unsplash.com/photo-1569718212165-3a8278d5f624?w=600")
            )
        ),
        Restaurant(
            id = 7,
            name = "Wok Express",
            description = "Cocina china al wok con sabores auténticos del sur de Asia.",
            imageUrl = "https://images.unsplash.com/photo-1563245372-f21724e3856d?w=800",
            categories = listOf("Asiática", "China"),
            menu = listOf(
                Dish(19, "Arroz Frito Especial", "Arroz con huevo, camarones, verduras y salsa de soya",
                    "https://images.unsplash.com/photo-1603133872878-684f208fb84b?w=600"),
                Dish(20, "Chow Mein de Pollo", "Fideos salteados con pollo y verduras crujientes",
                    "https://images.unsplash.com/photo-1585032226651-759b368d7246?w=600"),
                Dish(21, "Cerdo Agridulce", "Cerdo crujiente con salsa agridulce y pimientos",
                    "https://images.unsplash.com/photo-1525755662778-989d0524087e?w=600")
            )
        ),
        Restaurant(
            id = 8,
            name = "Green Bowl",
            description = "Bowls nutritivos y ensaladas frescas para un estilo de vida saludable.",
            imageUrl = "https://images.unsplash.com/photo-1512621776951-a57141f2eefd?w=800",
            categories = listOf("Saludable"),
            menu = listOf(
                Dish(22, "Buddha Bowl", "Quinoa, garbanzos, aguacate, zanahoria y tahini",
                    "https://images.unsplash.com/photo-1546069901-ba9599a7e63c?w=600"),
                Dish(23, "Ensalada César", "Lechuga romana, pollo a la parrilla y aderezo césar",
                    "https://images.unsplash.com/photo-1550304943-4f24f54ddde9?w=600"),
                Dish(24, "Wrap de Pavo", "Tortilla integral con pavo, espinaca y hummus",
                    "https://images.unsplash.com/photo-1517248135467-4c7edcad34c4?w=600")
            )
        ),
        Restaurant(
            id = 9,
            name = "Sweet Dreams",
            description = "Postres artesanales y pasteles de autor que hacen feliz a cualquiera.",
            imageUrl = "https://images.unsplash.com/photo-1578985545062-69928b1d9587?w=800",
            categories = listOf("Postres"),
            menu = listOf(
                Dish(25, "Cheesecake de Fresa", "Cheesecake cremoso con coulis de fresa fresca",
                    "https://images.unsplash.com/photo-1565958011703-44f9829ba187?w=600"),
                Dish(26, "Brownie con Helado", "Brownie tibio de chocolate con bola de vainilla",
                    "https://images.unsplash.com/photo-1606313564200-e75d5e30476c?w=600"),
                Dish(27, "Tiramisú Clásico", "Capas de bizcocho, mascarpone y café espresso",
                    "https://images.unsplash.com/photo-1571877227200-a0d98ea607e9?w=600")
            )
        ),
        Restaurant(
            id = 10,
            name = "Juice & Co",
            description = "Jugos naturales, smoothies y bebidas especiales preparadas al momento.",
            imageUrl = "https://images.unsplash.com/photo-1589733955941-5eeaf752f6dd?w=800",
            categories = listOf("Bebidas", "Saludable"),
            menu = listOf(
                Dish(28, "Smoothie Tropical", "Mango, piña, coco y leche de almendras",
                    "https://images.unsplash.com/photo-1553530666-ba11a7da3888?w=600"),
                Dish(29, "Jugo Verde Detox", "Espinaca, pepino, apio, manzana verde y jengibre",
                    "https://images.unsplash.com/photo-1610970881699-44a5587cabec?w=600"),
                Dish(30, "Limonada Menta", "Limonada natural con hojas de menta y endulzante natural",
                    "https://images.unsplash.com/photo-1523677011781-c91d1bbe2f9e?w=600")
            )
        ),
        Restaurant(
            id = 11,
            name = "La Trattoria",
            description = "Auténtica cocina del sur de Italia con recetas que pasan de generación en generación.",
            imageUrl = "https://images.unsplash.com/photo-1414235077428-338989a2e8c0?w=800",
            categories = listOf("Italiana"),
            menu = listOf(
                Dish(31, "Bruschetta al Pomodoro", "Pan tostado con tomate fresco, ajo y albahaca",
                    "https://images.unsplash.com/photo-1572695157366-5e585ab2b69f?w=600"),
                Dish(32, "Pollo alla Parmigiana", "Pollo empanizado cubierto con salsa de tomate y mozzarella",
                    "https://images.unsplash.com/photo-1632778149955-e80f8ceca2e8?w=600"),
                Dish(33, "Tiramisu della Nonna", "Receta original de la nonna con bizcochos savoiardi",
                    "https://images.unsplash.com/photo-1571877227200-a0d98ea607e9?w=600"),
                Dish(34, "Pizza Margarita", "Mozzarella fresca, albahaca y salsa de tomate casera",
                    "https://images.unsplash.com/photo-1565299624946-b28f40a0ae38?w=600"),
            )
        )
    )

    override fun getRestaurants(): List<Restaurant> = restaurants

    override fun getRestaurantById(id: Int): Restaurant? =
        restaurants.find { it.id == id }

    override fun searchRestaurants(query: String): List<Restaurant> {
        if (query.isBlank()) return emptyList()
        val q = query.trim().lowercase()
        return restaurants.filter { restaurant ->
            restaurant.name.lowercase().contains(q) ||
                    restaurant.menu.any { dish -> dish.name.lowercase().contains(q) }
        }
    }
}