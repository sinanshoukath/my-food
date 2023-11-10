/*
 * Created by sinan shoukath on 6/11/2023
 * Copyright (c) 2023. All rights reserved.
 */

package com.sinan.myfood.framework

import android.content.Context
import com.sinan.core.data.MealDetail
import com.sinan.core.repository.UserDataSource
import com.sinan.myfood.framework.db.DatabaseService
import com.sinan.myfood.framework.db.MealEntity

class RoomUserDataSource(context: Context): UserDataSource {
  val mealsDao = DatabaseService.getInstance(context).mealsDao()

  override suspend fun insertFavorite(meal: MealDetail) = mealsDao.insertFavorite(getMealEntity(meal))

  override suspend fun updateFavorite(meal: MealDetail) = mealsDao.updateFavorite(getMealEntity(meal))

  override suspend fun getAllMeals(): List<MealDetail> {
    return mealsDao.getAllSavedMeals().map { MealDetail(it.mealId.toString(), it.mealCountry, it.mealCategory, it.mealInstruction, it.mealName, it.mealThumb, it.mealYoutubeLink) }
  }

  override suspend fun getMealById(id: String): MealDetail {
    return getMealDetail(mealsDao.getMealById(id))
  }

  override suspend fun deleteMealById(id: String) = mealsDao.deleteMealById(id)

  override suspend fun deleteMeal(meal: MealDetail) = mealsDao.deleteMeal(getMealEntity(meal))

  private fun getMealEntity(mealDetail: MealDetail): MealEntity {
    return MealEntity(mealDetail.mealId.toInt(), mealDetail.meal, mealDetail.area,
      mealDetail.category, mealDetail.instructions, mealDetail.mealThumb, mealDetail.youtube)
  }

  private fun getMealDetail(mealEntity: MealEntity): MealDetail {
    return MealDetail(mealEntity.mealId.toString(), mealEntity.mealCountry, mealEntity.mealCategory, mealEntity.mealInstruction, mealEntity.mealName, mealEntity.mealThumb, mealEntity.mealYoutubeLink)
  }
}
