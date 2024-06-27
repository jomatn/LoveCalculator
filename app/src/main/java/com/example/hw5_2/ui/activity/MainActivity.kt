package com.example.hw5_2.ui.activity

import com.example.hw5_2.ui.fragment.Love.LoveCalculatorFragment
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.hw5_2.R
import com.example.hw5_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val navController = findNavController(R.id.nav_graph)
        NavigationUI.setupActionBarWithNavController(this, navController)
    }
}