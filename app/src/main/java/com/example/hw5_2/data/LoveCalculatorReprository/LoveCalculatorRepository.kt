package com.example.hw5_2.data.LoveCalculatorReprository

import androidx.lifecycle.MutableLiveData
import com.example.hw5_2.data.model.LoveResult
import com.example.hw5_2.retrofit.RetrofitService

class LoveCalculatorRepository {

    private val api = RetrofitService.api
    private var loveResults = MutableLiveData<LoveResult>()

    fun getLoveResult(firstName: String, secondName: String): MutableLiveData<LoveResult> {
        api.getPercentage(
            firstName = firstName,
            secondName = secondName
        ).enqueue(object :
            retrofit2.Callback<LoveResult> {
            override fun onResponse(
                call: retrofit2.Call<LoveResult>,
                response: retrofit2.Response<LoveResult>
            ) {
                loveResults.value = response.body()
            }

            override fun onFailure(call: retrofit2.Call<LoveResult>, t: Throwable) {
                t.printStackTrace()
            }
        })
        return loveResults
    }

}
