/*
 * Created by sinan shoukath on 13/11/2023
 * Copyright (c) 2023. All rights reserved.
 */

package com.sinan.myfood.framework

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.sinan.core.data.MealDetail
import com.sinan.myfood.framework.di.ApplicationModule
import com.sinan.myfood.framework.di.DaggerViewModelComponent
import kotlinx.coroutines.launch
import javax.inject.Inject

class MealDetailsViewModel(application: Application): BaseViewModel(application) {
  @Inject
  lateinit var useCases: UseCases

  val mealDetailsList = MutableLiveData<List<MealDetail>>()
  val mealDetailsListBottom = MutableLiveData<List<MealDetail>>()
  val allMeals = MutableLiveData<List<MealDetail>>()
  val isMealSaved = MutableLiveData<Boolean>()

  init {
    DaggerViewModelComponent.builder()
      .applicationModule(ApplicationModule(application))
      .build()
      .inject(this)
  }

  fun getAllMeals() {
    launch {
      allMeals.postValue(useCases.getAllMeals())
    }
  }

  fun insertMeal(mealDetail: MealDetail) {
    launch {
      useCases.insertFavorite(mealDetail)
    }
  }

  fun deleteMeal(mealDetail: MealDetail) {
    launch {
      useCases.deleteMeal(mealDetail)
    }
  }

  fun getMealById(id: String) {
    launch {
      val response = useCases.getMealById(id)
      response?.let {
        mealDetailsList.postValue(it)
      }
    }
  }

  fun isMealSaved(mealId: String?) {
    if (mealId != null) {
      launch {
        val meal = useCases.getUserMealById(mealId)
        isMealSaved.postValue(meal != null)
      }
    }
  }

  fun deleteMealById(mealId: String){
    launch {
      useCases.deleteMealById(mealId)
    }
  }

  fun getMealByIdBottomSheet(id: String) {
    launch {
      val response = useCases.getMealById(id)
      response?.let {
        mealDetailsListBottom.postValue(it)
      }
    }
  }
}