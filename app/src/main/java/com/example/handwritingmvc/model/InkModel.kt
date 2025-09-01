package com.example.handwritingmvc.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Path

class InkModel {
    var savedPath by mutableStateOf<Path?>(null)
        private set

    // 사용자가 그린 획을 저장하는 함수
    fun updatePath(path: Path) {
        savedPath = path
    }

    // 저장된 획을 모두 지우는 함수
    fun deletePath() {
        savedPath = null
    }
}