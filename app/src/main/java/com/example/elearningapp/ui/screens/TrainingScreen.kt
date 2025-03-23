package com.example.elearningapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import coil3.compose.AsyncImage
import com.example.elearningapp.ui.components.BottomNavBar
import com.example.elearningapp.ui.theme.DarkText
import com.example.elearningapp.ui.theme.LightBlue
import com.example.elearningapp.ui.theme.LightGray
import com.example.elearningapp.ui.theme.LightText
import com.example.elearningapp.ui.theme.RedLight

private data class TrainingTopic(
    val title: String,
    val image: String,
    val rating: Double,
    val students: String,
    val likes: String,
    val backgroundColor: Color
)

private data class TrainingExercise(
    val id: String,
    val title: String,
    val image: String,
    val duration: String,
    val backgroundColor: Color
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrainingScreen(
    navigateToHome: () -> Unit = {},
    navigateToExplore: () -> Unit = {},
    navigateToTraining: () -> Unit = {},
    navigateToProgress: () -> Unit = {},
    navigateToProfile: () -> Unit = {}
) {
    // Sample data
    val topics = listOf(
        TrainingTopic("Marketing", "https://img.icons8.com/?size=100&id=117703&format=png&color=000000", 4.7, "4.6k", "9.6k", Color.White),
        TrainingTopic("Management", "https://img.icons8.com/?size=100&id=103933&format=png&color=000000", 4.7, "4.6k", "9.6k", Color.White)
    )

    val exercises = listOf(
        TrainingExercise("1", "Exercise 1", "https://img.icons8.com/?size=100&id=60672&format=png&color=000000", "3hr:45min", RedLight),
        TrainingExercise("2", "Exercise 2", "https://img.icons8.com/?size=100&id=91532&format=png&color=000000", "3hr:45min", Color(0xFFE8F5E9)),
        TrainingExercise("3", "Exercise 3", "https://img.icons8.com/?size=100&id=TRBW69ff3PCb&format=png&color=000000", "3hr:45min", Color(0xFFFCE4EC)),
        TrainingExercise("4", "Exercise 4", "https://img.icons8.com/?size=100&id=12643&format=png&color=000000", "3hr:45min", Color(0xFFFFF8E1))
    )

    // Search state
    var searchQuery by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LightGray)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 80.dp)
        ) {
            // Status bar space (simulated)
            Spacer(modifier = Modifier.height(40.dp))

            // Search Bar
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(24.dp),
                color = Color.White,
                shadowElevation = 2.dp
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    IconButton(
                        onClick = { /* Navigate back */ },
                        modifier = Modifier.size(40.dp)
                    ) {
                        Icon(
                            Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = DarkText
                        )
                    }

                    OutlinedTextField(
                        value = searchQuery,
                        onValueChange = { searchQuery = it },
                        placeholder = { Text("Search your perfect course", color = LightText) },
                        modifier = Modifier
                            .weight(1f)
                            .padding(vertical = 4.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent,
                            containerColor = Color.Transparent
                        ),
                        singleLine = true
                    )

                    IconButton(
                        onClick = { /* Open search */ },
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                    ) {
                        Icon(
                            Icons.Default.Search,
                            contentDescription = "Search",
                            tint = Color(0xFFFF7E36)
                        )
                    }
                }
            }

            // Content
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                // Topics Section
                item {
                    TrainingSectionHeader(
                        title = "Topics",
                        onSeeMoreClick = { /* Navigate to all topics */ }
                    )

                    LazyRow(
                        contentPadding = PaddingValues(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        items(topics) { topic ->
                            TrainingTopicCard(
                                title = topic.title,
                                image = topic.image,
                                rating = topic.rating,
                                students = topic.students,
                                likes = topic.likes,
                                backgroundColor = topic.backgroundColor,
                                onClick = { /* Navigate to topic */ }
                            )
                        }
                    }
                }

                // Practice Section
                item {
                    TrainingSectionHeader(
                        title = "Practice",
                        onSeeMoreClick = { /* Navigate to all practice */ }
                    )
                }

                // Exercise Items
                items(exercises) { exercise ->
                    TrainingExerciseCard(
                        title = exercise.title,
                        image = exercise.image,
                        duration = exercise.duration,
                        backgroundColor = exercise.backgroundColor,
                        onClick = { navigateToTraining() }
                    )
                }
            }
        }

        // Bottom Navigation
        BottomNavBar(
            currentRoute = "training",
            navigateToHome = navigateToHome,
            navigateToExplore = navigateToExplore,
            navigateToTraining = navigateToTraining,
            navigateToProgress = navigateToProgress,
            navigateToProfile = navigateToProfile,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable
private fun TrainingSectionHeader(
    title: String,
    onSeeMoreClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineMedium,
            color = DarkText,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onSeeMoreClick
            )
        ) {
            Text(
                text = "See More",
                style = MaterialTheme.typography.bodyMedium,
                color = DarkText
            )
            Spacer(modifier = Modifier.width(4.dp))
            Icon(
                Icons.Default.ArrowForward,
                contentDescription = "See more",
                tint = DarkText,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TrainingTopicCard(
    title: String,
    image: String,
    rating: Double,
    students: String,
    likes: String,
    backgroundColor: Color,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .width(200.dp)
            .padding(bottom = 20.dp) // Увеличен отступ снизу для кнопки
    ) {
        // Основная карточка
        Card(
            onClick = onClick,
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFFEFFFF)),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleMedium,
                        color = DarkText,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )

                    Icon(
                        imageVector = Icons.Outlined.Bookmark,
                        contentDescription = "Bookmark",
                        tint = Color.Gray
                    )
                }

                // Изображение
                AsyncImage(
                    model = image,
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                        .padding(vertical = 12.dp)
                )

                // Статистика
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            Icons.Default.Person,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp),
                            tint = LightText
                        )
                        Text(
                            text = students,
                            fontSize = 12.sp,
                            color = LightText,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            Icons.Default.Star,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp),
                            tint = LightText
                        )
                        Text(
                            text = rating.toString(),
                            fontSize = 12.sp,
                            color = LightText,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            Icons.Default.Favorite,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp),
                            tint = LightText
                        )
                        Text(
                            text = likes,
                            fontSize = 12.sp,
                            color = LightText,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }
                }
            }
        }

        Box(
            modifier = Modifier
                .size(32.dp)
                .align(Alignment.BottomCenter)
                .offset(y = 16.dp)
                .zIndex(1f)
                .clip(CircleShape)
                .background(LightBlue)
                .clickable(onClick = onClick),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                Icons.Default.ArrowForward,
                contentDescription = "Go to topic",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TrainingExerciseCard(
    title: String,
    image: String,
    duration: String,
    backgroundColor: Color,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFEFFFF)),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(backgroundColor)
                    .padding(8.dp)
            ) {
                AsyncImage(
                    model = image,
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.fillMaxSize(),
                )
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    color = DarkText,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row {
                    repeat(5) {
                        Icon(
                            imageVector = Icons.Outlined.Star,
                            contentDescription = null,
                            tint = Color(0xFFE0E0E0),
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Timer,
                        contentDescription = null,
                        tint = LightText,
                        modifier = Modifier.size(16.dp)
                    )
                    Text(
                        text = duration,
                        style = MaterialTheme.typography.bodySmall,
                        color = LightText,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
            }

            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(LightBlue)
                    .clickable(onClick = onClick),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    Icons.Default.ArrowForward,
                    contentDescription = "Go to exercise",
                    tint = Color.White,
                    modifier = Modifier.size(32.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TrainingScreenPreview() {
    TrainingScreen()
}

