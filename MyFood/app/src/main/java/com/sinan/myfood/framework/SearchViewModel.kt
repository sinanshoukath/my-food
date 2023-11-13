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

class SearchViewModel(application: Application): BaseViewModel(application) {
  @Inject
  lateinit var useCases: UseCases
  var searchedMealLiveData = MutableLiveData<MealDetail>()
  init {
    DaggerViewModelComponent.builder()
      .applicationModule(ApplicationModule(application))
      .build()
      .inject(this)
  }

  fun searchMealDetail(mealName: String) {
    launch {
      val response = useCases.getMealByName(mealName)
      if (response?.isNotEmpty() == true) {
        searchedMealLiveData.postValue(response[0])
      }
    }
  }
}
