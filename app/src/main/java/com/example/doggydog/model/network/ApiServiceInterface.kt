package com.example.doggydog.model.network

import com.example.doggydog.model.entity.DogItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiServiceInterface {

    @Headers("X-Api-Key:NxiaID6UMa8j+qjEfzHLPA==XLNovD0hOdVTTe9K")
    @GET("dogs")
    fun getDogsByName(@Query("name") name: String): Call<List<DogItem>>

}