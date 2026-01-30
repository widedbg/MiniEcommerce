package com.example.miniecommerce.presenter

import com.example.miniecommerce.model.Product

interface ProductView {
    fun showProducts(products: List<Product>)
    fun showError(message: String)
}
