package com.example.miniecommerce.view

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.miniecommerce.R
import com.example.miniecommerce.model.DBHelper
import com.example.miniecommerce.model.Product

class CartActivity : AppCompatActivity() {

    private lateinit var recycler: RecyclerView
    private lateinit var txtTotal: TextView
    private lateinit var btnCheckout: Button
    private lateinit var db: DBHelper
    private var cartList = mutableListOf<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        recycler = findViewById(R.id.recyclerCart)
        txtTotal = findViewById(R.id.txtTotal)
        btnCheckout = findViewById(R.id.btnCheckout)

        db = DBHelper(this)

        loadCart()

        btnCheckout.setOnClickListener {
            Toast.makeText(this, "Checkout successful ✅", Toast.LENGTH_SHORT).show()
            // Optionally: clear cart from SQLite
            cartList.clear()
            recycler.adapter?.notifyDataSetChanged()
            updateTotal()
        }
    }

    private fun loadCart() {
        val cursor = db.readableDatabase.rawQuery("SELECT * FROM cart", null)
        cartList.clear()

        if (cursor.moveToFirst()) {
            do {
                val product = Product(
                    id = cursor.getInt(cursor.getColumnIndexOrThrow("id")),
                    title = cursor.getString(cursor.getColumnIndexOrThrow("title")),
                    price = cursor.getDouble(cursor.getColumnIndexOrThrow("price")),
                    image = cursor.getString(cursor.getColumnIndexOrThrow("image")),
                    description = "" // optional
                )
                cartList.add(product)
            } while (cursor.moveToNext())
        }
        cursor.close()

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = CartAdapter(cartList)
        updateTotal()
    }

    private fun updateTotal() {
        val total = cartList.sumOf { it.price }
        txtTotal.text = "Total: $${String.format("%.2f", total)}"
    }
}
