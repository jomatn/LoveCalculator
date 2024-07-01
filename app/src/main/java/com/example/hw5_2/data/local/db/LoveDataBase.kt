package com.example.hw5_2.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hw5_2.data.local.entity.HistoryEntity
import com.example.hw5_2.data.local.dao.LoveDao

@Database(entities = [HistoryEntity::class], version = 1)
abstract class LoveDataBase: RoomDatabase() {

    abstract fun getHistoryDao(): LoveDao
}