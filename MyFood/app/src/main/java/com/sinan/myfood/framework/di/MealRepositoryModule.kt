/*
 * Created by sinan shoukath on 13/11/2023
 * Copyright (c) 2023. All rights reserved.
 */

package com.sinan.myfood.framework.di

import android.app.Application
import com.sinan.core.repository.MealRepository
import com.sinan.core.service.FoodAPIDataSource
import com.sinan.myfood.framework.RoomUserDataSource
import dagger.Module
import dagger.Provides

@Module
class MealRepositoryModule {
  @Provides
  fun providesMealRepository(application: Application) = MealRepository(RoomUserDataSource(application), FoodAPIDataSource())
}
