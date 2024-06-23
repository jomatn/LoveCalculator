package com.example.hw5_2.ui.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.hw5_2.data.LoveCalculatorReprository.LoveCalculatorRepository
import com.example.hw5_2.data.model.LoveResult


class LoveCalculatorViewModel: ViewModel() {

    private val repository = LoveCalculatorRepository()

    fun getLoveResults(firstName: String, secondName: String): LiveData<LoveResult> {
        return repository.getLoveResult(firstName, secondName)
    }

}