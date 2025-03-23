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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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
import androidx.compose.material.icons.outlined.Bookmark
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

data class Topic(
    val title: String,
    val image: String,
    val rating: Double,
    val students: String,
    val likes: String,
    val backgroundColor: Color,
    val isBookmarked: Boolean = false
)

data class LessonModule(
    val id: String,
    val title: String,
    val image: String,
    val rating: Double,
    val students: String,
    val likes: String,
    val isBookmarked: Boolean = false
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExploreScreen(
    navigateToHome: () -> Unit = {},
    navigateToTraining: () -> Unit = {},
    navigateToExplore: () -> Unit = {},
    navigateToProgress: () -> Unit = {},
    navigateToProfile: () -> Unit = {}
) {
    // Sample data
    val topics = listOf(
        Topic("Science", "https://img.icons8.com/?size=100&id=zmOCnmAT7REd&format=png&color=000000", 4.7, "4.6k", "9.6k", Color.White),
        Topic("Business", "https://img.icons8.com/?size=100&id=117497&format=png&color=000000", 4.7, "4.6k", "9.6k", Color.White)
    )

    val lessonModules = listOf(
        LessonModule("1", "Lesson 1", "https://img.icons8.com/?size=100&id=Y0Q6iXZwCV2C&format=png&color=000000", 4.7, "4.6k", "9.6k", true),
        LessonModule("2", "Lesson 2", "https://img.icons8.com/?size=100&id=6z5qQ9Ey7xCQ&format=png&color=000000", 4.7, "4.6k", "9.6k", false),
        LessonModule("3", "Lesson 3", "https://img.icons8.com/?size=100&id=xUYOQprbKlf9&format=png&color=000000", 4.7, "4.6k", "9.6k", false),
        LessonModule("4", "Lesson 4", "https://img.icons8.com/?size=100&id=b1F4ht94fEHn&format=png&color=000000", 4.7, "4.6k", "9.6k", false),
        LessonModule("5", "Lesson 5", "https://img.icons8.com/?size=100&id=44076&format=png&color=000000", 4.7, "4.6k", "9.6k", false),
        LessonModule("6", "Lesson 6", "https://img.icons8.com/?size=100&id=101841&format=png&color=000000", 4.7, "4.6k", "9.6k", true)
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
                contentPadding = PaddingValues(bottom = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // Topics Section
                item {
                    Column {
                        SectionHeader(
                            title = "Topics",
                            onSeeMoreClick = { /* Navigate to all topics */ }
                        )

                        LazyRow(
                            contentPadding = PaddingValues(horizontal = 16.dp),
                            horizontalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            items(topics) { topic ->
                                TopicCard(
                                    title = topic.title,
                                    image = topic.image,
                                    rating = topic.rating,
                                    students = topic.students,
                                    likes = topic.likes,
                                    backgroundColor = Color.White,
                                    isBookmarked = topic.isBookmarked,
                                    onClick = { /* Navigate to topic */ }
                                )
                            }
                        }
                    }
                }

                // Learning Modules Section
                item {
                    Column {
                        SectionHeader(
                            title = "Learning Modules",
                            onSeeMoreClick = { /* Navigate to all modules */ }
                        )

                        LazyVerticalGrid(
                            columns = GridCells.Fixed(2),
                            contentPadding = PaddingValues(horizontal = 16.dp),
                            horizontalArrangement = Arrangement.spacedBy(16.dp),
                            verticalArrangement = Arrangement.spacedBy(24.dp),
                            modifier = Modifier.height(600.dp)
                        ) {
                            items(lessonModules) { module ->
                                LessonModuleCard(
                                    title = module.title,
                                    image = module.image,
                                    rating = module.rating,
                                    students = module.students,
                                    likes = module.likes,
                                    isBookmarked = module.isBookmarked,
                                    onClick = { navigateToTraining() }
                                )
                            }
                        }
                    }
                }
            }
        }

        // Bottom Navigation
        BottomNavBar(
            currentRoute = "explore",
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
fun SectionHeader(
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
            fontWeight = FontWeight.Bold
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
fun TopicCard(
    title: String,
    image: String,
    rating: Double,
    students: String,
    likes: String,
    backgroundColor: Color,
    isBookmarked: Boolean = false,
    onClick: () -> Unit
) {
    Box {
        Card(
            onClick = onClick,
            modifier = Modifier
                .width(200.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFFEFFFF)),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(modifier = Modifier.padding(12.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleLarge,
                        color = DarkText,
                        fontWeight = FontWeight.Bold
                    )

                    Icon(
                        imageVector = Icons.Outlined.Bookmark,
                        contentDescription = "Bookmark",
                        tint = if (isBookmarked) Color(0xFFFF7E36) else Color.Gray,
                        modifier = Modifier.size(24.dp)
                    )
                }

                AsyncImage(
                    model = image,
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                        .padding(vertical = 12.dp)
                )

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

                Spacer(modifier = Modifier.height(16.dp))
            }
        }
        Box(
            modifier = Modifier
                .size(44.dp)
                .align(Alignment.BottomCenter)
                .offset(y = 22.dp)
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
                modifier = Modifier.size(28.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LessonModuleCard(
    title: String,
    image: String,
    rating: Double,
    students: String,
    likes: String,
    isBookmarked: Boolean = false,
    onClick: () -> Unit
) {
    Box {
        Card(
            onClick = onClick,
            modifier = Modifier
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFFEFFFF)),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(modifier = Modifier.padding(12.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleMedium,
                        color = DarkText,
                        fontWeight = FontWeight.Medium
                    )

                    Icon(
                        imageVector = Icons.Outlined.Bookmark,
                        contentDescription = "Bookmark",
                        tint = if (isBookmarked) Color(0xFFFF7E36) else Color.Gray
                    )
                }

                AsyncImage(
                    model = image,
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .padding(vertical = 8.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            Icons.Default.Person,
                            contentDescription = null,
                            modifier = Modifier.size(14.dp),
                            tint = LightText
                        )
                        Text(
                            text = students,
                            fontSize = 10.sp,
                            color = LightText,
                            modifier = Modifier.padding(start = 2.dp)
                        )
                    }

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            Icons.Default.Star,
                            contentDescription = null,
                            modifier = Modifier.size(14.dp),
                            tint = LightText
                        )
                        Text(
                            text = rating.toString(),
                            fontSize = 10.sp,
                            color = LightText,
                            modifier = Modifier.padding(start = 2.dp)
                        )
                    }

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            Icons.Default.Favorite,
                            contentDescription = null,
                            modifier = Modifier.size(14.dp),
                            tint = LightText
                        )
                        Text(
                            text = likes,
                            fontSize = 10.sp,
                            color = LightText,
                            modifier = Modifier.padding(start = 2.dp)
                        )
                    }
                }


                Spacer(modifier = Modifier.height(16.dp))
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
                contentDescription = "Go to lesson",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun ExploreScreenPreview() {
    ExploreScreen()
}

