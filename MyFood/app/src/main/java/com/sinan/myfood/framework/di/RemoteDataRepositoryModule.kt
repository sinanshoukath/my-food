/*
 * Created by sinan shoukath on 13/11/2023
 * Copyright (c) 2023. All rights reserved.
 */

package com.sinan.myfood.framework.di

import com.sinan.core.repository.RemoteDataRepository
import com.sinan.core.service.FoodAPIDataSource
import dagger.Module
import dagger.Provides

@Module
class RemoteDataRepositoryModule {
  @Provides
  fun providesRemoteDataRepository() = RemoteDataRepository(FoodAPIDataSource())
}
