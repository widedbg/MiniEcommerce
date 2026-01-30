package com.example.miniecommerce.presenter

import com.example.miniecommerce.model.Product
import com.example.miniecommerce.model.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductPresenter(private val view: ProductView) {

    fun loadProducts() {
        RetrofitClient.api.getProducts().enqueue(object :
            Callback<List<Product>> {
            override fun onResponse(
                call: Call<List<Product>>,
                response: Response<List<Product>>
            ) {
                view.showProducts(response.body() ?: emptyList())
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                view.showError("Failed to load products")
            }
        })
    }
}
