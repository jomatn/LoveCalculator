package com.example.hw5_2.ui.fragment.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.hw5_2.Pref
import com.example.hw5_2.R
import com.example.hw5_2.databinding.FragmentOnStartBinding

class OnStartFragment : Fragment() {

    private val binding by lazy {
        FragmentOnStartBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (Pref.isOnboardingComplete(requireContext())) {
            findNavController().navigate(R.id.action_onStartFragment_to_loveCalculatorFragment)
        } else {
            binding.btnStart.setOnClickListener {
                findNavController().navigate(R.id.action_onStartFragment_to_onBoardFragment)
            }
        }
    }
}
