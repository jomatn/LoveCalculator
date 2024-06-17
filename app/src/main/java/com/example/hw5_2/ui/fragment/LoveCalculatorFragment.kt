package com.example.hw5_2.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.hw5_2.data.App
import com.example.hw5_2.LoveResult
import com.example.hw5_2.R
import com.example.hw5_2.databinding.FragmentLoveCalculatorBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class LoveCalculatorFragment : Fragment() {

    private val binding by lazy {
        FragmentLoveCalculatorBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        btnCalculate.setOnClickListener {
            val firstName = etFname.text.toString()
            val secondName = etSname.text.toString()

            if (firstName.isBlank() || secondName.isBlank()) {
                Toast.makeText(requireContext(), "Enter both names", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            App().api?.getPercentage(
                firstName = firstName,
                key = "13db8c0c9fmsh0e8b65404615b3ap1035a5jsn85bfe5faab5c",
                host = "love-calculator.p.rapidapi.com",
                secondName = secondName
            )?.enqueue(object : Callback<LoveResult> {
                override fun onResponse(call: Call<LoveResult>, response: Response<LoveResult>) {
                    if (response.isSuccessful && response.body() != null) {

                        val result = response.body()
                        val percentage = result?.percentage?.toIntOrNull() ?: 0
                        val bundle = Bundle().apply {
                            putString("firstName", firstName)
                            putString("secondName", secondName)
                            putInt("percentage", percentage)
                        }
                        val resultFragment = ResultFragment().apply {
                            arguments = bundle
                        }
                        parentFragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, resultFragment)
                            .addToBackStack(null).commit()
                    } else {
                        Toast.makeText(requireContext(), "Error: ${response.message()}", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<LoveResult>, t: Throwable) {
                    Toast.makeText(requireContext(), "Failure: ${t.message}", Toast.LENGTH_LONG).show()
                }
            })
        }
    }
}

