package com.example.marsgallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.marsgallery.ui.MarsGalleryScreen
import com.example.marsgallery.ui.theme.MarsGalleryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MarsGalleryTheme {
                val viewModel: MarsViewModel = viewModel()
                MarsGalleryScreen(viewModel)
            }
        }
    }
}
