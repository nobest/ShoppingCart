package com.meticulous.shoppingcart.datastructure

import java.util.Date

interface Item {
    fun getItemName(): String
    fun getItemPrice(): Double
    fun getItemDate(): Date
    fun getItemImageUrl(): String
}