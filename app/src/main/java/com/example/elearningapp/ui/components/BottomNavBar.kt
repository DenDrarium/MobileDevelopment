package com.example.elearningapp.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.BarChart
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.PieChart
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.elearningapp.ui.theme.DarkPurple

@Composable
fun BottomNavBar(
    currentRoute: String,
    navigateToHome: () -> Unit,
    navigateToExplore: () -> Unit,
    navigateToTraining: () -> Unit,
    navigateToProgress: () -> Unit,
    navigateToProfile: () -> Unit,
    modifier: Modifier = Modifier
) {
    // Define colors
    val inactiveGray = Color(0xFFBEBEBE)

    Box(modifier = modifier.fillMaxWidth()) {
        // Main navigation bar
        Surface(
            color = Color.White,
            shadowElevation = 8.dp,
            shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Home
                NavItem(
                    icon = if (currentRoute == "home") Icons.Filled.Home else Icons.Outlined.Home,
                    label = "Home",
                    isSelected = currentRoute == "home",
                    onClick = navigateToHome,
                    selectedColor = DarkPurple,
                    unselectedColor = inactiveGray,
                    modifier = Modifier.weight(1f)
                )

                // Explore
                NavItem(
                    icon = if (currentRoute == "explore") Icons.Filled.Search else Icons.Outlined.Search,
                    label = "Explore",
                    isSelected = currentRoute == "explore",
                    onClick = navigateToExplore,
                    selectedColor = DarkPurple,
                    unselectedColor = inactiveGray,
                    modifier = Modifier.weight(1f)
                )

                // Training
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.weight(1f)

                ) {
                    // Empty space for the FAB
                    Spacer(modifier = Modifier.height(24.dp))

                    // Text below the FAB
                    Text(
                        text = "Training",
                        color = if (currentRoute == "training") DarkPurple else inactiveGray,
                        fontSize = 12.sp,
                        fontWeight = if (currentRoute == "training") FontWeight.Medium else FontWeight.Normal,
                        textAlign = TextAlign.Center,
                        //modifier = Modifier.padding(top = 8.dp)
                    )
                }

                // Progress
                NavItem(
                    icon = if (currentRoute == "progress") Icons.Filled.BarChart else Icons.Outlined.BarChart,
                    label = "Progress",
                    isSelected = currentRoute == "progress",
                    onClick = navigateToProgress,
                    selectedColor = DarkPurple,
                    unselectedColor = inactiveGray,
                    modifier = Modifier.weight(1f)
                )

                // Profile
                NavItem(
                    icon = if (currentRoute == "profile") Icons.Filled.Person else Icons.Outlined.Person,
                    label = "Profile",
                    isSelected = currentRoute == "profile",
                    onClick = navigateToProfile,
                    selectedColor = DarkPurple,
                    unselectedColor = inactiveGray,
                    modifier = Modifier.weight(1f)
                )
            }
        }

        // Floating action button for Training
        FloatingActionButton(
            onClick = navigateToTraining,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = (-20).dp)
                .size(56.dp),
            containerColor = DarkPurple,
            contentColor = Color.White,
            shape = CircleShape
        ) {
            Icon(
                imageVector = Icons.Outlined.PieChart,
                contentDescription = "Training",
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
private fun NavItem(
    icon: ImageVector,
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    selectedColor: Color,
    unselectedColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(bottom = 4.dp)
    ) {
        IconButton(
            onClick = onClick,
            modifier = Modifier.size(24.dp)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = if (isSelected) selectedColor else unselectedColor,
                modifier = Modifier.size(24.dp)
            )
        }

        Text(
            text = label,
            color = if (isSelected) selectedColor else unselectedColor,
            fontSize = 12.sp,
            fontWeight = if (isSelected) FontWeight.Medium else FontWeight.Normal,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavBarPreview() {
    BottomNavBar(
        currentRoute = "home",
        navigateToHome = {},
        navigateToExplore = {},
        navigateToTraining = {},
        navigateToProgress = {},
        navigateToProfile = {}
    )
}