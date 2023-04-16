package com.example.mealsapp.model.network

import com.squareup.moshi.Json

data class GetMealListResponse(
    @Json(name = "categories")
    val mealList: List<MealResponse> = listOf()
)

data class MealResponse(
    @Json(name = "idCategory")
    val id: String = "",
    @Json(name = "strCategory")
    val name: String = "",
    @Json(name = "strCategoryThumb")
    val imageUrl: String = "",
    @Json(name = "strCategoryDescription")
    val description: String = ""
)
