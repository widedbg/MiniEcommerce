package com.example.miniecommerce.view

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.miniecommerce.R
import com.example.miniecommerce.model.DBHelper
import com.example.miniecommerce.model.Product

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val product = intent.getSerializableExtra("product") as? Product
        if (product == null) {
            Toast.makeText(this, "Product data missing", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        val img = findViewById<ImageView>(R.id.imgProduct)
        val title = findViewById<TextView>(R.id.txtTitle)
        val price = findViewById<TextView>(R.id.txtPrice)
        val desc = findViewById<TextView>(R.id.txtDescription)
        val btnAdd = findViewById<Button>(R.id.btnAddCart)

        Glide.with(this).load(product.image).into(img)
        title.text = product.title
        price.text = "$${product.price}"
        desc.text = product.description

        val db = DBHelper(this)
        btnAdd.setOnClickListener {
            db.addToCart(product)
            Toast.makeText(this, "Added to cart ✅", Toast.LENGTH_SHORT).show()
        }
    }
}
