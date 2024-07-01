package com.example.hw5_2.ui.fragment.OnBoard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.hw5_2.Pref
import com.example.hw5_2.R
import com.example.hw5_2.databinding.FragmentOnBoardBinding
import com.google.android.material.tabs.TabLayoutMediator

class OnBoardFragment : Fragment() {

    private val binding by lazy {
        FragmentOnBoardBinding.inflate(layoutInflater)
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
            findNavController().navigate(R.id.action_onBoardFragment_to_loveCalculatorFragment)
        } else {
            setupViewPager()
        }
    }

    private fun setupViewPager() {
        val adapter = OnBoardPagingAdapter(requireActivity())
        binding.viewPager.adapter = adapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { _, _ -> }.attach()
    }
}
