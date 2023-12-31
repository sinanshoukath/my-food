/*
 * Created by sinan shoukath on 8/11/2023
 * Copyright (c) 2023. All rights reserved.
 */

package com.sinan.myfood.presentation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.sinan.core.data.Category
import com.sinan.core.data.Meal
import com.sinan.core.data.MealDetail
import com.sinan.myfood.databinding.FragmentHomeBinding
import com.sinan.myfood.framework.HomeScreenViewModel
import com.sinan.myfood.presentation.adapters.CategoryListAction
import com.sinan.myfood.presentation.adapters.CategoryListAdapter
import com.sinan.myfood.presentation.adapters.PopularMealsAction
import com.sinan.myfood.presentation.adapters.PopularMealsAdapter
import com.sinan.myfood.utils.CommonKeys.CATEGORY_NAME
import com.sinan.myfood.utils.CommonKeys.MEAL_AREA
import com.sinan.myfood.utils.CommonKeys.MEAL_ID
import com.sinan.myfood.utils.CommonKeys.MEAL_NAME
import com.sinan.myfood.utils.CommonKeys.MEAL_STR
import com.sinan.myfood.utils.CommonKeys.MEAL_THUMB

class HomeScreenFragment : Fragment() {
  private lateinit var homeScreenViewModel: HomeScreenViewModel
  private lateinit var binding: FragmentHomeBinding
  private lateinit var categoryListAdapter: CategoryListAdapter
  private lateinit var popularMealsAdapter: PopularMealsAdapter
  private var randomMeal: MealDetail? = null

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
    binding = FragmentHomeBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    homeScreenViewModel = ViewModelProvider(this)[HomeScreenViewModel::class.java]
    categoryListAdapter = CategoryListAdapter(object : CategoryListAction {
      override fun onCategoryClick(category: Category) {
        val intent = Intent(activity, MealListActivity::class.java)
        intent.putExtra(CATEGORY_NAME, category.strCategory)
        startActivity(intent)
      }
    })
    popularMealsAdapter = PopularMealsAdapter(object : PopularMealsAction {
      override fun onMealClick(mealDetail: Meal) {
        val intent = Intent(activity, MealDetailsActivity::class.java)
        intent.putExtra(MEAL_ID, mealDetail.mealId)
        intent.putExtra(MEAL_STR, mealDetail.strMeal)
        intent.putExtra(MEAL_THUMB, mealDetail.strMealThumb)
        startActivity(intent)
      }

      override fun onMealLongClick(mealDetail: Meal) {
        homeScreenViewModel.getMealById(mealDetail.mealId)
      }
    })
    binding.recyclerView.apply {
      adapter = categoryListAdapter
      layoutManager = GridLayoutManager(context, 3, GridLayoutManager.VERTICAL, false)
    }
    binding.recViewMealsPopular.apply {
      adapter = popularMealsAdapter
      layoutManager = GridLayoutManager(context, 1, GridLayoutManager.HORIZONTAL, false)
    }

    observeViewModel()
    homeScreenViewModel.getCategories()
    homeScreenViewModel.getRandomMeals()
    homeScreenViewModel.getMealsByCategory("chicken")
  }

  private fun observeViewModel() {
    homeScreenViewModel.categories.observe(viewLifecycleOwner) {
      categoryListAdapter.updateList(it)
    }

    homeScreenViewModel.randomMeals.observe(viewLifecycleOwner) {
      Glide.with(this)
        .load(it[0].mealThumb)
        .into(binding.imgRandomMeal)
      randomMeal = it[0]
    }

    homeScreenViewModel.mealsByCategory.observe(viewLifecycleOwner) {
      popularMealsAdapter.updateMeals(it)
    }

    homeScreenViewModel.mealsById.observe(viewLifecycleOwner) {
      if (!it.isNullOrEmpty()) {
        val mealItem = it[0]
        val bottomSheetFragment = MealBottomDialog()
        val bundle = Bundle()
        bundle.putString(CATEGORY_NAME, mealItem.category)
        bundle.putString(MEAL_AREA, mealItem.area)
        bundle.putString(MEAL_NAME, mealItem.meal)
        bundle.putString(MEAL_THUMB, mealItem.mealThumb)
        bundle.putString(MEAL_ID, mealItem.mealId)

        bottomSheetFragment.arguments = bundle
        bottomSheetFragment.show(childFragmentManager, "BottomSheetDialog")
      }
    }
  }
}