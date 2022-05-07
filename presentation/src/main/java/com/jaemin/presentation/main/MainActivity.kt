package com.jaemin.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.PopupMenu
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.jaemin.presentation.R
import com.jaemin.presentation.databinding.ActivityMainBinding
import com.jaemin.presentation.extension.viewInflateBinding

class MainActivity : AppCompatActivity() {

    private val binding by viewInflateBinding(ActivityMainBinding::inflate)
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setNavController()
        setupUI()
    }

    private fun setNavController(){
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer) as NavHostFragment
        navController = navHostFragment.findNavController()
    }

    private fun setupUI(){
        setBottomNav()
    }

    private fun setBottomNav(){
        val popupMenu = PopupMenu(this, null)
        popupMenu.inflate(R.menu.bottom_navigation_menu)
        val menu = popupMenu.menu

        binding.bottomNavigation.setupWithNavController(menu, navController)
    }
}