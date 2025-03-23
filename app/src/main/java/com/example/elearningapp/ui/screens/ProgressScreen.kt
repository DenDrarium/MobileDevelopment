package com.example.elearningapp.ui.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.elearningapp.R
import com.example.elearningapp.ui.components.BottomNavBar
import com.example.elearningapp.ui.theme.Blue
import com.example.elearningapp.ui.theme.DarkBlue
import com.example.elearningapp.ui.theme.DarkPurple
import com.example.elearningapp.ui.theme.DarkText
import com.example.elearningapp.ui.theme.LightGray
import com.example.elearningapp.ui.theme.Purple

data class Achievement(
    val id: String,
    val title: String,
    val icon: String
)

@Composable
fun ProgressScreen(
    navigateToHome: () -> Unit = {},
    navigateToExplore: () -> Unit = {},
    navigateToTraining: () -> Unit = {},
    navigateToProgress: () -> Unit = {},
    navigateToProfile: () -> Unit = {}
) {
    val scrollState = rememberScrollState()

    // Список достижений
    val achievements = listOf(
        Achievement(id = "1", title = "Ach 1", icon = "🚩"),
        Achievement(id = "2", title = "Ach 2", icon = "🔥"),
        Achievement(id = "3", title = "Ach 3", icon = "👋"),
        Achievement(id = "4", title = "Ach 4", icon = "🌙")
    )

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(bottom = 80.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(
                        RoundedCornerShape(
                            topStart = 0.dp,
                            topEnd = 0.dp,
                            bottomStart = 24.dp,
                            bottomEnd = 24.dp
                        )
                    )
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
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Progress",
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )

                        IconButton(onClick = { /* Notification action */ }) {
                            Icon(
                                imageVector = Icons.Default.Notifications,
                                contentDescription = "Notifications",
                                tint = Color.Black,
                                modifier = Modifier.size(28.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    // Profile image
                    Box(
                        modifier = Modifier
                            .size(120.dp)
                            .clip(CircleShape)
                            .background(Color.White)
                            .padding(4.dp)
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

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Davia Waley",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    Text(
                        text = "Beginner",
                        fontSize = 16.sp,
                        color = DarkText
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    // XP and Study Time cards
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        // Total XP Card
                        Card(
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(16.dp),
                            colors = CardDefaults.cardColors(containerColor = Color(0xFFFEFFFF)),
                            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "Total XP",
                                    fontSize = 14.sp,
                                    color = Color.Gray
                                )

                                Spacer(modifier = Modifier.height(8.dp))

                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "⚡",
                                        fontSize = 24.sp,
                                        color = Color(0xFFFFA726)
                                    )

                                    Spacer(modifier = Modifier.width(8.dp))

                                    Text(
                                        text = "11.900",
                                        fontSize = 22.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.Black
                                    )
                                }
                            }
                        }

                        // Study Time Card
                        Card(
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(16.dp),
                            colors = CardDefaults.cardColors(containerColor = Color(0xFFFEFFFF)),
                            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "Study Time",
                                    fontSize = 14.sp,
                                    color = Color.Gray
                                )

                                Spacer(modifier = Modifier.height(8.dp))

                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_clock),
                                        contentDescription = "Clock",
                                        tint = Color(0xFF4CAF50),
                                        modifier = Modifier.size(24.dp)
                                    )

                                    Spacer(modifier = Modifier.width(8.dp))

                                    Text(
                                        text = "50",
                                        fontSize = 22.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.Black
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // Statistical section with centered title
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Statistical",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    textAlign = TextAlign.Center
                )

                // First row of stat cards with reduced height
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    // Challenges Card
                    StatisticalCard(
                        icon = "🔥",
                        value = "104",
                        label = "Challenges",
                        modifier = Modifier.weight(1f)
                    )

                    // Level Card
                    StatisticalCard(
                        icon = "📚",
                        value = "6",
                        label = "Level",
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Second row of stat cards with reduced height
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    // Excellent Card
                    StatisticalCard(
                        icon = "🎯",
                        value = "20",
                        label = "Excellent",
                        modifier = Modifier.weight(1f)
                    )

                    // Top 3 Card
                    StatisticalCard(
                        icon = "🏆",
                        value = "15",
                        label = "Top 3",
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Overview chart with fixed positioning
                OverviewChartFixed()

                Spacer(modifier = Modifier.height(24.dp))

                // Achievement section
                Text(
                    text = "Achievement",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    textAlign = TextAlign.Center
                )

                // Achievement cards with horizontal scrolling
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp)
                ) {
                    items(achievements) { achievement ->
                        AchievementCard(
                            title = achievement.title,
                            icon = achievement.icon,
                            modifier = Modifier.width(150.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Calendar
                CalendarCard()
            }
        }

        // Bottom Navigation
        BottomNavBar(
            modifier = Modifier.align(Alignment.BottomCenter),
            currentRoute = "progress",
            navigateToHome = navigateToHome,
            navigateToExplore = navigateToExplore,
            navigateToTraining = navigateToTraining,
            navigateToProgress = navigateToProgress,
            navigateToProfile = navigateToProfile
        )
    }
}

