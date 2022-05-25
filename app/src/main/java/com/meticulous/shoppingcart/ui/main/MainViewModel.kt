package com.meticulous.shoppingcart.ui.main

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.meticulous.shoppingcart.datastructure.CartItem
import com.meticulous.shoppingcart.datastructure.CartItemImpl
import com.meticulous.shoppingcart.datastructure.ItemImpl
import com.meticulous.shoppingcart.utils.CartUtil
import java.util.Date

class MainViewModel : ViewModel() {
    private val _cartItems: MutableLiveData<List<CartItem>> = MutableLiveData()
    val cartItems: LiveData<List<CartItem>> = _cartItems
    val subTotal: LiveData<Double> = cartItems.switchMap { CartUtil.subTotalPriceExtractor(it) }

    init {
        val item1 = CartItemImpl(
            ItemImpl("Mapple Center", 50.00, Date(1644487200000), "https://picsum.photos/200/300?grayscale"),
            2
        )
        val item2 = CartItemImpl(
            ItemImpl("WWE Arena", 100.00, Date(1653469200000), "https://picsum.photos/seed/picsum/200/300"),
            2
        )
        val item3 = CartItemImpl(
            ItemImpl("Music Concert", 30.00, Date(1687298400000), "https://picsum.photos/id/237/200/300"),
            4
        )
        _cartItems.postValue(arrayListOf(item1, item2, item3))
    }
}