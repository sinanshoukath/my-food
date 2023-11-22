/*
 * Created by sinan shoukath on 19/11/2023
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
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.sinan.core.data.MealDetail
import com.sinan.myfood.databinding.FragmentFavoriteMealsBinding
import com.sinan.myfood.framework.MealDetailsViewModel
import com.sinan.myfood.presentation.adapters.FavoriteMealClickAction
import com.sinan.myfood.presentation.adapters.FavoriteMealsAdapter
import com.sinan.myfood.utils.CommonKeys.CATEGORY_NAME
import com.sinan.myfood.utils.CommonKeys.MEAL_AREA
import com.sinan.myfood.utils.CommonKeys.MEAL_ID
import com.sinan.myfood.utils.CommonKeys.MEAL_NAME
import com.sinan.myfood.utils.CommonKeys.MEAL_STR
import com.sinan.myfood.utils.CommonKeys.MEAL_THUMB

class FavoriteFragment: Fragment() {
  private lateinit var binding: FragmentFavoriteMealsBinding
  private lateinit var mealDetailsViewModel: MealDetailsViewModel
  private lateinit var favoriteMealsAdapter: FavoriteMealsAdapter

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    binding = FragmentFavoriteMealsBinding.inflate(layoutInflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    mealDetailsViewModel = ViewModelProvider(this)[MealDetailsViewModel::class.java]
    favoriteMealsAdapter = FavoriteMealsAdapter(object: FavoriteMealClickAction {
      override fun onClick(mealDetail: MealDetail) {
        val intent = Intent(context, MealDetailsActivity::class.java)
        intent.putExtra(MEAL_ID, mealDetail.mealId)
        intent.putExtra(MEAL_STR, mealDetail.meal)
        intent.putExtra(MEAL_THUMB, mealDetail.mealThumb)
        startActivity(intent)
      }

      override fun onLongClick(mealDetail: MealDetail) {
        mealDetailsViewModel.getMealByIdBottomSheet(mealDetail.mealId)
      }
    })

    binding.favRecView.apply {
      adapter = favoriteMealsAdapter
      layoutManager = GridLayoutManager(context,2, GridLayoutManager.VERTICAL,false)
    }

    val itemTouchHelper = object : ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP or ItemTouchHelper.DOWN,
      ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT){
      override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
        return true
      }

      override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        val position = viewHolder.bindingAdapterPosition
        val favoriteMeal = favoriteMealsAdapter.getMelaByPosition(position)
        mealDetailsViewModel.deleteMeal(favoriteMeal)
        showDeleteSnackBar(favoriteMeal)
      }
    }

    ItemTouchHelper(itemTouchHelper).attachToRecyclerView(binding.favRecView)
    observeViewModel()
    mealDetailsViewModel.getAllMeals()
  }

  private fun observeViewModel() {
    mealDetailsViewModel.mealDetailsListBottom.observe(viewLifecycleOwner) {
      val mealDetail = it[0]
      val bottomDialog = MealBottomDialog()
      val bundle = Bundle()
      bundle.putString(CATEGORY_NAME, mealDetail.category)
      bundle.putString(MEAL_AREA, mealDetail.area)
      bundle.putString(MEAL_NAME, mealDetail.meal)
      bundle.putString(MEAL_THUMB, mealDetail.mealThumb)
      bundle.putString(MEAL_ID, mealDetail.mealId)
      bottomDialog.arguments = bundle
      bottomDialog.show(childFragmentManager,"Favorite bottom dialog")
    }

    mealDetailsViewModel.allMeals.observe(viewLifecycleOwner) {
      favoriteMealsAdapter.setFavoriteMealsList(it)
      binding.tvFavEmpty.visibility = if (it.isEmpty()) View.VISIBLE else View.GONE
    }
  }

  private fun showDeleteSnackBar(favoriteMeal: MealDetail) {
    Snackbar.make(requireView(),"Meal was deleted", Snackbar.LENGTH_LONG).apply {
      setAction("undo", {
        mealDetailsViewModel.insertMeal(favoriteMeal)
      }).show()
    }
  }
}
