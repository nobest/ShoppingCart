package com.meticulous.shoppingcart.utils

import android.widget.ImageView
import com.meticulous.shoppingcart.R
import com.squareup.picasso.Picasso

class imageUtil {
    companion object {
        fun ImageView?.loadImageFromUrl(imageUrl: String) {
            Picasso.get()
                .load(imageUrl)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(this)
        }
    }
}