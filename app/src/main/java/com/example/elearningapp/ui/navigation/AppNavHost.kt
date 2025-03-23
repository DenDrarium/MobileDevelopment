package com.example.elearningapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.elearningapp.data.manager.ProfileManager
import com.example.elearningapp.ui.screens.ExploreScreen
import com.example.elearningapp.ui.screens.HomeScreen
import com.example.elearningapp.ui.screens.ProfileScreen
import com.example.elearningapp.ui.screens.ProgressScreen
import com.example.elearningapp.ui.screens.TrainingScreen


object AppDestinations {
    const val HOME_ROUTE = "home"
    const val EXPLORE_ROUTE = "explore"
    const val TRAINING_ROUTE = "training"
    const val PROGRESS_ROUTE = "progress"
    const val PROFILE_ROUTE = "profile"
}

class AppNavigationActions(navController: NavHostController) {
    val navigateToHome: () -> Unit = {
        navController.navigate(AppDestinations.HOME_ROUTE) {
            popUpTo(AppDestinations.HOME_ROUTE) {
                inclusive = true
            }
        }
    }

    val navigateToExplore: () -> Unit = {
        navController.navigate(AppDestinations.EXPLORE_ROUTE) {
            popUpTo(AppDestinations.HOME_ROUTE)
        }
    }

    val navigateToTraining: () -> Unit = {
        navController.navigate(AppDestinations.TRAINING_ROUTE) {
            popUpTo(AppDestinations.HOME_ROUTE)
        }
    }

    val navigateToProgress: () -> Unit = {
        navController.navigate(AppDestinations.PROGRESS_ROUTE) {
            popUpTo(AppDestinations.HOME_ROUTE)
        }
    }

    val navigateToProfile: () -> Unit = {
        navController.navigate(AppDestinations.PROFILE_ROUTE) {
            popUpTo(AppDestinations.HOME_ROUTE)
        }
    }
}

/**
 * Основной компонент навигации приложения
 */
@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = AppDestinations.HOME_ROUTE,
    profileManager: ProfileManager // Изменили параметр на profileManager
) {
    val navigationActions = remember(navController) {
        AppNavigationActions(navController)
    }

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(AppDestinations.HOME_ROUTE) {
            HomeScreen(
                navigateToExplore = navigationActions.navigateToExplore,
                navigateToTraining = navigationActions.navigateToTraining,
                navigateToProgress = navigationActions.navigateToProgress,
                navigateToProfile = navigationActions.navigateToProfile
            )
        }

        composable(AppDestinations.EXPLORE_ROUTE) {
            ExploreScreen(
                navigateToHome = navigationActions.navigateToHome,
                navigateToTraining = navigationActions.navigateToTraining,
                navigateToProgress = navigationActions.navigateToProgress,
                navigateToProfile = navigationActions.navigateToProfile
            )
        }

        composable(AppDestinations.TRAINING_ROUTE) {
            TrainingScreen(
                navigateToHome = navigationActions.navigateToHome,
                navigateToExplore = navigationActions.navigateToExplore,
                navigateToProgress = navigationActions.navigateToProgress,
                navigateToProfile = navigationActions.navigateToProfile
            )
        }

        composable(AppDestinations.PROGRESS_ROUTE) {
            ProgressScreen(
                navigateToHome = navigationActions.navigateToHome,
                navigateToExplore = navigationActions.navigateToExplore,
                navigateToTraining = navigationActions.navigateToTraining,
                navigateToProfile = navigationActions.navigateToProfile
            )
        }

        composable(AppDestinations.PROFILE_ROUTE) {
            ProfileScreen(
                navigateToHome = navigationActions.navigateToHome,
                navigateToExplore = navigationActions.navigateToExplore,
                navigateToTraining = navigationActions.navigateToTraining,
                navigateToProgress = navigationActions.navigateToProgress,
                profileManager = profileManager // Передаем profileManager в ProfileScreen
            )
        }
    }
}

