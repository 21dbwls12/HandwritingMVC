package com.example.handwritingmvc.view

import androidx.compose.runtime.Composable
import coil3.compose.AsyncImage
import com.example.handwritingmvc.controller.ImageController

@Composable
fun NoteView(imageController: ImageController) {
    val painter = imageController.selectedImagePainter

    AsyncImage(
        model = painter,
        contentDescription = null
    )
}