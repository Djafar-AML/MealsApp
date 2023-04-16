package com.example.mealsapp.network

sealed class Status {
    object Success : Status()
    object Failure : Status()
}