package com.example.elearningapp

import android.app.Application
import com.example.elearningapp.data.DataManager
import com.example.elearningapp.data.manager.ProfileManager

class ELearningApplication : Application() {
    // Lazy initialization of the managers
    val dataManager by lazy {
        DataManager(applicationContext)
    }

    val profileManager by lazy {
        ProfileManager(dataManager)
    }
}

