package com.example.hw5_2.ui.fragment.OnBoard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.hw5_2.Pref
import com.example.hw5_2.R
import com.example.hw5_2.databinding.FragmentOnBoardPagingBinding

class OnBoardPagingFragment : Fragment() {
    private val binding by lazy {
        FragmentOnBoardPagingBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() {
        val position = arguments?.getInt(ARG_ON_BOARD_POSITION) ?: 0
        with(binding) {
            when (position) {
                0 -> {
                    tvTitle.text = "Have a good time"
                    tvDescription.text = "You should take the time to help those who need you"
                    imageView.setImageResource(R.drawable.img_onboard_1)
                }
                1 -> {
                    tvTitle.text = "Cherishing love"
                    tvDescription.text = "It's now no longer possible for you to cherish love"
                    imageView.setImageResource(R.drawable.img_onboard_2)
                }
                2 -> {
                    tvTitle.text = "Have a breakup?"
                    tvDescription.text = "We have made the correction for you don't worry. Maybe someone is waiting for you!"
                    imageView.setImageResource(R.drawable.img_onboard_3)
                    btnStart.visibility = View.VISIBLE
                    btnStart.setOnClickListener {
                        Pref.setOnboardingComplete(requireContext(), true)
                        findNavController().navigate(R.id.action_onBoardFragment_to_loveCalculatorFragment)
                    }
                }
            }
        }
    }

    companion object {
        const val ARG_ON_BOARD_POSITION = "onBoardPosition"
    }
}
