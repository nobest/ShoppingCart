package com.meticulous.shoppingcart.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.meticulous.shoppingcart.R
import com.meticulous.shoppingcart.datastructure.CartItem
import com.meticulous.shoppingcart.utils.imageUtil.Companion.loadImageFromUrl

class CartItemAdapter(private var cartItems: List<CartItem>) :
    RecyclerView.Adapter<CartItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cart_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindCartItem(cartItems[position])
    }

    override fun getItemCount(): Int {
        return cartItems.size
    }

    fun updateCartItems(cartItems: List<CartItem>) {
        this.cartItems = cartItems
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView = itemView.findViewById<ImageView?>(R.id.item_image)
        private val dateTimeView = itemView.findViewById<TextView?>(R.id.item_date_time)
        private val nameView = itemView.findViewById<TextView?>(R.id.item_name)
        private val quantityView = itemView.findViewById<TextView?>(R.id.item_quantity)
        private val priceView = itemView.findViewById<TextView?>(R.id.item_price)

        fun bindCartItem(item: CartItem) {
            dateTimeView?.text = item.getDateTime()
            nameView?.text = item.getName()
            val quantity = quantityView?.resources?.getQuantityString(
                R.plurals.cartItemQuantity,
                item.getQuantity(),
                item.getQuantity()
            )
            quantityView?.text = quantity
            priceView?.text =
                priceView?.context?.getString(R.string.item_price_template, item.getPrice().toString())
            imageView?.loadImageFromUrl(item.getImageUrl())
        }
    }
}