package com.example.mealsapp.ui.meals.repo

import com.example.mealsapp.model.domain.Meal
import com.example.mealsapp.model.mapper.MealMapper
import com.example.mealsapp.model.network.GetMealListResponse
import com.example.mealsapp.network.ApiClient
import com.example.mealsapp.network.SimpleResponse
import javax.inject.Inject

class MealsRepository @Inject constructor(
    private val apiClient: ApiClient
) {

    suspend fun mealList(): List<Meal> {

        val response: SimpleResponse<GetMealListResponse> = apiClient.mealList()

        if (response.failed || response.isSuccessful.not()) {
            return emptyList()
        }

        val mealList: List<Meal> = response.body.mealList.map { mealResponse ->
            MealMapper.builFrom(mealResponse)
        }

        return mealList

    }

}