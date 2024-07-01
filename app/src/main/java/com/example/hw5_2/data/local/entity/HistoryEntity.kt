package com.example.hw5_2.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "histories")
data class HistoryEntity(
    @PrimaryKey val id: Int = 0,
    @ColumnInfo(name = "first_name") val firstName: String,
    @ColumnInfo (name = "second_name") val secondName: String,
    @ColumnInfo (name = "percent") val percentage: String,
    )