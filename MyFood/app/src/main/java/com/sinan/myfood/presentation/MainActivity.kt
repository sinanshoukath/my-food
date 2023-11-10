/*
 * Created by sinan shoukath on 7/11/2023
 * Copyright (c) 2023. All rights reserved.
 */

package com.sinan.myfood.presentation

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.sinan.myfood.R
import com.sinan.myfood.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    /*val navView: BottomNavigationView = binding.navView
    val navController = findNavController(R.id.fragmentContainerView)

    *//*val appBarConfiguration = AppBarConfiguration(
      setOf(
        R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
      )
    )
    setupActionBarWithNavController(navController, appBarConfiguration)*//*
    navView.setupWithNavController(navController)*/
  }
}