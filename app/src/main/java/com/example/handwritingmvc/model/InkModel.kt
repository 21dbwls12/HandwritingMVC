package com.example.handwritingmvc.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Path

class InkModel {
    var savedPath by mutableStateOf<Path?>(null)
        private set
}