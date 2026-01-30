package com.example.miniecommerce.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.miniecommerce.R
import com.example.miniecommerce.model.Product

class CartAdapter(private val cartList: List<Product>) :
    RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    inner class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img: ImageView = itemView.findViewById(R.id.imgProduct)
        val title: TextView = itemView.findViewById(R.id.txtTitle)
        val price: TextView = itemView.findViewById(R.id.txtPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)
        return CartViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val product = cartList[position]
        holder.title.text = product.title
        holder.price.text = "$${product.price}"
        Glide.with(holder.itemView.context).load(product.image).into(holder.img)
    }

    override fun getItemCount() = cartList.size
}
