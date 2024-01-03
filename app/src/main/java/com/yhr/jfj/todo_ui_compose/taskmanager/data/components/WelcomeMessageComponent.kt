package com.yhr.jfj.todo_ui_compose.taskmanager.data.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yhr.jfj.todo_ui_compose.R
import com.yhr.jfj.todo_ui_compose.ui.theme.LightGray

@Composable
fun WelcomeMessageComponent() {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Hi Shadow",
            fontFamily = FontFamily(Font(R.font.nunito_extrabold)),
            fontSize = 22.sp
        )
        Text(
            text = "8 task for today",
            fontFamily = FontFamily(Font(R.font.nunito_regular)),
            fontSize = 18.sp,
            color = LightGray
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun WelcomeMessageComponentPreview() {
    WelcomeMessageComponent()
}