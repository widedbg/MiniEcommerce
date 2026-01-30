package com.example.miniecommerce.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.miniecommerce.R
import com.example.miniecommerce.model.Product
import com.example.miniecommerce.presenter.ProductPresenter
import com.example.miniecommerce.presenter.ProductView

class MainActivity : AppCompatActivity(), ProductView {

    private lateinit var presenter: ProductPresenter
    private lateinit var recycler: RecyclerView
    private lateinit var btnCart: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler = findViewById(R.id.recyclerProducts)
        recycler.layoutManager = LinearLayoutManager(this)

        btnCart = findViewById(R.id.btnCart)
        btnCart.setOnClickListener {
            startActivity(Intent(this, CartActivity::class.java))
        }

        presenter = ProductPresenter(this)
        presenter.loadProducts()
    }

    override fun showProducts(products: List<Product>) {
        recycler.adapter = ProductAdapter(products)
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
