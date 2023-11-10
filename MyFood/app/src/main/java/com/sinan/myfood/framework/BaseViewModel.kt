/*
 * Created by sinan shoukath on 8/11/2023
 * Copyright (c) 2023. All rights reserved.
 */

package com.sinan.myfood.framework

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

open class BaseViewModel(application: Application): AndroidViewModel(application), CoroutineScope {
  private val job= Job()
  override val coroutineContext: CoroutineContext
    get() = job + Dispatchers.Default

  override fun onCleared() {
    super.onCleared()
    job.cancel()
  }
}