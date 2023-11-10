/*
 * Created by sinan shoukath on 9/11/2023
 * Copyright (c) 2023. All rights reserved.
 */

package com.sinan.myfood.presentation.adapters

import com.sinan.core.data.Meal

interface PopularMealsAction {
  fun onMealClick(mealDetail: Meal)
  fun onMealLongClick(mealDetail: Meal)
}