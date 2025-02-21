package com.example.handwritingmvc.view

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import com.example.handwritingmvc.controller.LoadingController

@Composable
fun NoteView() {
    val painter = LoadingController().controlImage()

    Image(
        painter = painter,
        contentDescription = null
    )
}