package com.example.handwritingmvc.controller

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class LiveInkController {
    var point by mutableStateOf(Offset.Zero)
    val points = mutableListOf<Offset>()
    var path = mutableStateOf(Path())
    private val _paths = MutableLiveData<MutableList<Pair<Path, DrawStyle>>>()
    private val _pathStyle = MutableLiveData(Stroke(width = 0.5f))

    val paths: LiveData<MutableList<Pair<Path, DrawStyle>>>
        get() = _paths
    val pathStyle: LiveData<Stroke>
        get() = _pathStyle

    fun addPath(newPath: Pair<Path, DrawStyle>) {
        var pathList = _paths.value

        if (pathList != null) {
            pathList.add(newPath)
        } else {
            pathList = mutableListOf(newPath)
        }
        _paths.value = pathList ?: _paths.value
    }

//    fun onDrag
}   