/*
 * Created by sinan shoukath on 6/11/2023
 * Copyright (c) 2023. All rights reserved.
 */

package com.sinan.core.service

import com.sinan.core.data.Category
import com.sinan.core.data.Meal
import com.sinan.core.data.MealDetail
import com.sinan.core.repository.RemoteDataSource

class FoodAPIDataSource(): RemoteDataSource {

  override suspend fun getCategories(): List<Category>? {
    val response = FoodAPIService.api.getCategories().execute()
    if (response.isSuccessful) {
      return response.body()?.categories
    } else {
      return listOf()
    }
  }

  override suspend fun getMealsByCategory(categoryId: String): List<Meal>? {
    val response = FoodAPIService.api.getMealsByCategory(categoryId).execute()
    if (response.isSuccessful) {
      return response.body()?.meals
    } else {
      return listOf()
    }
  }

  override suspend fun getRandomMeals(): List<MealDetail>? {
    val response = FoodAPIService.api.getRandomMeal().execute()
    if (response.isSuccessful) {
      return response.body()?.meals
    } else {
      return listOf()
    }
  }

  override suspend fun getMealById(mealId: String): List<MealDetail>? {
    val response = FoodAPIService.api.getMealById(mealId).execute()
    if (response.isSuccessful) {
      return response.body()?.meals
    } else {
      return listOf()
    }
  }

  override suspend fun getMealByName(mealName: String): List<MealDetail>? {
    val response = FoodAPIService.api.getMealByName(mealName).execute()
    if (response.isSuccessful) {
      return response.body()?.meals
    } else {
      return listOf()
    }
  }
}