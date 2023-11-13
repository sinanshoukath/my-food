/*
 * Created by sinan shoukath on 13/11/2023
 * Copyright (c) 2023. All rights reserved.
 */

package com.sinan.myfood.framework

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.sinan.core.data.Category
import com.sinan.myfood.framework.di.ApplicationModule
import com.sinan.myfood.framework.di.DaggerViewModelComponent
import kotlinx.coroutines.launch
import javax.inject.Inject

class CategoryViewModel(application: Application): BaseViewModel(application) {
  @Inject
  lateinit var useCases: UseCases
  var categories: MutableLiveData<List<Category>> = MutableLiveData<List<Category>>()
  init {
    DaggerViewModelComponent.builder()
      .applicationModule(ApplicationModule(application))
      .build()
      .inject(this)
  }

  fun getCategories() {
    launch {
      val response = useCases.getCategories()
      response?.let {
        categories.postValue(it)
      }
    }
  }
}