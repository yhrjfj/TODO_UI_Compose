package com.yhr.jfj.todo_ui_compose.taskmanager.data.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yhr.jfj.todo_ui_compose.R
import com.yhr.jfj.todo_ui_compose.ui.theme.Orange

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileHeaderComponent() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 12.dp
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(id = (R.drawable.image)),
            contentDescription = "Profile",
            modifier = Modifier
                .size(45.dp)
                .clip(CircleShape),
        )
        Text(
            text = "TODO",
            fontSize = 30.sp,
            fontFamily = FontFamily(Font(R.font.nunito_extrabold))
        )
        BadgedBox(
            badge = {
                Badge(
                    containerColor = Orange,
                    contentColor = Color.White,
                    modifier = Modifier.offset(x = (-6).dp, y = 8.dp)
                ) {
                    Text(
                        text = "5",
                    )
                }
            },
            modifier = Modifier
                .padding(end = 16.dp)
        ) {
            Image(
                imageVector = Icons.Filled.Notifications,
                contentDescription = "notification"
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ProfileHeaderComponentPreview() {
    ProfileHeaderComponent()
}