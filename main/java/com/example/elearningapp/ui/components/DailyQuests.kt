package com.example.elearningapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.elearningapp.ui.theme.Purple
import com.example.elearningapp.ui.theme.RedLight
import com.example.elearningapp.ui.theme.YellowLight
import com.example.elearningapp.ui.theme.BlueLight

@Composable
fun DailyQuests() {
    Column(modifier = Modifier.padding(bottom = 24.dp)) {
        Text(
            text = "Daily quests",
            color = Purple,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Card(
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                QuestItem(
                    icon = "🎯",
                    backgroundColor = RedLight,
                    title = "Get an accuracy score of 80% or higher in 3 lessons",
                    progress = 0f,
                    progressText = "0/3"
                )

                QuestItem(
                    icon = "✓",
                    backgroundColor = YellowLight,
                    title = "Completed 3 lessons without making any mistakes",
                    progress = 0.33f,
                    progressText = "1/3"
                )

                QuestItem(
                    icon = "⚡",
                    backgroundColor = BlueLight,
                    title = "Gain 35 XP in timed challenge",
                    progress = 0.66f,
                    progressText = "2/3"
                )
            }
        }
    }
}

@Composable
fun QuestItem(
    icon: String,
    backgroundColor: Color,
    title: String,
    progress: Float,
    progressText: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(backgroundColor),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = icon,
                fontSize = 20.sp
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(8.dp))

            LinearProgressIndicator(
                progress = progress,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(4.dp),
                color = Purple,
                trackColor = Color.LightGray
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = progressText,
                fontSize = 12.sp,
                color = Color.Gray
            )
        }
    }
}