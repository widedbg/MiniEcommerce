package com.example.miniecommerce.model

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.content.ContentValues

class DBHelper(context: Context) :
    SQLiteOpenHelper(context, "cart.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("""
            CREATE TABLE cart(
                id INTEGER PRIMARY KEY,
                title TEXT,
                price REAL,
                image TEXT
            )
        """)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS cart")
        onCreate(db)
    }

    fun addToCart(product: Product) {
        val values = ContentValues().apply {
            put("id", product.id)
            put("title", product.title)
            put("price", product.price)
            put("image", product.image)
        }
        writableDatabase.insert("cart", null, values)
    }
}
