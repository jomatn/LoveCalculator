package com.example.hw5_2.data.contract

import com.example.hw5_2.LoveResult

interface LoveCalculatorContract {
    interface View {
        fun showResult(result: LoveResult)
        fun showError(message: String)
    }

    interface Presenter {
        fun calculateLovePercentage(firstName: String, secondName: String)
    }
}
