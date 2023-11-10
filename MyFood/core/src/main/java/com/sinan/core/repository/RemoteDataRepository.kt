/*
 * Created by sinan shoukath on 6/11/2023
 * Copyright (c) 2023. All rights reserved.
 */

package com.sinan.core.repository

class RemoteDataRepository(val dataSource: RemoteDataSource) {
  suspend fun getCategories() = dataSource.getCategories()
  suspend fun getMealsByCategory(categoryId: String) = dataSource.getMealsByCategory(categoryId)
  suspend fun getRandomMeals() = dataSource.getRandomMeals()
  suspend fun getMealById(mealId: String) = dataSource.getMealById(mealId)
  suspend fun getMealByName(mealName: String) = dataSource.getMealByName(mealName)

}