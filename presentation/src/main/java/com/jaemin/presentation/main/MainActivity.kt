package com.jaemin.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.jaemin.presentation.R
import com.jaemin.presentation.databinding.ActivityMainBinding
import com.jaemin.presentation.extension.viewInflateBinding
import com.zagori.bottomnavbar.BottomNavBar

class MainActivity : AppCompatActivity() {

    private val binding by viewInflateBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.bottomNavigation.setBottomNavigationListener(object: BottomNavBar.OnBottomNavigationListener{
            override fun onNavigationItemSelected(menuItem: MenuItem?): Boolean {
                return when(menuItem!!.itemId){
                    R.id.menu_home -> {
                        true
                    }
                    R.id.menu_book -> {
                        true
                    }
                    R.id.menu_add -> {
                        true
                    }
                    R.id.menu_test -> {
                        true
                    }
                    R.id.menu_profile -> {
                        true
                    }
                    else -> false
                }
            }
        })
    }
}