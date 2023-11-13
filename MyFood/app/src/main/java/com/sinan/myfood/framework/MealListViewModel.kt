/*
 * Created by sinan shoukath on 11/11/2023
 * Copyright (c) 2023. All rights reserved.
 */

package com.sinan.myfood.framework

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.sinan.core.data.Meal
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
import com.sinan.myfood.framework.di.ApplicationModule
import com.sinan.myfood.framework.di.DaggerViewModelComponent
import kotlinx.coroutines.launch
import javax.inject.Inject

class MealListViewModel(application: Application): BaseViewModel(application) {

  val meals = MutableLiveData<List<Meal>>()

  @Inject
  lateinit var useCases: UseCases
  init {
    DaggerViewModelComponent.builder()
      .applicationModule(ApplicationModule(application))
      .build()
      .inject(this)
  }

  fun getMealsByCategory(category: String) {
    launch {
      val response = useCases.getMealsByCategory.invoke(category)
      response?.let {
        meals.postValue(it)
      }
    }
  }
}
