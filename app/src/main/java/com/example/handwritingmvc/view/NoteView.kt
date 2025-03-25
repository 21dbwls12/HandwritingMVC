package com.example.handwritingmvc.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil3.compose.AsyncImage
import com.example.handwritingmvc.controller.ImageController

@Composable
fun NoteView(imageController: ImageController) {
    AsyncImage(
        model = imageController.selectedImagePainter,
        contentDescription = null,
        modifier = Modifier.fillMaxSize()
    )
}