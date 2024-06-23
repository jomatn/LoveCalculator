package com.example.hw5_2.data.api

import com.example.hw5_2.LoveResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApiServer {

    @GET("getPercentage")
    fun getPercentage(
        @Header("X-Rapidapi-Key") key: String,
        @Header("X-RapiDapi-Host") host: String,
        @Query("fname") firstName: String,
        @Query("sname") secondName: String
    ): Call<LoveResult>
}