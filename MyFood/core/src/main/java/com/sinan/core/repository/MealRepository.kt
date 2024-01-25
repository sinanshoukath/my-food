/*
 * Created by sinan shoukath on 25/1/2024
 * Copyright (c) 2024. All rights reserved.
 */

package com.sinan.core.repository

import com.sinan.core.data.MealDetail

class MealRepository(val userDataSource: UserDataSource, val remoteDataSource: RemoteDataSource) {
  suspend fun insertFavorite(meal: MealDetail) = userDataSource.insertFavorite(meal)
  suspend fun updateFavorite(meal: MealDetail) = userDataSource.updateFavorite(meal)
  suspend fun getAllMeals() = userDataSource.getAllMeals()
  suspend fun getMealById(id: String) = userDataSource.getMealById(id)
  suspend fun deleteMealById(id: String) = userDataSource.deleteMealById(id)
  suspend fun deleteMeal(meal: MealDetail) = userDataSource.deleteMeal(meal)
  suspend fun getCategories() = remoteDataSource.getCategories()
  suspend fun getMealsByCategory(categoryId: String) = remoteDataSource.getMealsByCategory(categoryId)
  suspend fun getRandomMeals() = remoteDataSource.getRandomMeals()
  suspend fun getRemoteMealById(mealId: String) = remoteDataSource.getMealById(mealId)
  suspend fun getMealByName(mealName: String) = remoteDataSource.getMealByName(mealName)
}