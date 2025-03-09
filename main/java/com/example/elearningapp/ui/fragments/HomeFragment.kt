package com.example.elearningapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.elearningapp.R
import com.example.elearningapp.ui.screens.HomeScreen
import com.example.elearningapp.ui.theme.ELearningAppTheme

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                ELearningAppTheme {
                    HomeScreen(
                        onNavigateToExplore = {
                            findNavController().navigate(R.id.action_home_to_explore)
                        }
                    )
                }
            }
        }
    }
}