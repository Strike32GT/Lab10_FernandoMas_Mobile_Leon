package com.mas.semana10_servicios.data.repository

import com.mas.semana10_servicios.data.model.User
import com.mas.semana10_servicios.data.remote.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserRepository {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val apiService= retrofit.create(ApiService::class.java)

    suspend fun getUsers(): List<User>{
        return apiService.getUsers()
    }
}