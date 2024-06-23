package com.example.hw5_2

import android.app.Application
import com.example.hw5_2.data.api.LoveApiServer
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App: Application() {
    var api: LoveApiServer = Retrofit.Builder()
        .baseUrl("https://love-calculator.p.rapidapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(LoveApiServer::class.java)
}