package com.example.tryingout.adapter

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tryingout.Product
import com.example.tryingout.databinding.ItemProductBinding


class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemProductBinding.bind(view)

    fun render(product: Product) {
        val priceTag = "$${product.price}"
        binding.productTitle.text = product.product
        binding.productPrice.text = priceTag
        Glide.with(binding.productImage.context).load(product.photo).into(binding.productImage)
        itemView.setOnClickListener {
            Toast.makeText(
                binding.productTitle.context,
                "'Tis a ${product.product}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }


}