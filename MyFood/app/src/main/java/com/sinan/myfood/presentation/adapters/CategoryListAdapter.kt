/*
 * Created by sinan shoukath on 9/11/2023
 * Copyright (c) 2023. All rights reserved.
 */

package com.sinan.myfood.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sinan.core.data.Category
import com.sinan.myfood.databinding.CategoryCardBinding

class CategoryListAdapter(val categoryListAction: CategoryListAction): RecyclerView.Adapter<CategoryListAdapter.CategoryListViewHolder>() {
  private var categories: MutableList<Category> = mutableListOf()

  inner class CategoryListViewHolder(val binding: CategoryCardBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(category: Category) {
      binding.tvCategoryName.text = category.strCategory
      Glide.with(itemView)
        .load(category.strCategoryThumb)
        .into(binding.imgCategory)
      itemView.setOnClickListener {
        categoryListAction.onCategoryClick(category)
      }
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryListViewHolder {
    return CategoryListViewHolder(CategoryCardBinding.inflate(LayoutInflater.from(parent.context), parent, false))
  }

  override fun getItemCount(): Int {
    return categories.size
  }

  override fun onBindViewHolder(holder: CategoryListViewHolder, position: Int) {
    holder.bind(categories[position])
  }

  fun updateList(categoryList: List<Category>) {
    categories.clear()
    categories.addAll(categoryList)
    notifyDataSetChanged()
  }
}
