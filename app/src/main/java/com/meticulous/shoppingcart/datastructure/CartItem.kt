package com.meticulous.shoppingcart.datastructure

interface CartItem {
    fun getName(): String
    fun getPrice(): Double
    fun getDateTime(): String
    fun getQuantity(): Int
    fun incrementQuantity()
    fun decrementQuantity()
    fun updateQuantity(quantity: Int)
}