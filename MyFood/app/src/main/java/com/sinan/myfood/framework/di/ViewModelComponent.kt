/*
 * Created by sinan shoukath on 13/11/2023
 * Copyright (c) 2023. All rights reserved.
 */

package com.sinan.myfood.framework.di

import com.sinan.myfood.framework.CategoryViewModel
import com.sinan.myfood.framework.HomeScreenViewModel
import com.sinan.myfood.framework.MealDetailsViewModel
import com.sinan.myfood.framework.MealListViewModel
import com.sinan.myfood.framework.SearchViewModel
import dagger.Component

@Component(modules = [ApplicationModule::class, RemoteDataRepositoryModule::class, UserDataRepositoryModule::class, UseCasesModule::class])
interface ViewModelComponent {
  fun inject(homeScreenViewModel: HomeScreenViewModel)
  fun inject(mealListViewModel: MealListViewModel)
  fun inject(mealDetailsViewModel: MealDetailsViewModel)
  fun inject(categoryViewModel: CategoryViewModel)
  fun inject(searchViewModel: SearchViewModel)
}
