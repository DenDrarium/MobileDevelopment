package com.example.elearningapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.elearningapp.data.DataManager
import com.example.elearningapp.data.manager.ProfileManager
import com.example.elearningapp.ui.navigation.AppNavHost
import com.example.elearningapp.ui.theme.ELearningAppTheme

class MainActivity : ComponentActivity() {
    // Создаем экземпляры менеджеров
    private lateinit var dataManager: DataManager
    private lateinit var profileManager: ProfileManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Инициализируем менеджеры
        dataManager = DataManager(applicationContext)
        profileManager = ProfileManager(dataManager)

        setContent {
            ELearningAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Передаем profileManager в AppNavHost
                    AppNavHost(profileManager = profileManager)
                }
            }
        }
    }
}

