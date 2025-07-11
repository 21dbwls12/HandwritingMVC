package com.example.handwritingmvc.controller

import android.view.MotionEvent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.google.mlkit.vision.digitalink.Ink

class InkController {
//    var inkBuilder = Ink.Builder()
    var inkBuilder by mutableStateOf(Ink.builder())
        private set 
    private lateinit var strokeBuilder: Ink.Stroke.Builder


    fun addNewTouchEvent(event: MotionEvent) {
        val action = event.actionMasked
        val x = event.x
        val y = event.y
        var t = System.currentTimeMillis()

        when (action) {
            MotionEvent.ACTION_DOWN -> {
                strokeBuilder = Ink.Stroke.builder()
                strokeBuilder.addPoint(Ink.Point.create(x,y,t))
            }
            MotionEvent.ACTION_MOVE -> {
                strokeBuilder.addPoint((Ink.Point.create(x, y, t)))
            }
            MotionEvent.ACTION_UP -> {
                strokeBuilder.addPoint(Ink.Point.create(x, y, t))
                // model 파일에서 관리하도록 수정 해야함.
                val lastInkBuilder = inkBuilder
                // 화면을 새로 그리지 않아도 그린 획이 화면에 보이게 하기 위해 builder()로 코드 변경
                // 이전 코드
                // inkBuilder.addStroke(strokeBuilder.build())
                inkBuilder = Ink.builder().apply {
                    // 원래 그려져있던 획
                    lastInkBuilder.build().strokes.forEach{ addStroke(it) }
                    // 새로 그린 획
                    addStroke(strokeBuilder.build() )
                }
            }
            else -> {
                inkBuilder.build()
            }
        }
    }
}