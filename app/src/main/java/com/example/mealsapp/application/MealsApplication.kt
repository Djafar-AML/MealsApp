package com.example.mealsapp.application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

lateinit var application: MealsApplication
    private set

@HiltAndroidApp
class MealsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initApplication()
    }

    private fun initApplication() {
        application = this
    }

}