/*
 * Created by sinan shoukath on 11/11/2023
 * Copyright (c) 2023. All rights reserved.
 */

package com.sinan.myfood.presentation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.sinan.core.data.MealDetail
import com.sinan.myfood.R
import com.sinan.myfood.databinding.ActivityMealDetailsBinding
import com.sinan.myfood.framework.MealDetailsViewModel
import com.sinan.myfood.utils.CommonKeys
import com.sinan.myfood.utils.Logger

class MealDetailsActivity: AppCompatActivity() {
  private lateinit var mealDetailsViewModel: MealDetailsViewModel
  private lateinit var binding: ActivityMealDetailsBinding
  private var mealId: String? = null
  private var mealStr: String? = null
  private var mealThumb: String? = null
  private var youtubeUrl: String? = null
  private var mealDetail: MealDetail? = null
  private var isMealSaved = false

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    mealDetailsViewModel = ViewModelProvider(this).get(MealDetailsViewModel::class.java)
    binding = ActivityMealDetailsBinding.inflate(layoutInflater)
    setContentView(binding.root)
    mealId = intent.getStringExtra(CommonKeys.MEAL_ID)
    mealStr = intent.getStringExtra(CommonKeys.MEAL_STR)
    mealThumb = intent.getStringExtra(CommonKeys.MEAL_THUMB)

    setUpViewWithMealInformation()

    binding.imgYoutube.setOnClickListener {
      youtubeUrl?.let { startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(youtubeUrl))) }
    }

    binding.btnSave.setOnClickListener {
      if(isMealSaved){
        mealId?.let { mealDetailsViewModel.deleteMealById(it) }
        binding.btnSave.setImageResource(R.drawable.ic_baseline_save_24)
        Snackbar.make(
          findViewById(android.R.id.content),
          "Meal was deleted",
          Snackbar.LENGTH_SHORT).show()
      }else{
        saveMeal()
        binding.btnSave.setImageResource(R.drawable.ic_saved)
        Snackbar.make(
          findViewById(android.R.id.content),
          "Meal saved",
          Snackbar.LENGTH_SHORT).show()
      }
    }

    mealId?.let {
      mealDetailsViewModel.getMealById(it)
      mealDetailsViewModel.isMealSaved(it)
    }
    observeMealDetail()
  }

  private fun observeMealDetail() {
    mealDetailsViewModel.mealDetailsList.observe(this) {
      if (!it.isNullOrEmpty()) setMealInfo(it[0])
    }

    mealDetailsViewModel.isMealSaved.observe(this) {
      isMealSaved = it
      setFloatingButtonStatus(it)
    }
  }

  private fun setUpViewWithMealInformation() {
    binding.apply {
      collapsingToolbar.title = mealStr
      Glide.with(applicationContext)
        .load(mealThumb)
        .into(imgMealDetail)
    }
  }

  private fun setFloatingButtonStatus(isMealSaved: Boolean) {
    binding.btnSave.setImageResource(if (isMealSaved) R.drawable.ic_saved else R.drawable.ic_baseline_save_24)
  }

  private fun saveMeal() {
    mealDetail?.let { mealDetailsViewModel.insertMeal(it) }
  }

  private fun setMealInfo(meal: MealDetail) {
    mealDetail = meal
    youtubeUrl = meal.youtube
    binding.apply {
      tvInstructions.text = "- Instructions : "
      tvContent.text = meal.instructions
      tvAreaInfo.visibility = View.VISIBLE
      tvCategoryInfo.visibility = View.VISIBLE
      tvAreaInfo.text = TextUtils.concat(tvAreaInfo.text.toString() + meal.area)
      tvCategoryInfo.text = TextUtils.concat(tvCategoryInfo.text.toString() + meal.category)
      imgYoutube.visibility = View.VISIBLE
    }
  }
}
