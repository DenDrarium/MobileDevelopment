package com.example.elearningapp.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val LightColorScheme = lightColorScheme(
    primary = Purple,
    onPrimary = Color.White,
    secondary = Blue,
    onSecondary = Color.White,
    tertiary = LightPurple,
    background = LightGray,
    surface = Color.White,
    onSurface = DarkText,
    onBackground = DarkText
)

private val DarkColorScheme = darkColorScheme(
    primary = Purple,
    onPrimary = Color.White,
    secondary = Blue,
    onSecondary = Color.White,
    tertiary = LightPurple,
    background = DarkGray,
    surface = Gray,
    onSurface = Color.White,
    onBackground = Color.White
)

@Composable
fun ELearningAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.background.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}