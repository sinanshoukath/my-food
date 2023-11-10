/*
 * Created by sinan shoukath on 6/11/2023
 * Copyright (c) 2023. All rights reserved.
 */

package com.sinan.myfood.framework.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import androidx.room.Update

@Dao
interface MealsDao {
  @Insert(onConflict = REPLACE)
  fun insertFavorite(meal: MealEntity)

  @Update
  fun updateFavorite(meal: MealEntity)

  @Query("SELECT * FROM meal order by meal_id asc")
  fun getAllSavedMeals(): List<MealEntity>

  @Query("SELECT * FROM meal WHERE meal_id =:id")
  fun getMealById(id: String): MealEntity

  @Query("DELETE FROM meal WHERE meal_id =:id")
  fun deleteMealById(id: String)

  @Delete
  fun deleteMeal(meal: MealEntity)
}
