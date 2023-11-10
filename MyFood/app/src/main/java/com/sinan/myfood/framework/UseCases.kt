/*
 * Created by sinan shoukath on 7/11/2023
 * Copyright (c) 2023. All rights reserved.
 */

package com.sinan.myfood.framework

import com.sinan.core.usecase.DeleteMeal
import com.sinan.core.usecase.DeleteMealById
import com.sinan.core.usecase.GetAllMeals
import com.sinan.core.usecase.GetCategories
import com.sinan.core.usecase.GetMealById
import com.sinan.core.usecase.GetMealByName
import com.sinan.core.usecase.GetMealsByCategory
import com.sinan.core.usecase.GetRandomMeals
import com.sinan.core.usecase.GetUserMealById
import com.sinan.core.usecase.InsertFavorite
import com.sinan.core.usecase.UpdateFavorite

data class UseCases(
  val getAllMeals: GetAllMeals,
  val getCategories: GetCategories,
  val getMealById: GetMealById,
  val getMealByName: GetMealByName,
  val getMealsByCategory: GetMealsByCategory,
  val getRandomMeals: GetRandomMeals,
  val getUserMealById: GetUserMealById,
  val insertFavorite: InsertFavorite,
  val updateFavorite: UpdateFavorite,
  val deleteMeal: DeleteMeal,
  val deleteMealById: DeleteMealById
)

