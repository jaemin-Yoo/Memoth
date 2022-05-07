package com.jaemin.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.PopupMenu
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
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

    override fun onSupportNavigateUp() = navController.navigateUp()

    private fun setNavController(){
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer) as NavHostFragment
        navController = navHostFragment.findNavController()
    }

    private fun setupUI(){
        initToolBar()
        setBottomNav()
    }

    private fun initToolBar() {
        binding.toolBar.title = ""
        setSupportActionBar(binding.toolBar) // 툴바 사용

        supportActionBar?.setDisplayHomeAsUpEnabled(true) // 뒤로가기 버튼 활성화
        supportActionBar?.setHomeAsUpIndicator(R.drawable.main_logo) // 뒤로가기 버튼 이미지 수정
    }

    private fun setBottomNav(){
        val popupMenu = PopupMenu(this, null)
        popupMenu.inflate(R.menu.bottom_navigation_menu)
        val menu = popupMenu.menu

        binding.bottomNavigation.setupWithNavController(menu, navController)
        setupActionBarWithNavController(navController)
    }
}