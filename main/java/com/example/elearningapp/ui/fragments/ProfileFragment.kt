package com.example.elearningapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.elearningapp.ui.screens.ProfileScreen
import com.example.elearningapp.ui.theme.ELearningAppTheme

class ProfileFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                ELearningAppTheme {
                    ProfileScreen(
                        onNavigateToSettings = { settingType ->
                            val action = ProfileFragmentDirections
                                .actionProfileToSettings(settingType)
                            findNavController().navigate(action)
                        },
                        onLogout = {
                            // Обработка выхода из аккаунта
                        }
                    )
                }
            }
        }
    }
}