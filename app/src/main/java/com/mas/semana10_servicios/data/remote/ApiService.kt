package com.mas.semana10_servicios.data.remote

import com.mas.semana10_servicios.data.model.User
import retrofit2.http.GET

interface ApiService{

    @GET("users")
    suspend fun getUsers(): List<User>
}