/*
 * Created by sinan shoukath on 6/11/2023
 * Copyright (c) 2023. All rights reserved.
 */

package com.sinan.core.repository

import com.sinan.core.data.MealDetail

interface UserDataSource {
  suspend fun insertFavorite(meal: MealDetail)
  suspend fun updateFavorite(meal: MealDetail)
  suspend fun getAllMeals(): List<MealDetail>
  suspend fun getMealById(id: String): MealDetail
  suspend fun deleteMealById(id: String)
  suspend fun deleteMeal(meal: MealDetail)
}
