package com.example.hw5_2.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.example.hw5_2.LoveResult
import com.example.hw5_2.R
import com.example.hw5_2.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    private val binding: FragmentResultBinding by lazy {
        FragmentResultBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fillData()
    }

    private fun fillData() = with(binding) {
        val firstName = arguments?.getString("firstName")
        val secondName = arguments?.getString("secondName")
        val percentage = arguments?.getInt("percentage")

        tvYouResult.text = firstName
        tvMeResult.text = secondName
        tvProcent.text = "$percentage%"

        btnTryAgain.setOnClickListener {
            val loveCalculatorFragment = LoveCalculatorFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, loveCalculatorFragment).addToBackStack(null).commit()

        }
    }
}
