/*
 * Created by sinan shoukath on 6/11/2023
 * Copyright (c) 2023. All rights reserved.
 */

package com.sinan.core.usecase

import com.sinan.core.repository.MealRepository
class GetMealById(val repository: MealRepository) {
  suspend operator fun invoke(mealId: String) = repository.getRemoteMealById(mealId)
}
