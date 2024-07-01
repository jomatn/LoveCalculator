package com.example.hw5_2.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.example.hw5_2.data.api.LoveApiServer
import com.example.hw5_2.data.local.dao.LoveDao
import com.example.hw5_2.data.local.db.LoveDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule  {

    @Provides
    fun provideOnBoardPreference(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("shared",Context.MODE_PRIVATE)
    }

    @Singleton
    @Provides
    fun provideRoomDataBase(@ApplicationContext context: Context): LoveDataBase =
        Room.databaseBuilder(context, LoveDataBase::class.java, "LoveDataBase").allowMainThreadQueries().build()

    @Provides
    fun provideDao(loveDataBase: LoveDataBase): LoveDao {
        return loveDataBase.getHistoryDao()
    }
    @Provides
    fun provideRetrofitService(): LoveApiServer {
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(LoveApiServer::class.java)
    }
}