@Composable
fun StatisticalCard(
    icon: String,
    value: String,
    label: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFEFFFF)),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp, horizontal = 16.dp)
        ) {
            Text(
                text = icon,
                fontSize = 24.sp
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = value,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Text(
                text = label,
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
    }
}

@Composable
fun OverviewChartFixed() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFEFFFF)),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            // Header
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Overview",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                Text(
                    text = "780 XP",
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Chart with Y-axis labels side by side
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                // Y-axis labels
                Column(
                    modifier = Modifier
                        .width(40.dp)
                        .height(200.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "1000",
                        fontSize = 12.sp,
                        color = Color.Gray
                    )

                    Text(
                        text = "800",
                        fontSize = 12.sp,
                        color = Color.Gray
                    )

                    Text(
                        text = "600",
                        fontSize = 12.sp,
                        color = Color.Gray
                    )

                    Text(
                        text = "400",
                        fontSize = 12.sp,
                        color = Color.Gray
                    )

                    Text(
                        text = "200",
                        fontSize = 12.sp,
                        color = Color.Gray
                    )

                    Text(
                        text = "0",
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                }

                // Chart area
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(200.dp)
                ) {
                    // Gradient area
                    Canvas(modifier = Modifier.fillMaxSize()) {
                        val width = size.width
                        val height = size.height

                        // Create a path for the curved line
                        val path = Path().apply {
                            moveTo(0f, height * 0.6f)
                            cubicTo(
                                width * 0.2f, height * 0.7f,
                                width * 0.4f, height * 0.5f,
                                width * 0.6f, height * 0.7f
                            )
                            cubicTo(
                                width * 0.8f, height * 0.3f,
                                width * 0.9f, height * 0.5f,
                                width, height * 0.6f
                            )
                            lineTo(width, height)
                            lineTo(0f, height)
                            close()
                        }

                        // Gradient fill
                        drawPath(
                            path = path,
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Purple.copy(alpha = 0.5f),
                                    Color.Transparent
                                )
                            )
                        )

                        // Curved line
                        drawPath(
                            path = path,
                            color = Purple,
                            style = Stroke(width = 3f, cap = StrokeCap.Round)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // X-axis labels
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 40.dp), // Align with the chart
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                listOf("Mo", "Tu", "We", "Th", "Fr", "Sa", "Su").forEach { day ->
                    Text(
                        text = day,
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                }
            }
        }
    }
}

@Composable
fun AchievementCard(
    title: String,
    icon: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFEFFFF)),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp, horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = icon,
                fontSize = 32.sp
            )
        }
    }
}

@Composable
fun CalendarCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFEFFFF)),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            // Month navigation
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { /* Previous month */ }) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = "Previous month",
                        tint = Color.Black
                    )
                }

                Text(
                    text = "October 2022",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black
                )

                IconButton(onClick = { /* Next month */ }) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = "Next month",
                        tint = Color.Black
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Days of week header
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                listOf("Mo", "Tu", "We", "Th", "Fr", "Sa", "Su").forEach { day ->
                    Text(
                        text = day,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Calendar grid
            CalendarGrid()
        }
    }
}

@Composable
fun CalendarGrid() {
    // Sample calendar data for October 2022
    val days = listOf(
        listOf("", "", "", "", "", "", "1"),
        listOf("2", "3", "4", "5", "6", "7", "8"),
        listOf("9", "10", "11", "12", "13", "14", "15"),
        listOf("16", "17", "18", "19", "20", "21", "22"),
        listOf("23", "24", "25", "26", "27", "28", "29"),
        listOf("30", "31", "", "", "", "", "")
    )

    // Highlighted days with different colors
    val purpleDays = listOf("25", "26")
    val grayDays = listOf("27", "28")
    val blueDays = listOf("28")

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        days.forEach { week ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                week.forEach { day ->
                    if (day.isEmpty()) {
                        // Empty space for days not in this month
                        Box(modifier = Modifier.size(32.dp))
                    } else {
                        // Day cell
                        Box(
                            modifier = Modifier
                                .size(32.dp)
                                .clip(CircleShape)
                                .background(
                                    when {
                                        day in purpleDays -> DarkPurple
                                        day in grayDays -> LightGray
                                        else -> Color.Transparent
                                    }
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = day,
                                fontSize = 14.sp,
                                color = when {
                                    day in purpleDays -> Color.White
                                    day in blueDays -> Blue
                                    else -> Color.Black
                                },
                                fontWeight = if (day in purpleDays || day in blueDays) FontWeight.Bold else FontWeight.Normal
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, device = "spec:width=1080px,height=4000px,dpi=440")
@Composable
fun ProgressScreenPreview() {
    ProgressScreen()
}
