@file:Suppress("DEPRECATION")

package com.example.foodhub


data class Product(
    val name: String="",
    val price: Double=0.0,
    val imageLink : String="",
    val description : String="",
    val amount : Int =0,
    val sellerId: String="",
    val productId: String=""
)

