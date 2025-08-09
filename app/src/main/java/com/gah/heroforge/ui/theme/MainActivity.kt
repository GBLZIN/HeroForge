package com.gah.heroforge.ui.theme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gah.heroforge.screens.StoryScreen
import com.gah.heroforge.viewmodel.StoryViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HeroForgeTheme {
                val storyViewModel: StoryViewModel = viewModel()
                StoryScreen(storyViewModel)
            }
        }
    }
}
