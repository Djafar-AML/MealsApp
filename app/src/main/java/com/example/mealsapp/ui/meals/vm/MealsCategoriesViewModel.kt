package com.example.mealsapp.ui.meals.vm

import androidx.lifecycle.ViewModel
import com.example.mealsapp.ui.meals.repo.MealsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MealsCategoriesViewModel @Inject constructor(
    private val mealsRepo: MealsRepository
) : ViewModel()