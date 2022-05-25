package com.meticulous.shoppingcart.datastructure

import java.util.Date

data class ItemImpl(
    private val name: String,
    private val price: Double,
    private val date: Date,
) : Item {
    override fun getItemName() = name

    override fun getItemPrice() = price

    override fun getItemDate() = date
}