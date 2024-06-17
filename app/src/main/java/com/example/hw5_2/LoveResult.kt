package com.example.hw5_2

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LoveResult(
    @SerializedName("fname")
    val firstName: String,
    @SerializedName("sname")
    val secondName: String,
    @SerializedName("percentage")
    val percentage: String,
    @SerializedName("result")
    val result: String
)