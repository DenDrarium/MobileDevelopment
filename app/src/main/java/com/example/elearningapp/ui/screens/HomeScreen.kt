package com.example.elearningapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.elearningapp.R
import com.example.elearningapp.ui.components.BottomNavBar
import com.example.elearningapp.ui.theme.Blue
import com.example.elearningapp.ui.theme.BlueLight
import com.example.elearningapp.ui.theme.DarkBlue
import com.example.elearningapp.ui.theme.DarkPurple
import com.example.elearningapp.ui.theme.ELearningAppTheme
import com.example.elearningapp.ui.theme.LightBlue
import com.example.elearningapp.ui.theme.LightGray
import com.example.elearningapp.ui.theme.Purple
import com.example.elearningapp.ui.theme.RedLight
import com.example.elearningapp.ui.theme.YellowLight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navigateToHome: () -> Unit = {},
    navigateToExplore: () -> Unit = {},
    navigateToTraining: () -> Unit = {},
    navigateToProgress: () -> Unit = {},
    navigateToProfile: () -> Unit = {}
) {
    val scrollState = rememberScrollState()
    Box(modifier = Modifier
        .fillMaxSize()
        .background(LightGray)) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "E-Learning Platform",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    },
                    actions = {
                        IconButton(onClick = { /* Notification action */ }) {
                            Icon(
                                imageVector = Icons.Default.Notifications,
                                contentDescription = "Notifications",
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                        IconButton(onClick = { /* Menu action */ }) {
                            Icon(
                                imageVector = Icons.Default.MoreVert,
                                contentDescription = "Menu"
                            )
                        }
                    }
                )
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 80.dp)
                    .verticalScroll(scrollState)
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 24.dp),
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .background(
                                brush = Brush.horizontalGradient(
                                    colors = listOf(
                                        DarkBlue,
                                        Purple
                                    )
                                )
                            )
                            .padding(16.dp)
                    ) {
                        Column {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 24.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Box(
                                        modifier = Modifier
                                            .size(80.dp)
                                            .clip(CircleShape)
                                            .background(Color.White)
                                            .padding(3.dp)
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.profile_placeholder),
                                            contentDescription = "Profile Image",
                                            modifier = Modifier
                                                .fillMaxSize()
                                                .clip(CircleShape),
                                            contentScale = ContentScale.Crop
                                        )
                                    }

                                    Spacer(modifier = Modifier.width(16.dp))

                                    Column {
                                        Text(
                                            text = "Davia Waley",
                                            color = Color.White,
                                            fontSize = 22.sp,
                                            fontWeight = FontWeight.Bold
                                        )
                                        Text(
                                            text = "Beginner",
                                            color = Color.White.copy(alpha = 0.9f),
                                            fontSize = 16.sp
                                        )
                                    }
                                }

                                Box(
                                    modifier = Modifier
                                        .size(40.dp)
                                        .clip(CircleShape)
                                        .background(Color.White.copy(alpha = 0.2f)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Edit,
                                        contentDescription = "Edit Profile",
                                        tint = Color.White,
                                        modifier = Modifier.size(20.dp)
                                    )
                                }
                            }


                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                // Total XP
                                Card(
                                    modifier = Modifier.weight(1f),
                                    colors = CardDefaults.cardColors(
                                        containerColor = Color.White
                                    ),
                                    shape = RoundedCornerShape(12.dp)
                                ) {
                                    Column(
                                        modifier = Modifier.padding(16.dp),
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Text(
                                            text = "Total XP",
                                            color = Color.Gray,
                                            fontSize = 14.sp
                                        )

                                        Row(
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier.padding(top = 8.dp)
                                        ) {
                                            Text(
                                                text = "⚡",
                                                fontSize = 24.sp,
                                                modifier = Modifier.padding(end = 8.dp)
                                            )

                                            Text(
                                                text = "11.900",
                                                color = Color.Black,
                                                fontWeight = FontWeight.Bold,
                                                fontSize = 22.sp
                                            )
                                        }
                                    }
                                }

                                //  Study Time
                                Card(
                                    modifier = Modifier.weight(1f),
                                    colors = CardDefaults.cardColors(
                                        containerColor = Color.White
                                    ),
                                    shape = RoundedCornerShape(12.dp)
                                ) {
                                    Column(
                                        modifier = Modifier.padding(16.dp),
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Text(
                                            text = "Study Time",
                                            color = Color.Gray,
                                            fontSize = 14.sp
                                        )

                                        Row(
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier.padding(top = 8.dp)
                                        ) {
                                            // Clock
                                            Box(
                                                modifier = Modifier
                                                    .size(28.dp)
                                                    .padding(end = 8.dp)
                                            ) {
                                                Icon(
                                                    imageVector = Icons.Default.Schedule,
                                                    contentDescription = "Study Time",
                                                    tint = Color(0xFF4CAF50),
                                                    modifier = Modifier.size(24.dp)
                                                )
                                            }

                                            Text(
                                                text = "50",
                                                color = Color.Black,
                                                fontWeight = FontWeight.Bold,
                                                fontSize = 22.sp
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                // Daily quests
                Column(modifier = Modifier.padding(bottom = 24.dp)) {
                    Text(
                        text = "Daily quests",
                        color = DarkPurple,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(bottom = 16.dp)
                            .align(Alignment.CenterHorizontally)
                    )

                    Card(
                        shape = RoundedCornerShape(24.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            // Quest 1
                            Column(
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(48.dp)
                                            .clip(CircleShape)
                                            .background(RedLight),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(
                                            text = "🎯",
                                            fontSize = 24.sp
                                        )
                                    }

                                    Spacer(modifier = Modifier.width(16.dp))

                                    Column(modifier = Modifier.weight(1f)) {
                                        Text(
                                            text = "Get an accuracy score of 80% or higher in 3 lessons",
                                            fontSize = 16.sp,
                                            fontWeight = FontWeight.Medium,
                                            lineHeight = 22.sp
                                        )
                                    }
                                }

                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(start = 64.dp, top = 12.dp, end = 8.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(8.dp)
                                            .clip(RoundedCornerShape(4.dp))
                                            .background(Color(0xFFF0F0F0))
                                    )
                                    Text(
                                        text = "0/3",
                                        fontSize = 14.sp,
                                        color = Color.Gray,
                                        modifier = Modifier.padding(top = 12.dp)
                                    )
                                }
                            }

                            Divider(color = Color(0xFFF0F0F0), thickness = 1.dp)

                            // Quest 2
                            Column(
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(48.dp)
                                            .clip(CircleShape)
                                            .background(YellowLight),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(
                                            text = "✓",
                                            fontSize = 24.sp,
                                            color = Color(0xFFD4B106)
                                        )
                                    }

                                    Spacer(modifier = Modifier.width(16.dp))

                                    Column(modifier = Modifier.weight(1f)) {
                                        Text(
                                            text = "Completed 3 lessons without making any mistakes",
                                            fontSize = 16.sp,
                                            fontWeight = FontWeight.Medium,
                                            lineHeight = 22.sp
                                        )
                                    }
                                }
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(start = 64.dp, top = 12.dp, end = 8.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(8.dp)
                                            .clip(RoundedCornerShape(4.dp))
                                            .background(Color(0xFFF0F0F0))
                                    )
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth(0.33f)
                                            .height(8.dp)
                                            .clip(RoundedCornerShape(4.dp))
                                            .background(Blue)
                                    )
                                    Text(
                                        text = "1/3",
                                        fontSize = 14.sp,
                                        color = Color.Gray,
                                        modifier = Modifier.padding(top = 12.dp)
                                    )
                                }
                            }

                            Divider(color = Color(0xFFF0F0F0), thickness = 1.dp)

                            // Quest 3
                            Column(
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(48.dp)
                                            .clip(CircleShape)
                                            .background(BlueLight),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(
                                            text = "⚡",
                                            fontSize = 24.sp
                                        )
                                    }

                                    Spacer(modifier = Modifier.width(16.dp))

                                    Column(modifier = Modifier.weight(1f)) {
                                        Text(
                                            text = "Gain 35 XP in timed challenge",
                                            fontSize = 16.sp,
                                            fontWeight = FontWeight.Medium,
                                            lineHeight = 22.sp
                                        )
                                    }
                                }

                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(start = 64.dp, top = 12.dp, end = 8.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(8.dp)
                                            .clip(RoundedCornerShape(4.dp))
                                            .background(Color(0xFFF0F0F0))
                                    )

                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth(0.66f)
                                            .height(8.dp)
                                            .clip(RoundedCornerShape(4.dp))
                                            .background(Blue)
                                    )

                                    Text(
                                        text = "2/3",
                                        fontSize = 14.sp,
                                        color = Color.Gray,
                                        modifier = Modifier.padding(top = 12.dp)
                                    )
                                }
                            }
                        }
                    }
                }
                Column(modifier = Modifier.padding(bottom = 24.dp)) {
                    Text(
                        text = "Preview Course Overview",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(bottom = 16.dp)
                            .align(Alignment.CenterHorizontally)
                    )

                    Card(
                        shape = RoundedCornerShape(16.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        modifier = Modifier.padding(bottom = 16.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            //  Play
                            Box(
                                modifier = Modifier
                                    .size(56.dp)
                                    .clip(CircleShape)
                                    .background(LightBlue),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.PlayArrow,
                                    contentDescription = "Play",
                                    tint = Color.White,
                                    modifier = Modifier.size(32.dp)
                                )
                            }

                            Spacer(modifier = Modifier.width(16.dp))

                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = "Introduction",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 18.sp
                                )
                                Text(
                                    text = "2.56 min",
                                    color = Color.Gray,
                                    fontSize = 14.sp
                                )
                            }

                            Icon(
                                imageVector = Icons.Default.ChevronRight,
                                contentDescription = "View",
                                tint = Color.Gray,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }
                    Card(
                        shape = RoundedCornerShape(16.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White)
                    ) {
                        Column(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            // Tabs
                            var selectedTabIndex by remember { mutableStateOf(0) }
                            val tabs = listOf("Overview", "Information", "Certificate", "Grades")

                            LazyRow(
                                modifier = Modifier.fillMaxWidth(),
                                contentPadding = PaddingValues(horizontal = 8.dp)
                            ) {
                                items(tabs.indices.toList()) { index ->
                                    val title = tabs[index]
                                    Tab(
                                        selected = selectedTabIndex == index,
                                        onClick = { selectedTabIndex = index },
                                        modifier = Modifier
                                            .padding(vertical = 8.dp, horizontal = 4.dp)
                                            .background(
                                                if (selectedTabIndex == index) DarkPurple.copy(alpha = 0.1f) else Color.Transparent,
                                                RoundedCornerShape(16.dp)
                                            ),
                                        text = {
                                            Text(
                                                text = title,
                                                fontSize = 16.sp,
                                                fontWeight = if (selectedTabIndex == index) FontWeight.Bold else FontWeight.Normal,
                                                color = if (selectedTabIndex == index) DarkPurple else Color.Gray,
                                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                            )
                                        }
                                    )
                                }
                            }

                            Box(
                                modifier = Modifier
                                    .padding(horizontal = 16.dp)
                                    .fillMaxWidth()
                                    .height(3.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth(1f / tabs.size)
                                        .height(3.dp)
                                        .background(DarkPurple)
                                        .padding(start = (selectedTabIndex * (1f / tabs.size) * 100).dp)
                                )
                            }

                            // Tab Content
                            Box(modifier = Modifier.padding(16.dp)) {
                                when (selectedTabIndex) {
                                    0 -> {
                                        // Overview Tab Content
                                        Column(verticalArrangement = Arrangement.spacedBy(24.dp)) {
                                            Row(
                                                modifier = Modifier.fillMaxWidth(),
                                                horizontalArrangement = Arrangement.SpaceBetween,
                                                verticalAlignment = Alignment.Top
                                            ) {
                                                Column(modifier = Modifier.weight(1f)) {
                                                    Text(
                                                        text = "6hr 40min to go",
                                                        fontWeight = FontWeight.Bold,
                                                        fontSize = 18.sp
                                                    )

                                                    Spacer(modifier = Modifier.height(8.dp))
                                                    Box(
                                                        modifier = Modifier
                                                            .fillMaxWidth(0.7f)
                                                            .height(8.dp)
                                                            .clip(RoundedCornerShape(4.dp))
                                                            .background(
                                                                Brush.horizontalGradient(
                                                                    colors = listOf(
                                                                        Color(0xFFFF9800),
                                                                        Color(0xFFFFE082)
                                                                    )
                                                                )
                                                            )
                                                    )

                                                    Spacer(modifier = Modifier.height(8.dp))

                                                    Text(
                                                        text = "2 assignments due",
                                                        color = Color.Gray,
                                                        fontSize = 14.sp
                                                    )
                                                }
                                                IconButton(
                                                    onClick = { /* Download action */ },
                                                    modifier = Modifier
                                                        .size(48.dp)
                                                        .clip(CircleShape)
                                                        .border(1.dp, Color(0xFFE0E0E0), CircleShape)
                                                ) {
                                                    Icon(
                                                        imageVector = Icons.Default.Download,
                                                        contentDescription = "Download",
                                                        tint = Color.Black,
                                                        modifier = Modifier.size(24.dp)
                                                    )
                                                }
                                            }

                                            Divider(color = Color(0xFFF0F0F0), thickness = 1.dp)

                                            // Lecture Sliders
                                            Row(
                                                modifier = Modifier.fillMaxWidth(),
                                                verticalAlignment = Alignment.CenterVertically,
                                                horizontalArrangement = Arrangement.SpaceBetween
                                            ) {
                                                Row(
                                                    verticalAlignment = Alignment.CenterVertically,
                                                    modifier = Modifier.weight(1f)
                                                ) {
                                                    // Document Icon
                                                    Box(
                                                        modifier = Modifier
                                                            .size(40.dp)
                                                            .clip(RoundedCornerShape(8.dp))
                                                            .background(Color.White),
                                                        contentAlignment = Alignment.Center
                                                    ) {
                                                        Text(text = "📄", fontSize = 20.sp)
                                                    }

                                                    Spacer(modifier = Modifier.width(16.dp))

                                                    Column {
                                                        Text(
                                                            text = "Lecture Sliders",
                                                            fontWeight = FontWeight.Bold,
                                                            fontSize = 16.sp
                                                        )
                                                        Text(
                                                            text = "Reading• 20 min",
                                                            color = Color.Gray,
                                                            fontSize = 14.sp
                                                        )
                                                    }
                                                }

                                                IconButton(
                                                    onClick = { /* Download action */ },
                                                    modifier = Modifier
                                                        .size(48.dp)
                                                        .clip(CircleShape)
                                                        .border(1.dp, Color(0xFFE0E0E0), CircleShape)
                                                ) {
                                                    Icon(
                                                        imageVector = Icons.Default.Download,
                                                        contentDescription = "Download",
                                                        tint = Color.Black,
                                                        modifier = Modifier.size(24.dp)
                                                    )
                                                }
                                            }

                                            Divider(color = Color(0xFFF0F0F0), thickness = 1.dp)

                                            // Introduction Quiz
                                            Row(
                                                modifier = Modifier.fillMaxWidth(),
                                                verticalAlignment = Alignment.CenterVertically,
                                                horizontalArrangement = Arrangement.SpaceBetween
                                            ) {
                                                Row(
                                                    verticalAlignment = Alignment.CenterVertically,
                                                    modifier = Modifier.weight(1f)
                                                ) {
                                                    Box(
                                                        modifier = Modifier
                                                            .size(40.dp)
                                                            .clip(RoundedCornerShape(8.dp))
                                                            .background(Color.White),
                                                        contentAlignment = Alignment.Center
                                                    ) {
                                                        Text(text = "❓", fontSize = 20.sp)
                                                    }

                                                    Spacer(modifier = Modifier.width(16.dp))

                                                    Column {
                                                        Text(
                                                            text = "Introduction",
                                                            fontWeight = FontWeight.Bold,
                                                            fontSize = 16.sp
                                                        )
                                                        Text(
                                                            text = "Quiz• 5 Questions",
                                                            color = Color.Gray,
                                                            fontSize = 14.sp
                                                        )
                                                    }
                                                }
                                                IconButton(
                                                    onClick = { /* Download action */ },
                                                    modifier = Modifier
                                                        .size(48.dp)
                                                        .clip(CircleShape)
                                                        .border(1.dp, Color(0xFFE0E0E0), CircleShape)
                                                ) {
                                                    Icon(
                                                        imageVector = Icons.Default.Download,
                                                        contentDescription = "Download",
                                                        tint = Color.Black,
                                                        modifier = Modifier.size(24.dp)
                                                    )
                                                }
                                            }
                                        }
                                    }

                                    else -> Box(modifier = Modifier.height(200.dp)) {
                                        Text(text = "Content for ${tabs[selectedTabIndex]} tab")
                                    }
                                }
                            }
                        }
                    }
                }

                // Start Learning 
                Button(
                    onClick = { /* Start learning action */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .clip(RoundedCornerShape(28.dp)),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
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
                                )
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Start Learning",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Icon(
                                imageVector = Icons.Default.ChevronRight,
                                contentDescription = "Start",
                                tint = Color.White
                            )
                        }
                    }
                }
            }
        }
        BottomNavBar(
            modifier = Modifier.align(Alignment.BottomCenter),
            currentRoute = "home",
            navigateToHome = navigateToHome,
            navigateToExplore = navigateToExplore,
            navigateToTraining = navigateToTraining,
            navigateToProgress = navigateToProgress,
            navigateToProfile = navigateToProfile,
        )
    }
}

@Preview(showBackground = true, device = "spec:width=1080px,height=4000px,dpi=440")
@Composable
fun HomeScreenPreview() {
    ELearningAppTheme {
        HomeScreen()
    }
}

