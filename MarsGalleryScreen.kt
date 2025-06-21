package com.example.marsgallery.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.marsgallery.MarsViewModel
import com.example.marsgallery.model.MarsPhoto

@Composable
fun MarsGalleryScreen(viewModel: MarsViewModel) {
    val photos by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Mars Gallery", fontWeight = FontWeight.Bold) }
            )
        }
    ) { padding ->
        if (photos.isNotEmpty()) {
            LazyColumn(
                contentPadding = padding,
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.fillMaxSize().padding(16.dp)
            ) {
                items(photos) { photo ->
                    MarsPhotoItem(photo)
                }
            }
        } else {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Cargando imágenes de Marte...")
            }
        }
    }
}

@Composable
fun MarsPhotoItem(photo: MarsPhoto) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Image(
            painter = rememberImagePainter(data = photo.imgSrc),
            contentDescription = "Mars Rover Photo",
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp),
            contentScale = ContentScale.Crop
        )
    }
}
