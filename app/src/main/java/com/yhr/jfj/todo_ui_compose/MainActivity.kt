package com.yhr.jfj.todo_ui_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.yhr.jfj.todo_ui_compose.taskmanager.data.components.ProfileHeaderComponent
import com.yhr.jfj.todo_ui_compose.taskmanager.data.components.WelcomeMessageComponent
import com.yhr.jfj.todo_ui_compose.ui.theme.TODO_UI_ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TODO_UI_ComposeTheme {
                LazyColumn(
                    contentPadding = PaddingValues(
                        top = 16.dp,
                        start = 16.dp,
                        bottom = 16.dp
                    )
                ) {
                    item {
                        ProfileHeaderComponent()
                    }
                    item {
                        Spacer(modifier = Modifier.height(30.dp))
                        WelcomeMessageComponent()
                        Spacer(modifier = Modifier.height(30.dp))
                    }
                }
            }
        }
    }
}
