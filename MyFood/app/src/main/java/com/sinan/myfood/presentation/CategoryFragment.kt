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
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.sinan.core.data.Category
import com.sinan.myfood.databinding.FragmentCategoryBinding
import com.sinan.myfood.framework.CategoryViewModel
import com.sinan.myfood.presentation.adapters.CategoryListAction
import com.sinan.myfood.presentation.adapters.CategoryListAdapter
import com.sinan.myfood.utils.CommonKeys.CATEGORY_NAME

class CategoryFragment: Fragment() {
  private lateinit var binding: FragmentCategoryBinding
  private lateinit var categoryViewModel: CategoryViewModel
  private lateinit var categoryListAdapter: CategoryListAdapter


  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    binding = FragmentCategoryBinding.inflate(inflater, container,false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    categoryViewModel = ViewModelProvider(this)[CategoryViewModel::class.java]
    categoryListAdapter = CategoryListAdapter(object : CategoryListAction {
      override fun onCategoryClick(category: Category) {
        val intent = Intent(context, MealListActivity::class.java)
        intent.putExtra(CATEGORY_NAME, category.strCategory)
        startActivity(intent)
      }
    })
    binding.favoriteRecyclerView.apply {
      adapter = categoryListAdapter
      layoutManager = GridLayoutManager(context,3, GridLayoutManager.VERTICAL,false)
    }

    categoryViewModel.getCategories()
    observeViewModel()
  }

  private fun observeViewModel() {
    categoryViewModel.categories.observe(viewLifecycleOwner) {
      if (!it.isNullOrEmpty()) categoryListAdapter.updateList(it)
    }
  }
}
