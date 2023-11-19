/*
 * Created by sinan shoukath on 19/11/2023
 * Copyright (c) 2023. All rights reserved.
 */

package com.sinan.myfood.utils

import android.util.Log

object Logger {
  private val TAG = "My_FOOD"

  fun log(logMessage: String?) {
    Log.d(TAG, logMessage!!)
  }

  fun log(tag: String?, logMessage: String?) {
    Log.d(tag, logMessage!!)
  }
}