/*
 * Created by sinan shoukath on 13/11/2023
 * Copyright (c) 2023. All rights reserved.
 */

package com.sinan.myfood.framework.di

import com.sinan.core.repository.MealRepository
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
import com.sinan.myfood.framework.UseCases
import dagger.Module
import dagger.Provides

@Module
class UseCasesModule {

  @Provides
  fun getUseCases(mealRepository: MealRepository): UseCases {
    return UseCases(
      GetAllMeals(mealRepository),
      GetCategories(mealRepository),
      GetMealById(mealRepository),
      GetMealByName(mealRepository),
      GetMealsByCategory(mealRepository),
      GetRandomMeals(mealRepository),
      GetUserMealById(mealRepository),
      InsertFavorite(mealRepository),
      UpdateFavorite(mealRepository),
      DeleteMeal(mealRepository),
      DeleteMealById(mealRepository)
    )
  }
}
