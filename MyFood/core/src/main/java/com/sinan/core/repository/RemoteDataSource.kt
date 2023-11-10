/*
 * Created by sinan shoukath on 6/11/2023
 * Copyright (c) 2023. All rights reserved.
 */

package com.sinan.core.repository

import com.sinan.core.data.Category
import com.sinan.core.data.Meal
import com.sinan.core.data.MealDetail

interface RemoteDataSource {
  suspend fun getCategories(): List<Category>?
  suspend fun getMealsByCategory(categoryId: String): List<Meal>?
  suspend fun getRandomMeals(): List<MealDetail>?
  suspend fun getMealById(mealId: String): List<MealDetail>?
  suspend fun getMealByName(mealName: String): List<MealDetail>?
}
