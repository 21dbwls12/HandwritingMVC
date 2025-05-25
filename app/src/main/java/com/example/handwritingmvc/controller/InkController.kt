package com.example.handwritingmvc.controller

import android.util.Log
import android.view.MotionEvent
import com.google.mlkit.vision.digitalink.Ink

class InkController {
    var inkBuilder = Ink.Builder()
    lateinit var strokeBuilder: Ink.Stroke.Builder



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
            MotionEvent.ACTION_MOVE -> strokeBuilder.addPoint((Ink.Point.create(x, y, t)))
            MotionEvent.ACTION_UP -> {
                strokeBuilder.addPoint(Ink.Point.create(x, y, t))
                inkBuilder.addStroke((strokeBuilder.build()))
            }
            else -> {
                inkBuilder.build()
            }
        }
    }
}