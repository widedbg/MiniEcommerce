package com.example.miniecommerce.model

import java.io.Serializable

data class Product(
    val id: Int,
    val title: String,
    val price: Double,
    val image: String,
    val description: String
) : Serializable
