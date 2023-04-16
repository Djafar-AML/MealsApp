package com.example.mealsapp.ui.meals.vm

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.mealsapp.model.domain.Meal
import com.example.mealsapp.ui.meals.repo.MealsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealsCategoriesViewModel @Inject constructor(
    private val mealsRepo: MealsRepository
) : ViewModel() {


    private val mealListJob = Job()

    init {

        val coroutineScope = CoroutineScope(mealListJob + Dispatchers.IO)
        coroutineScope.launch(Dispatchers.IO) {
            _rememberedList.value = mealList()
        }
    }

    private val _rememberedList: MutableState<List<Meal>> = mutableStateOf(emptyList())
    val rememberedList: State<List<Meal>> = _rememberedList

    private suspend fun mealList() = mealsRepo.mealList()

    override fun onCleared() {
        mealListJob.cancel()
        super.onCleared()
    }
}