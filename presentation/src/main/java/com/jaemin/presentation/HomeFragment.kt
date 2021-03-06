package com.jaemin.presentation

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowInsets
import com.jaemin.presentation.base.util.Height.Companion.statusBarHeight
import com.jaemin.presentation.databinding.FragmentHomeBinding
import com.jaemin.presentation.extension.viewBinding

class HomeFragment : Fragment() {

    private val binding by viewBinding(FragmentHomeBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    private fun setupUI(){
        binding.toolBar.setPadding(0, requireContext().statusBarHeight(), 0, 0) // status bar 높이만큼 toolbar top padding 설정
    }
}