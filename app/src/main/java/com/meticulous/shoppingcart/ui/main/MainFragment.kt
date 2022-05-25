package com.meticulous.shoppingcart.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.meticulous.shoppingcart.R

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var cartItemAdapter: CartItemAdapter
    private lateinit var cartItemListView: RecyclerView
    private lateinit var cartItemSubTotal: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cartItemAdapter = CartItemAdapter(listOf())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        initViews(view)
        observeData()
    }

    private fun initViews(view: View) {
        cartItemListView = view.findViewById(R.id.rv_cart_items)
        cartItemSubTotal = view.findViewById(R.id.tv_subtotal)
        view.findViewById<RecyclerView>(R.id.rv_cart_items)?.apply {
            adapter = cartItemAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        view.findViewById<Button>(R.id.btn_checkout)?.apply {
            setOnClickListener {
                Toast.makeText(activity, "Coming soon", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun observeData() {
        viewModel.cartItems.observe(viewLifecycleOwner) { cartItems ->
            cartItems?.let { cartItemAdapter.updateCartItems(it) }
        }
        viewModel.subTotal.observe(viewLifecycleOwner) {
            cartItemSubTotal.text = getString(R.string.cart_item_sub_total, it.toString())
        }
    }

}