package com.yhr.jfj.todo_ui_compose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.yhr.jfj.todo_ui_compose.taskmanager.data.components.ProfileHeaderComponent
import com.yhr.jfj.todo_ui_compose.taskmanager.data.components.TaskComponent
import com.yhr.jfj.todo_ui_compose.taskmanager.data.components.WelcomeMessageComponent
import com.yhr.jfj.todo_ui_compose.taskmanager.data.taskList
import com.yhr.jfj.todo_ui_compose.ui.theme.LightBlue
import com.yhr.jfj.todo_ui_compose.ui.theme.LightGray
import com.yhr.jfj.todo_ui_compose.ui.theme.TODO_UI_ComposeTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Which screen show currently
            var selectedScreen by remember {
                mutableIntStateOf(1)
            }
            // Screens
            val screens = listOf(
                "Calender",
                "Home",
                "Notification"
            )

            TODO_UI_ComposeTheme {
                Scaffold(
                    bottomBar = {
                        NavigationBar(
                            modifier = Modifier
                                .height(60.dp),
//                                .background(Color.White),
                            containerColor = LightBlue,
                            contentColor = Color.White
                        ) {
                            screens.forEachIndexed { index, _ ->
                                // Give icon for each index
                                val icon: ImageVector = when (index) {
                                    0 -> Icons.Filled.CalendarMonth
                                    1 -> Icons.Filled.Home
                                    2 -> Icons.Filled.Mail
                                    else -> Icons.Filled.Home
                                }

                                NavigationBarItem(
                                    selected = selectedScreen == index,
                                    onClick = {
                                        selectedScreen = index
                                    },
                                    icon = {
                                        Box(
                                            modifier = Modifier
                                                .size(45.dp)
                                                .clip(shape = CircleShape),
//                                                .background(if (selectedScreen == index) Color.Black else Color.White),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Icon(
                                                imageVector = icon,
                                                contentDescription = "Screen",
                                                modifier = Modifier
                                                    .size(50.dp)
                                                    .padding(8.dp),
                                                tint = if (selectedScreen == index) Color.Black else LightGray
                                            )
                                        }
                                    })
                            }
                        }
                    }
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(LightBlue)
                            .padding(
                                top = 8.dp,
                                bottom = 16.dp
                            )


                    ) {
                        ProfileHeaderComponent()

                        Spacer(modifier = Modifier.height(10.dp))

                        WelcomeMessageComponent()

                        Spacer(modifier = Modifier.height(6.dp))

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.White)
                        ) {
                            Spacer(modifier = Modifier.height(10.dp))
                            LazyColumn(
                                contentPadding = PaddingValues(
                                    start = 8.dp
                                )
                            ) {
                                items(taskList) { task ->
                                    TaskComponent(task = task)
                                    Spacer(modifier = Modifier.height(8.dp))
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
