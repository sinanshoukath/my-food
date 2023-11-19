/*
 * Created by sinan shoukath on 19/11/2023
 * Copyright (c) 2023. All rights reserved.
 */

package com.sinan.myfood.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.sinan.myfood.databinding.FragmentFavoriteMealsBinding
import com.sinan.myfood.framework.MealDetailsViewModel

class FavoriteFragment: Fragment() {
  private lateinit var binding: FragmentFavoriteMealsBinding
  private lateinit var mealDetailsViewModel: MealDetailsViewModel

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    binding = FragmentFavoriteMealsBinding.inflate(layoutInflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    mealDetailsViewModel = ViewModelProvider(this)[MealDetailsViewModel::class.java]

  }
}