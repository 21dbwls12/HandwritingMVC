package com.example.handwritingmvc.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawStyle

class InkModel {
    var savedPath by mutableStateOf(emptyList<Pair<Path, DrawStyle>>())
        private set

    // 사용자가 그린 획을 저장하는 함수
    fun updatePath(path: MutableList<Pair<Path, DrawStyle>>) {
        savedPath = path
    }

    // 저장된 획을 모두 지우는 함수
    fun deletePath() {
        savedPath = emptyList()
    }
}