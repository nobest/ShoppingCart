package com.meticulous.shoppingcart.ui.main

import com.meticulous.shoppingcart.datastructure.CartItemImpl
import com.meticulous.shoppingcart.datastructure.ItemImpl
import org.junit.Test
import java.util.Date


internal class MainViewModelTest {

    val item1 = CartItemImpl(
        ItemImpl("Mapple Center", 50.00, Date(1644487200000), ""),
        2
    )
    val item2 = CartItemImpl(
        ItemImpl("WWE Arena", 100.00, Date(1653469200000), ""),
        2
    )
    val item3 = CartItemImpl(
        ItemImpl("Music Concert", 30.00, Date(1687298400000), ""),
        4
    )

    @Test
    fun subTotalPriceExtractorShouldReturn100Given2ItemsOf50() {

    }
}