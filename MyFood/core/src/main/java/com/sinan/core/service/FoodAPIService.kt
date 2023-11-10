/*
 * Created by sinan shoukath on 6/11/2023
 * Copyright (c) 2023. All rights reserved.
 */

package com.sinan.core.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object FoodAPIService {
  val api: FoodAPI by lazy {
    Retrofit.Builder()
      .baseUrl("https://www.themealdb.com/api/json/v1/1/")
      .addConverterFactory(GsonConverterFactory.create())
      .build()
      .create(FoodAPI::class.java)
  }
}