package com.meticulous.shoppingcart.datastructure

import com.meticulous.shoppingcart.utils.DateUtil

data class CartItemImpl(
    private val item: Item,
    private var itemQuantity: Int = 1,
): CartItem {

    override fun getName() = item.getItemName()

    override fun getPrice() = item.getItemPrice()

    override fun getQuantity() = itemQuantity

    override fun getDateTime(): String {
        return DateUtil.formatCartItemDateTime(item.getItemDate())
    }

    override fun incrementQuantity() {
        itemQuantity++
    }

    override fun decrementQuantity() {
        if (itemQuantity > 1) itemQuantity--
    }

    override fun updateQuantity(quantity: Int) {
        if (quantity > 0) {
            itemQuantity = quantity
        }
    }
}
