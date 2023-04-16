package com.example.mealsapp.model.mapper

import com.example.mealsapp.model.domain.Meal
import com.example.mealsapp.model.network.MealResponse


object MealMapper {

    fun builFrom(mealResponse: MealResponse): Meal {

        return Meal(
            mealResponse.id,
            mealResponse.name,
            mealResponse.imageUrl,
            mealResponse.description
        )

    }

}