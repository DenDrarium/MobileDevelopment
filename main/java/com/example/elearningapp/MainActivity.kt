package com.example.elearningapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.elearningapp.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Настройка Navigation Component
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        // Настройка Bottom Navigation
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.setupWithNavController(navController)

        // Настройка FAB
        binding.fab.setOnClickListener {
            // Действие для FAB
        }

        // Скрытие/отображение нижней навигации и FAB на определенных экранах
        navController.addOnDestinationChangedListener { _, destination, _ ->
            val shouldShowBottomNav = when (destination.id) {
                R.id.homeFragment, R.id.exploreFragment,
                R.id.trainingFragment, R.id.progressFragment,
                R.id.profileFragment -> true
                else -> false
            }

            if (shouldShowBottomNav) {
                binding.bottomNavigation.visibility = View.VISIBLE
                binding.fab.show()
            } else {
                binding.bottomNavigation.visibility = View.GONE
                binding.fab.hide()
            }
        }
    }

    // Обработка навигации "назад"
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}