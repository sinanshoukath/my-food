/*
 * Created by sinan shoukath on 9/11/2023
 * Copyright (c) 2023. All rights reserved.
 */

package com.sinan.myfood.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sinan.core.data.Meal
import com.sinan.core.data.MealDetail
import com.sinan.myfood.databinding.MostPopularCardBinding

class PopularMealsAdapter(val popularMealsAction: PopularMealsAction): RecyclerView.Adapter<PopularMealsAdapter.PopularMealsViewHolder>() {
  private var popularMeals: MutableList<Meal> = mutableListOf()

  inner class PopularMealsViewHolder(private val binding: MostPopularCardBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(meal: Meal) {
      Glide.with(itemView)
        .load(meal.strMealThumb)
        .into(binding.imgPopularMeal)

      itemView.setOnClickListener {
        popularMealsAction.onMealClick(meal)
      }
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMealsViewHolder {
    return PopularMealsViewHolder(MostPopularCardBinding.inflate(LayoutInflater.from(parent.context), parent, false))
  }

  override fun getItemCount(): Int = popularMeals.size

  override fun onBindViewHolder(holder: PopularMealsViewHolder, position: Int) {
    holder.bind(popularMeals[position])
  }

  fun updateMeals(mealsList: List<Meal>) {
    popularMeals.clear()
    popularMeals.addAll(mealsList)
    notifyDataSetChanged()
  }
}
