package com.example.mealsapp.network

import com.example.mealsapp.model.network.GetMealListResponse
import retrofit2.Response
import javax.inject.Inject

class ApiClient @Inject constructor(
    private val mealsAppApi: MealsAppApi
) {

    suspend fun mealList(): SimpleResponse<GetMealListResponse> {
        return safeApiCall { mealsAppApi.mealList() }
    }

    private inline fun <T> safeApiCall(apiCall: () -> Response<T>): SimpleResponse<T> {

        return try {
            SimpleResponse.success(apiCall.invoke())
        } catch (e: Exception) {
            SimpleResponse.failure(e)
        }

    }

}