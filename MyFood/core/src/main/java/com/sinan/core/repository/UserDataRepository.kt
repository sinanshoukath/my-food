/*
 * Created by sinan shoukath on 6/11/2023
 * Copyright (c) 2023. All rights reserved.
 */

package com.sinan.core.repository

import com.sinan.core.data.MealDetail

class UserDataRepository(val dataSource: UserDataSource) {
  suspend fun insertFavorite(meal: MealDetail) = dataSource.insertFavorite(meal)
  suspend fun updateFavorite(meal: MealDetail) = dataSource.updateFavorite(meal)
  suspend fun getAllMeals() = dataSource.getAllMeals()
  suspend fun getMealById(id: String) = dataSource.getMealById(id)
  suspend fun deleteMealById(id: String) = dataSource.deleteMealById(id)
  suspend fun deleteMeal(meal: MealDetail) = dataSource.deleteMeal(meal)
}
