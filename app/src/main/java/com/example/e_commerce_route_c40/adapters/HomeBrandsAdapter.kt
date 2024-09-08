package com.example.e_commerce_route_c40.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.e_commerce_route_c40.databinding.ItemCategoryBinding
import com.route.data.api.model.response.BrandDto
import com.route.domain.model.Brand
import com.route.domain.model.Category


class HomeBrandsAdapter : RecyclerView.Adapter<HomeBrandsAdapter.Holder>() {
    var brandsList: List<BrandDto>? = null // implelent listOf category
    var onClick: ((BrandDto,Int) -> Unit)? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount() = brandsList?.size?: 0

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val category = brandsList!![position]
        holder.bind(category)
        onClick?.let {
            holder.itemView.setOnClickListener {
                onClick?.invoke(category,position)
            }

        }
    }


    fun changeData(brands: List<BrandDto>?){
        brandsList = brands
        notifyDataSetChanged()
    }

    inner class Holder(private val binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(brandsList: BrandDto ) { // implelent listOf category
            binding.apply {
                Glide.with(binding.root.context)
                    .load(brandsList.image)
                    .into(ivCategories)
                tvCategories.text = brandsList.name

            }

        }
    }
}