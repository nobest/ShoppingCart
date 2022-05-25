package com.meticulous.shoppingcart.datastructure

import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.junit.Test
import java.util.Date


internal class CartItemImplTest {
    private val itemName = "Mapple Center Concert"
    private val itemPrice = 50.00
    private val date = Date(1653904800000)

    val cartItem: CartItem = CartItemImpl(ItemImpl(itemName, itemPrice, date), 1)

    @Test
    fun getName() {
        assertEquals(itemName, cartItem.getName())
    }

    @Test
    fun getPrice() {
        assertEquals(itemPrice, cartItem.getPrice())
    }

    @Test
    fun getQuantity() {
        assertEquals(1, cartItem.getQuantity())
    }

    @Test
    fun getDateTime() {
        val dateTime = cartItem.getDateTime()
        println("\n\n\n")
        println(dateTime)
        println("\n\n\n")
        assertTrue(dateTime.startsWith("Mon, May 30 -"))
    }

    @Test
    fun incrementQuantity() {
        cartItem.incrementQuantity()
        assertEquals(2, cartItem.getQuantity())
    }

    @Test
    fun incrementQuantityMultipleTimes() {
        cartItem.updateQuantity(1)
        cartItem.incrementQuantity() //2
        cartItem.incrementQuantity() //3
        cartItem.incrementQuantity() //4
        cartItem.incrementQuantity() //5
        cartItem.incrementQuantity() //6
        assertEquals(6, cartItem.getQuantity())
    }


    @Test
    fun decrementQuantity() {
        cartItem.updateQuantity(2)
        cartItem.decrementQuantity()
        assertEquals(1, cartItem.getQuantity())
    }

    @Test
    fun decrementQuantityDoesNotReduceToZero() {
        cartItem.updateQuantity(2)
        cartItem.decrementQuantity()
        cartItem.decrementQuantity()
        cartItem.decrementQuantity()
        cartItem.decrementQuantity()
        cartItem.decrementQuantity()
        assertEquals(1, cartItem.getQuantity())
    }

    @Test
    fun updateQuantity() {
        cartItem.updateQuantity(4)
        assertEquals(4, cartItem.getQuantity())
    }
}