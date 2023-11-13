/*
 * Created by sinan shoukath on 11/11/2023
 * Copyright (c) 2023. All rights reserved.
 */

package com.sinan.myfood.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sinan.core.data.Meal
import com.sinan.myfood.databinding.MealCardBinding
import com.sinan.myfood.presentation.adapters.MealsRecycleAdapter.MealsViewHolder

class MealsRecycleAdapter(val categoryMealsAction: CategoryMealsAction): RecyclerView.Adapter<MealsViewHolder>() {
  private val mealList = mutableListOf<Meal>()

  inner class MealsViewHolder(val binding: MealCardBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(meal: Meal) {
      binding.tvMealName.text = meal.strMeal
      Glide.with(itemView)
        .load(meal.strMealThumb)
        .into(binding.imgMeal)

      itemView.setOnClickListener {
        categoryMealsAction.onMealClick(meal)
      }
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealsViewHolder {
    return MealsViewHolder(MealCardBinding.inflate(LayoutInflater.from(parent.context), parent, false))
  }

  override fun getItemCount(): Int = mealList.size

  override fun onBindViewHolder(holder: MealsViewHolder, position: Int) {
    holder.bind(mealList[position])
  }

  fun updateMealsList(meals: List<Meal>) {
    mealList.clear()
    mealList.addAll(meals)
    notifyDataSetChanged()
  }
}
