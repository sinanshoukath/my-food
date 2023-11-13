/*
 * Created by sinan shoukath on 11/11/2023
 * Copyright (c) 2023. All rights reserved.
 */

package com.sinan.myfood.presentation.adapters

import com.sinan.core.data.Meal

interface CategoryMealsAction {
  fun onMealClick(meal: Meal)
}
