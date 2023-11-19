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
import com.sinan.myfood.framework.di.ApplicationModule
import com.sinan.myfood.framework.di.DaggerViewModelComponent
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeScreenViewModel(application: Application): BaseViewModel(application) {
  val categories = MutableLiveData<List<Category>>()
  val randomMeals = MutableLiveData<List<MealDetail>>()
  val mealsByCategory = MutableLiveData<List<Meal>>()
  val mealsById = MutableLiveData<List<MealDetail>>()

  @Inject
  lateinit var useCases: UseCases
  init {
    DaggerViewModelComponent.builder()
      .applicationModule(ApplicationModule(application))
      .build()
      .inject(this)
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