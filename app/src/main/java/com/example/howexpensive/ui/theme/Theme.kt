package com.example.howexpensive.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = Colors.Purple80,
    secondary = Colors.PurpleGrey80,
    tertiary = Colors.Pink80
)

@Composable
fun HowExpensiveTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = Typography,
        content = content
    )
}