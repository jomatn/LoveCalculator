package com.example.hw5_2.data

import com.example.hw5_2.App
import com.example.hw5_2.LoveResult
import com.example.hw5_2.data.contract.LoveCalculatorContract
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoveCalculatorPresenter(private val view: LoveCalculatorContract.View) : LoveCalculatorContract.Presenter {

    override fun calculateLovePercentage(firstName: String, secondName: String) {
        App().api.getPercentage(
            key = "13db8c0c9fmsh0e8b65404615b3ap1035a5jsn85bfe5faab5c",
            host = "love-calculator.p.rapidapi.com",
            firstName = firstName,
            secondName = secondName
        ).enqueue(object : Callback<LoveResult> {
            override fun onResponse(call: Call<LoveResult>, response: Response<LoveResult>) {
                if (response.isSuccessful && response.body() != null) {
                    view.showResult(response.body()!!)
                } else {
                    view.showError("Error: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<LoveResult>, t: Throwable) {
                view.showError("Failure: ${t.message}")
            }
        })
    }
}