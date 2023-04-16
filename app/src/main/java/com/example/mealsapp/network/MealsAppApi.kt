package com.example.mealsapp.network

import com.example.mealsapp.model.network.GetMealListResponse
import retrofit2.Response
import retrofit2.http.GET

interface MealsAppApi {

    @GET("categories.php")
    suspend fun mealList(): Response<GetMealListResponse>

}