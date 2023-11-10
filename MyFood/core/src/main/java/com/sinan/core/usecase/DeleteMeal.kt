/*
 * Created by sinan shoukath on 6/11/2023
 * Copyright (c) 2023. All rights reserved.
 */

package com.sinan.core.usecase

import com.sinan.core.data.Meal
import com.sinan.core.data.MealDetail
import com.sinan.core.repository.UserDataRepository

class DeleteMeal(val repository: UserDataRepository) {
  suspend operator fun invoke(meal: MealDetail) = repository.deleteMeal(meal)
}
