package com.example.hw5_2.retrofit

import com.example.hw5_2.data.api.LoveApiServer
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    private var retrofit = Retrofit.Builder()
        .baseUrl("https://love-calculator.p.rapidapi.com/")
        .addConverterFactory(GsonConverterFactory.create()).build()
    val api = retrofit.create(LoveApiServer::class.java)
}
