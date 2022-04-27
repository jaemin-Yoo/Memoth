package com.jaemin.presentation.main

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import com.jaemin.presentation.R
import com.jaemin.presentation.databinding.ActivityMainBinding
import com.jaemin.presentation.extension.viewInflateBinding
import com.zagori.bottomnavbar.BottomNavBar

class MainActivity : AppCompatActivity() {

    private val binding by viewInflateBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initToolBar()
        binding.bottomNavigation.setBottomNavigationListener(object: BottomNavBar.OnBottomNavigationListener{
            override fun onNavigationItemSelected(menuItem: MenuItem?): Boolean {
                return when(menuItem!!.itemId){
                    R.id.menu_home -> {
                        binding.toolBar.title = ""
                        supportActionBar?.setDisplayHomeAsUpEnabled(true)
                        true
                    }
                    R.id.menu_book -> {
                        binding.toolBar.title = "단어장"
                        supportActionBar?.setDisplayHomeAsUpEnabled(false)
                        true
                    }
                    R.id.menu_add -> {
                        binding.toolBar.title = "단어추가"
                        supportActionBar?.setDisplayHomeAsUpEnabled(false)
                        true
                    }
                    R.id.menu_test -> {
                        binding.toolBar.title = "테스트"
                        supportActionBar?.setDisplayHomeAsUpEnabled(false)
                        true
                    }
                    R.id.menu_profile -> {
                        binding.toolBar.title = "프로필"
                        supportActionBar?.setDisplayHomeAsUpEnabled(false)
                        true
                    }
                    else -> false
                }
            }
        })
    }

    private fun initToolBar() {
        binding.toolBar.title = ""
        setSupportActionBar(binding.toolBar) // 툴바 사용

        supportActionBar?.setDisplayHomeAsUpEnabled(true) // 뒤로가기 버튼 활성화
        supportActionBar?.setHomeAsUpIndicator(R.drawable.main_logo) // 뒤로가기 버튼 이미지 수정
    }
}