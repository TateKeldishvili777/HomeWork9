package com.example.homework9.network

import com.example.homework9.model.RepositoriesList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroServiceInterface {

    @GET("users")
    fun getDataFromAPI(@Query("page") query: String): Call<RepositoriesList>
}