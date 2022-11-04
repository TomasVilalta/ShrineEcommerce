package com.example.tryingout.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.tryingout.Product
import com.example.tryingout.databinding.ItemProductBinding


class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemProductBinding.bind(view)

    fun render(product: Product) {
        binding.productTitle.text = product.product
        binding.productPrice.text = product.price.toString()

    }


}