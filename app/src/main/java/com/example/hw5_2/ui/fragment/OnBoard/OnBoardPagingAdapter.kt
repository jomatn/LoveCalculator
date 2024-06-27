package com.example.hw5_2.ui.fragment.OnBoard

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class OnBoardPagingAdapter (fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        val fragment = OnBoardPagingFragment()
        fragment.arguments = Bundle().apply {
            putInt(OnBoardPagingFragment.ARG_ON_BOARD_POSITION, position)
        }
        return fragment
    }
}