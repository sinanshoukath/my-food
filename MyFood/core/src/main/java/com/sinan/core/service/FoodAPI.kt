/*
 * Created by sinan shoukath on 5/11/2023
 * Copyright (c) 2023. All rights reserved.
 */

package com.sinan.core.service

import com.sinan.core.model.CategoryResponse
import com.sinan.core.model.MealsResponse
import com.sinan.core.model.RandomMealsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FoodAPI {
  @GET("categories.php")
  fun getCategories(): Call<CategoryResponse>

  @GET("filter.php?")
  fun getMealsByCategory(@Query("i") category:String): Call<MealsResponse>

  @GET("random.php")
  fun getRandomMeal(): Call<RandomMealsResponse>

  @GET("lookup.php?")
  fun getMealById(@Query("i") id:String): Call<RandomMealsResponse>

  @GET("search.php?")
  fun getMealByName(@Query("s") s:String): Call<RandomMealsResponse>
}