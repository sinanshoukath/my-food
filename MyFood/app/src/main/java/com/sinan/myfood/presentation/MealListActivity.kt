/*
 * Created by sinan shoukath on 11/11/2023
 * Copyright (c) 2023. All rights reserved.
 */

package com.sinan.myfood.presentation

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.sinan.core.data.Meal
import com.sinan.myfood.R
import com.sinan.myfood.databinding.ActivityMealListBinding
import com.sinan.myfood.framework.MealListViewModel
import com.sinan.myfood.presentation.adapters.CategoryMealsAction
import com.sinan.myfood.presentation.adapters.MealsRecycleAdapter
import com.sinan.myfood.utils.CommonKeys
import com.sinan.myfood.utils.CommonKeys.MEAL_ID
import com.sinan.myfood.utils.CommonKeys.MEAL_STR
import com.sinan.myfood.utils.CommonKeys.MEAL_THUMB

class MealListActivity: AppCompatActivity() {
  private lateinit var mealListViewModel: MealListViewModel
  private lateinit var binding: ActivityMealListBinding
  private var categoryName: String? = null
  private lateinit var mealsAdapter: MealsRecycleAdapter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMealListBinding.inflate(layoutInflater)
    mealListViewModel = ViewModelProvider(this).get(MealListViewModel::class.java)
    setContentView(binding.root)
    categoryName = intent.getStringExtra(CommonKeys.CATEGORY_NAME)
    mealsAdapter = MealsRecycleAdapter(object : CategoryMealsAction {
      override fun onMealClick(meal: Meal) {
        val intent = Intent(applicationContext, MealDetailsActivity::class.java)
        intent.putExtra(MEAL_ID, meal.mealId)
        intent.putExtra(MEAL_STR, meal.strMeal)
        intent.putExtra(MEAL_THUMB, meal.strMealThumb)
        startActivity(intent)
      }
    })
    binding.mealRecyclerview.apply {
      adapter = mealsAdapter
      layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
    }

    observeViewModel()
    categoryName?.let { mealListViewModel.getMealsByCategory(it) }
  }

  private fun observeViewModel() {
    mealListViewModel.meals.observe(this) {
      if (it.isNullOrEmpty()) {
        Toast.makeText(applicationContext, getString(R.string.no_meals_in_this_category), Toast.LENGTH_SHORT).show()
      } else {
        mealsAdapter.updateMealsList(it)
        binding.tvCategoryCount.text = TextUtils.concat("$categoryName: ${it.size}")
      }
    }
  }
}