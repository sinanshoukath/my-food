/*
 * Created by sinan shoukath on 6/11/2023
 * Copyright (c) 2023. All rights reserved.
 */

package com.sinan.core.usecase

import com.sinan.core.repository.RemoteDataRepository

class GetMealById(val repository: RemoteDataRepository) {
  suspend operator fun invoke(mealId: String) = repository.getMealById(mealId)
}
