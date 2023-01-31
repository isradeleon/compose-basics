package com.example.composeproject

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AppScreen(title: String) {
    Text(
        text = title,
        fontSize = 32.sp,
        fontFamily = FontFamily.Cursive,
        color = colorResource(id = R.color.purple_700),
        modifier = Modifier.fillMaxWidth().padding(17.dp)
    )
}