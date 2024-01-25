/*
 * Created by sinan shoukath on 6/11/2023
 * Copyright (c) 2023. All rights reserved.
 */

package com.sinan.core.usecase

import com.sinan.core.data.MealDetail
import com.sinan.core.repository.MealRepository

class UpdateFavorite(val repository: MealRepository) {
  suspend operator fun invoke(meal: MealDetail) = repository.updateFavorite(meal)
}
