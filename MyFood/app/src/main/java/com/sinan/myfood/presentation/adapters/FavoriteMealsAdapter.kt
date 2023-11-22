/*
 * Created by sinan shoukath on 19/11/2023
 * Copyright (c) 2023. All rights reserved.
 */

package com.sinan.myfood.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sinan.core.data.MealDetail
import com.sinan.myfood.R
import com.sinan.myfood.databinding.FavMealCardBinding

class FavoriteMealsAdapter(val clickAction: FavoriteMealClickAction): RecyclerView.Adapter<FavoriteMealsAdapter.FavoriteMealsHolder>() {
  private var favoriteMeals = mutableListOf<MealDetail>()

  inner class FavoriteMealsHolder(val binding: FavMealCardBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(mealDetail: MealDetail) {
      binding.apply {
        tvFavMealName.text = mealDetail.meal
        Glide.with(itemView)
          .load(mealDetail.mealThumb)
          .error(R.drawable.mealtest)
          .into(imgFavMeal)
      }

      itemView.setOnClickListener {
        clickAction.onClick(mealDetail)
      }

      itemView.setOnLongClickListener(object : View.OnLongClickListener {
        override fun onLongClick(p0: View?): Boolean {
          clickAction.onLongClick(mealDetail)
          return true
        }
      })
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteMealsHolder {
    val binding = FavMealCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return FavoriteMealsHolder(binding)
  }

  override fun getItemCount(): Int {
    return favoriteMeals.size
  }

  override fun onBindViewHolder(holder: FavoriteMealsHolder, position: Int) {
    holder.bind(favoriteMeals[position])
  }

  fun setFavoriteMealsList(meals: List<MealDetail>) {
    favoriteMeals.clear()
    favoriteMeals.addAll(meals)
    notifyDataSetChanged()
  }

  fun getMelaByPosition(position: Int): MealDetail{
    return favoriteMeals[position]
  }
}
