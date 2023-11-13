/*
 * Created by sinan shoukath on 13/11/2023
 * Copyright (c) 2023. All rights reserved.
 */

package com.sinan.myfood.framework.di

import android.app.Application
import com.sinan.core.repository.UserDataRepository
import com.sinan.myfood.framework.RoomUserDataSource
import dagger.Module
import dagger.Provides

@Module
class UserDataRepositoryModule {
  @Provides
  fun providesUserDataRepositoryModule(application: Application) = UserDataRepository(RoomUserDataSource(application))
}
