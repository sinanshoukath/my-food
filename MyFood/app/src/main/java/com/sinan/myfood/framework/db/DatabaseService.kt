/*
 * Created by sinan shoukath on 6/11/2023
 * Copyright (c) 2023. All rights reserved.
 */

package com.sinan.myfood.framework.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MealEntity::class], version = 1)
abstract class DatabaseService: RoomDatabase() {
  companion object {
    private const val DATABASE_NAME = "meals.db"
    private var instance: DatabaseService? = null

    private fun create(context: Context): DatabaseService =
      Room.databaseBuilder(context, DatabaseService::class.java, DATABASE_NAME)
        .fallbackToDestructiveMigration()
        .build()


    fun getInstance(context: Context): DatabaseService =
      (instance ?: create(context)).also { instance = it }
  }

  abstract fun mealsDao(): MealsDao
}
