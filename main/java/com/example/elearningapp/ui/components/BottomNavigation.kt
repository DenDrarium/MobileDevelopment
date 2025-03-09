package com.example.elearningapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.elearningapp.ui.theme.Purple

@Composable
fun BottomNavigationBar(
    currentRoute: String,
    onNavigate: (String) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
    ) {
        NavigationBar(
            modifier = Modifier.fillMaxWidth(),
            containerColor = Color.White,
            contentColor = Color.Gray
        ) {
            BottomNavItem(
                icon = Icons.Default.Home,
                label = "Home",
                selected = currentRoute == "home",
                onClick = { onNavigate("home") }
            )

            BottomNavItem(
                icon = Icons.Default.Search,
                label = "Explore",
                selected = currentRoute == "explore",
                onClick = { onNavigate("explore") }
            )

            // Empty space for FAB
            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Spacer(modifier = Modifier.fillMaxSize())
            }

            BottomNavItem(
                icon = Icons.Default.BarChart,
                label = "Progress",
                selected = currentRoute == "progress",
                onClick = { onNavigate("progress") }
            )

            BottomNavItem(
                icon = Icons.Default.Person,
                label = "Profile",
                selected = currentRoute == "profile",
                onClick = { onNavigate("profile") }
            )
        }

        // Floating Action Button
        FloatingActionButton(
            onClick = { onNavigate("training") },
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = (-20).dp),
            containerColor = Purple,
            contentColor = Color.White
        ) {
            Icon(
                imageVector = Icons.Default.Book,
                contentDescription = "Training"
            )
        }
    }
}

@Composable
fun RowScope.BottomNavItem(
    icon: ImageVector,
    label: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    NavigationBarItem(
        icon = {
            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = if (selected) Purple else Color.Gray
            )
        },
        label = {
            Text(
                text = label,
                fontSize = 12.sp,
                color = if (selected) Purple else Color.Gray
            )
        },
        selected = selected,
        onClick = onClick
    )
}