package com.meticulous.shoppingcart.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.meticulous.shoppingcart.datastructure.CartItem

class CartUtil {
    companion object {
        fun subTotalPriceExtractor(cartItems: List<CartItem>): LiveData<Double> {
            val sum = cartItems.sumOf { it.getPrice() * it.getQuantity() }
            return MutableLiveData(sum)
        }
    }
}