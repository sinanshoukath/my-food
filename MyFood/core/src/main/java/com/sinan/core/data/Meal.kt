/*
 * Created by sinan shoukath on 5/11/2023
 * Copyright (c) 2023. All rights reserved.
 */

package com.sinan.core.data

import com.google.gson.annotations.SerializedName

data class Meal(
  @SerializedName("idMeal") val mealId: String,
  @SerializedName("strMeal") val strMeal: String,
  @SerializedName("strMealThumb") val strMealThumb: String
)
