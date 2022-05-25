package com.meticulous.shoppingcart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.meticulous.shoppingcart.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            loadMainFragment()
        }
    }

    private fun loadMainFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, MainFragment.newInstance())
            .commitNow()
        title = getString(R.string.cart_title)
    }
}