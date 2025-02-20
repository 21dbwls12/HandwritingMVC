package com.example.handwritingmvc.controller

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.handwritingmvc.model.LoadingModel

class LoadingController {
    @Composable
    fun GetUri() {
        var selectUri by remember { mutableStateOf<Uri?>(null) }

        selectUri = LoadingModel().loadImage()
    }
}