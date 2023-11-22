/*
 * Created by sinan shoukath on 19/11/2023
 * Copyright (c) 2023. All rights reserved.
 */

package com.sinan.myfood.presentation.adapters

import com.sinan.core.data.MealDetail

interface FavoriteMealClickAction {
  fun onClick(mealDetail: MealDetail)
  fun onLongClick(mealDetail: MealDetail)
}