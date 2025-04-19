package com.example.slideshowapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.slideshowapp.ui.theme.SlideshowAppTheme  // Replace with your actual theme name if needed

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Wrap your content in your theme
            SlideshowAppTheme {
                // Display your TeamsApp composable which shows the scrollable list
                TeamsApp()
            }
        }
    }
}
