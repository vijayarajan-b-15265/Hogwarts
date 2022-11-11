package com.example.mailjet.network

import com.example.mailjet.model.HogwartsDetailsHelper
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitInterface {

    @GET("api/characters")
    suspend fun getHogwartsDetails(): Response<List<HogwartsDetailsHelper>>
}