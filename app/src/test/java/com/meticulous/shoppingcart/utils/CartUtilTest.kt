package com.meticulous.shoppingcart.utils

import com.meticulous.shoppingcart.datastructure.CartItemImpl
import com.meticulous.shoppingcart.datastructure.ItemImpl
import junit.framework.Assert.assertEquals
import org.junit.Test
import java.util.Date


internal class CartUtilTest {

    val item1 = CartItemImpl(
        ItemImpl("Mapple Center", 50.00, Date(1644487200000), ""),
        2
    )
    val item2 = CartItemImpl(
        ItemImpl("WWE Arena", 100.00, Date(1653469200000), ""),
        1
    )
    val item3 = CartItemImpl(
        ItemImpl("Music Concert", 30.00, Date(1687298400000), ""),
        4
    )

    @Test
    fun subTotalPriceExtractorShouldReturn100Given2ItemsOf50() {
        val result = CartUtil.subTotalPriceExtractor(arrayListOf(item1)).value
        assertEquals(100.00, result)
    }

    @Test
    fun subTotalPriceExtractorShouldReturn200Given2ItemsOf50And1ItemOf100() {
        val result = CartUtil.subTotalPriceExtractor(arrayListOf(item1, item2)).value
        assertEquals(200.00, result)
    }

    @Test
    fun subTotalPriceExtractorShouldReturn320Given2ItemsOf501ItemOf100And4ItemsOf30() {
        val result = CartUtil.subTotalPriceExtractor(arrayListOf(item1, item2, item3)).value
        assertEquals(320.00, result)
    }
}