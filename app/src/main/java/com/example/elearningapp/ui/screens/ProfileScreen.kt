package com.example.elearningapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CreditCard
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Help
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material.icons.outlined.LocalOffer
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.TrendingUp
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.elearningapp.R
import com.example.elearningapp.data.DataManager
import com.example.elearningapp.data.manager.ProfileManager
import com.example.elearningapp.ui.components.BottomNavBar
import com.example.elearningapp.ui.theme.DarkBlue
import com.example.elearningapp.ui.theme.LightGray
import com.example.elearningapp.ui.theme.Purple
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ProfileScreen(
    navigateToHome: () -> Unit = {},
    navigateToExplore: () -> Unit = {},
    navigateToTraining: () -> Unit = {},
    navigateToProgress: () -> Unit = {},
    navigateToProfile: () -> Unit = {},
    profileManager: ProfileManager? = null // Принимаем profileManager из Activity через навигацию
) {
    // Создаем локальный контекст для предпросмотра
    val context = LocalContext.current

    // Используем переданный profileManager или создаем локальный для предпросмотра
    val actualProfileManager = profileManager ?: remember {
        ProfileManager(DataManager(context))
    }
    val coroutineScope = rememberCoroutineScope()

    // Получаем данные из ProfileManager
    val userName by actualProfileManager.userNameFlow.collectAsState(initial = "")
    val userEmail by actualProfileManager.userEmailFlow.collectAsState(initial = "")
    val notificationsEnabled by actualProfileManager.notificationsEnabledFlow.collectAsState(initial = true)
    val isLoading by actualProfileManager.isLoading.collectAsState()
    val error by actualProfileManager.error.collectAsState()

    // Состояние для UI диалогов
    var showEditNameDialog by remember { mutableStateOf(false) }
    var showEditEmailDialog by remember { mutableStateOf(false) }
    var tempName by remember { mutableStateOf("") }
    var tempEmail by remember { mutableStateOf("") }

    // Очистка сообщения об ошибке
    LaunchedEffect(error) {
        if (error != null) {
            delay(3000)
            actualProfileManager.clearError()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LightGray)
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = Purple
            )
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(bottom = 80.dp)
            ) {
                // Profile header
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(LightGray)
                        .padding(16.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Profile image
                        Image(
                            painter = painterResource(id = R.drawable.profile_placeholder),
                            contentDescription = "Profile Image",
                            modifier = Modifier
                                .size(60.dp)
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                        Column {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = if (userName.isEmpty()) "Davia Waley" else userName,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold
                                )

                                Spacer(modifier = Modifier.width(8.dp))

                                Icon(
                                    imageVector = Icons.Outlined.Edit,
                                    contentDescription = "Edit Profile",
                                    tint = Purple,
                                    modifier = Modifier
                                        .size(16.dp)
                                        .clickable {
                                            tempName = userName
                                            showEditNameDialog = true
                                        }
                                )
                            }

                            Text(
                                text = if (userEmail.isEmpty()) "info.khanclub@gmail.com" else userEmail,
                                fontSize = 14.sp,
                                color = Color.Gray,
                                modifier = Modifier.clickable {
                                    tempEmail = userEmail
                                    showEditEmailDialog = true
                                }
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(1.dp))

                // Settings menu
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(LightGray)
                ) {
                    SettingsItem(
                        icon = Icons.Outlined.TrendingUp,
                        title = "Skill Development",
                        onClick = {}
                    )

                    Divider()

                    SettingsItem(
                        icon = Icons.Outlined.Person,
                        title = "My Details",
                        onClick = {}
                    )

                    Divider()

                    SettingsItem(
                        icon = Icons.Outlined.LocationOn,
                        title = "My Address",
                        onClick = {}
                    )

                    Divider()

                    SettingsItem(
                        icon = Icons.Outlined.CreditCard,
                        title = "Payment Methods",
                        onClick = {}
                    )

                    Divider()

                    SettingsItem(
                        icon = Icons.Outlined.LocalOffer,
                        title = "Promo Cord",
                        onClick = {}
                    )

                    Divider()

                    // Notifications setting with switch
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Notifications,
                            contentDescription = "Notifications",
                            tint = Color.Black,
                            modifier = Modifier.size(24.dp)
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                        Text(
                            text = "Notifications",
                            fontSize = 16.sp,
                            modifier = Modifier.weight(1f)
                        )

                        Switch(
                            checked = notificationsEnabled,
                            onCheckedChange = { enabled ->
                                coroutineScope.launch {
                                    actualProfileManager.updateNotificationsEnabled(enabled)
                                }
                            }
                        )
                    }

                    Divider()

                    SettingsItem(
                        icon = Icons.Outlined.Help,
                        title = "Help",
                        onClick = {}
                    )

                    Divider()

                    SettingsItem(
                        icon = Icons.Outlined.Info,
                        title = "About",
                        onClick = {}
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                // Logout button
                Button(
                    onClick = { /* Logout action */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .height(56.dp),
                    shape = RoundedCornerShape(28.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = Color.White
                    ),
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                brush = Brush.horizontalGradient(
                                    colors = listOf(
                                        DarkBlue,
                                        Purple
                                    )
                                ),
                                shape = RoundedCornerShape(28.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Log out",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }

            // Edit Name Dialog
            if (showEditNameDialog) {
                AlertDialog(
                    onDismissRequest = { showEditNameDialog = false },
                    title = { Text("Edit Name") },
                    text = {
                        OutlinedTextField(
                            value = tempName,
                            onValueChange = { tempName = it },
                            label = { Text("Name") },
                            singleLine = true
                        )
                    },
                    confirmButton = {
                        TextButton(
                            onClick = {
                                if (tempName.isNotBlank()) {
                                    coroutineScope.launch {
                                        actualProfileManager.updateUserName(tempName)
                                    }
                                }
                                showEditNameDialog = false
                            }
                        ) {
                            Text("Save")
                        }
                    },
                    dismissButton = {
                        TextButton(onClick = { showEditNameDialog = false }) {
                            Text("Cancel")
                        }
                    }
                )
            }

            // Edit Email Dialog
            if (showEditEmailDialog) {
                AlertDialog(
                    onDismissRequest = { showEditEmailDialog = false },
                    title = { Text("Edit Email") },
                    text = {
                        OutlinedTextField(
                            value = tempEmail,
                            onValueChange = { tempEmail = it },
                            label = { Text("Email") },
                            singleLine = true
                        )
                    },
                    confirmButton = {
                        TextButton(
                            onClick = {
                                if (tempEmail.isNotBlank()) {
                                    coroutineScope.launch {
                                        actualProfileManager.updateUserEmail(tempEmail)
                                    }
                                }
                                showEditEmailDialog = false
                            }
                        ) {
                            Text("Save")
                        }
                    },
                    dismissButton = {
                        TextButton(onClick = { showEditEmailDialog = false }) {
                            Text("Cancel")
                        }
                    }
                )
            }

            // Error Snackbar
            if (error != null) {
                Snackbar(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(16.dp)
                        .padding(bottom = 80.dp)
                ) {
                    Text(error!!)
                }
            }
        }

        // Bottom Navigation
        BottomNavBar(
            modifier = Modifier.align(Alignment.BottomCenter),
            currentRoute = "profile",
            navigateToHome = navigateToHome,
            navigateToExplore = navigateToExplore,
            navigateToTraining = navigateToTraining,
            navigateToProgress = navigateToProgress,
            navigateToProfile = navigateToProfile
        )
    }
}

@Composable
fun SettingsItem(
    icon: ImageVector,
    title: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = title,
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = title,
            fontSize = 16.sp,
            modifier = Modifier.weight(1f)
        )

        Icon(
            imageVector = Icons.Outlined.KeyboardArrowRight,
            contentDescription = "Navigate",
            tint = Color.Gray
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}

