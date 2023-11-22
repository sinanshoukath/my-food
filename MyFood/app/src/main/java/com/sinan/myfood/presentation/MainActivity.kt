/*
 * Created by sinan shoukath on 7/11/2023
 * Copyright (c) 2023. All rights reserved.
 */

package com.sinan.myfood.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sinan.myfood.R

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val navView = this.findNavController(R.id.fragmentContainerView)
    val bottomNavView = findViewById<BottomNavigationView>(R.id.nav_view)
    bottomNavView.setupWithNavController(navView)
  }
}
