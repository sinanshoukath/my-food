/*
 * Created by sinan shoukath on 6/11/2023
 * Copyright (c) 2023. All rights reserved.
 */

package com.sinan.myfood.framework.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meal")
data class MealEntity(
  @PrimaryKey
  @ColumnInfo("meal_id")
  val mealId: Int,
  @ColumnInfo("meal_name")
  val mealName: String,
  @ColumnInfo("meal_country")
  val mealCountry: String,
  @ColumnInfo("meal_category")
  val mealCategory:String,
  @ColumnInfo("meal_instruction")
  val mealInstruction:String,
  @ColumnInfo("meal_thumb")
  val mealThumb:String,
  @ColumnInfo("meal_youtube_link")
  val mealYoutubeLink:String
)

