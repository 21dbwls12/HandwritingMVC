package com.example.handwritingmvc.controller

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.handwritingmvc.model.InkModel

class LiveInkController(private val inkModel: InkModel) {
    // point 위치 추적을 위한 State
    private var point by mutableStateOf(Offset.Zero)
    // 새로 그려지는 path 표시하기 위한 points State
    private val points = mutableListOf<Offset>()
    // 새로 그려지고 있는 중인 획 State
    private var _refactorPath = MutableLiveData(Path())

    val refactorPath: LiveData<Path>
        get() = _refactorPath

    fun onDragStart(offset: Offset) {
        point = offset
        points.add(point)
    }

    fun onDrag(dragAmount: Offset) {
        point += dragAmount
        points.add(point)
        // onDrag가 호출 될 때마다 바로 그려지는 획 표시
        _refactorPath.value = Path()
        points.forEachIndexed{ index, point ->
            if (index == 0) {
                // 획의 시작 지점을 해당 좌표로 옮기기
                _refactorPath.value!!.moveTo(point.x, point.y)
            } else {
                // 처음 클릭한 것이 아니라면 직선 추가
                _refactorPath.value!!.lineTo(point.x, point.y)
            }
        }
    }

    fun onDragEnd() {
        inkModel.updatePath(Pair(refactorPath.value!!, Stroke(1f)))
        points.clear()
        _refactorPath.value = Path()
    }

    fun deleteWriting() {
        inkModel.deletePath()
    }
}
