package com.example.lab0312bt02

import retrofit2.http.GET

interface ApiService {
    @GET("user")
    suspend fun getUsers(): List<User>
}