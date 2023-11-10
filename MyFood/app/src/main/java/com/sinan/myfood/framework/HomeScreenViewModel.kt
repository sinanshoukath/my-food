/*
 * Created by sinan shoukath on 8/11/2023
 * Copyright (c) 2023. All rights reserved.
 */

package com.sinan.myfood.framework

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.sinan.core.data.Category
import com.sinan.core.data.Meal
import com.sinan.core.data.MealDetail
import com.sinan.core.repository.RemoteDataRepository
import com.sinan.core.repository.UserDataRepository
import com.sinan.core.service.FoodAPIDataSource
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
import kotlinx.coroutines.launch

class HomeScreenViewModel(application: Application): BaseViewModel(application) {
  val categories = MutableLiveData<List<Category>>()
  val randomMeals = MutableLiveData<List<MealDetail>>()
  val mealsByCategory = MutableLiveData<List<Meal>>()
  val mealsById = MutableLiveData<List<MealDetail>>()

  private lateinit var useCases: UseCases
  init {
    val remoteRepository = RemoteDataRepository(FoodAPIDataSource())
    val userDataRepository = UserDataRepository(RoomUserDataSource(application))
    useCases = UseCases(
      GetAllMeals(userDataRepository),
      GetCategories(remoteRepository),
      GetMealById(remoteRepository),
      GetMealByName(remoteRepository),
      GetMealsByCategory(remoteRepository),
      GetRandomMeals(remoteRepository),
      GetUserMealById(userDataRepository),
      InsertFavorite(userDataRepository),
      UpdateFavorite(userDataRepository),
      DeleteMeal(userDataRepository),
      DeleteMealById(userDataRepository)
    )
  }

  fun getCategories() {
    launch {
      val response = useCases.getCategories.invoke()
      response?.let {
        categories.postValue(it)
      }
    }
  }

  fun getRandomMeals() {
    launch {
      val response = useCases.getRandomMeals.invoke()
      response?.let {
        randomMeals.postValue(it)
      }
    }
  }

  fun getMealsByCategory(categoryId: String) {
    launch {
      val response = useCases.getMealsByCategory.invoke(categoryId)
      response?.let {
        mealsByCategory.postValue(it)
      }
    }
  }

  fun getMealById(mealId: String) {
    launch {
      val response = useCases.getMealById.invoke(mealId)
      response?.let {
        mealsById.postValue(it)
      }
    }
  }
}