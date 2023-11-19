/*
 * Created by sinan shoukath on 19/11/2023
 * Copyright (c) 2023. All rights reserved.
 */

package com.sinan.myfood.presentation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.sinan.myfood.R
import com.sinan.myfood.utils.CommonKeys.CATEGORY_NAME
import com.sinan.myfood.utils.CommonKeys.MEAL_AREA
import com.sinan.myfood.utils.CommonKeys.MEAL_ID
import com.sinan.myfood.utils.CommonKeys.MEAL_NAME
import com.sinan.myfood.utils.CommonKeys.MEAL_STR
import com.sinan.myfood.utils.CommonKeys.MEAL_THUMB

class MealBottomDialog(): BottomSheetDialogFragment() {
  private var mealName: String? = null
  private var mealId: String? = null
  private var mealImg: String? = null
  private var mealCountry: String? = null
  private var mealCategory: String? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setStyle(STYLE_NORMAL,R.style.AppBottomSheetDialogTheme)
    val arg = arguments
    mealName = arg?.getString(MEAL_NAME)
    mealId = arg?.getString(MEAL_ID)
    mealImg = arg?.getString(MEAL_THUMB)
    mealCategory = arg?.getString(CATEGORY_NAME)
    mealCountry = arg?.getString(MEAL_AREA)
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    val view = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_dialog, container, false)
    return view
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    setupView(view)

    view.setOnClickListener {
      val intent = Intent(context, MealDetailsActivity::class.java)
      intent.putExtra(MEAL_ID, mealId)
      intent.putExtra(MEAL_STR, mealName)
      intent.putExtra(MEAL_THUMB, mealImg)
      startActivity(intent)
    }
  }

  fun setupView(view:View){
    val tvMealName = view.findViewById<TextView>(R.id.tv_meal_name_in_btmsheet)
    val tvMealCategory = view.findViewById<TextView>(R.id.tv_meal_category)
    val tvMealCountry = view.findViewById<TextView>(R.id.tv_meal_country)
    val imgMeal = view.findViewById<ImageView>(R.id.img_category)

    Glide.with(view)
      .load(mealImg)
      .into(imgMeal)
    tvMealName.text = mealName
    tvMealCategory.text = mealCategory
    tvMealCountry.text = mealCountry
  }
}
