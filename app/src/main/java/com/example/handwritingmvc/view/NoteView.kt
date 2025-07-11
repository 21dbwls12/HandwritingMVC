package com.example.handwritingmvc.view

import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.pointerInteropFilter
import coil3.compose.AsyncImage
import com.example.handwritingmvc.controller.ImageController
import com.example.handwritingmvc.controller.InkController
import com.google.mlkit.vision.digitalink.Ink

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun NoteView(imageController: ImageController) {
    // point 위치 추적
//    var point by remember { mutableStateOf(Offset.Zero) }
//    // 새로 그려지는 획의 점을 저장하는 리스트
//    val points = remember { mutableListOf<Offset>() }
//    // 새로 그려지고 있는 중인 획
//    var path by remember { mutableStateOf(Path()) }
//    // 다 그려진 획들을 저장하는 리스트
//    val paths = remember { mutableListOf<Path>() }

    val inkController = remember { InkController() }
    val writing = inkController.inkBuilder
//    val ink = remember { mutableStateOf(Ink.builder().build()) }
//    val stroke1 = Ink.Stroke.builder()
//        .addPoint(Ink.Point.create(50f, 50f))
//        .addPoint(Ink.Point.create(100f, 100f))
//        .addPoint(Ink.Point.create(150f, 50f))
//        .build()
//    val updateInk = Ink.builder().addStroke(stroke1).build()
//    ink.value = updateInk


    Box(
//        modifier = Modifier.pointerInteropFilter {
//            inkController.addNewTouchEvent(it)
//            true
//        }
    ) {
//        InkController().addNewTouchEvent()
//        InkController().inkBuilder
//        Log.i("inkbuilder", InkController().inkBuilder.toString())

//        Canvas(
//            modifier = Modifier
//                .fillMaxSize()
//            .pointerInput(Unit) {
//                detectDragGestures(
//                    onDragStart = { offset ->
//                        point = offset
//                        points.add(point)
//                    },
//                    onDrag = { _, dragAmount ->
//                        point += dragAmount
//                        points.add(point)
//                        // onDrag가 호출 될 때마다 바로 그려지는 획 표시
//                        path = Path()
//                        points.forEachIndexed {index, point ->
//                            if (index == 0) {
//                                // 획의 시작 지점을 해당 좌표로 옮기기
//                                path.moveTo(point.x, point.y)
//                            } else {
//                                // 직선 추가
//                                path.lineTo(point.x, point.y)
//                            }
//                        }
//                    },
//                    onDragEnd = {
//                        InkController()
//                    }
//                )
//            }
//                .pointerInteropFilter {
//                    inkController.addNewTouchEvent(it)
//                    true
//                }
//        ) {}

        AsyncImage(
            model = imageController.selectedImagePainter,
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )

        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .pointerInteropFilter {
                    inkController.addNewTouchEvent(it)
                    true
                }
        ) {
            writing.build().strokes.forEach { stroke ->
                val path = Path().apply {
                    stroke.points.forEachIndexed { index, point ->
                        if (index == 0) {
                            // 획의 시작지점을 해당 좌표로 옮기기
                            moveTo(point.x, point.y)
                        } else {
                            // 처음 클릭한 것이 아니라면 직선 추가
                            lineTo(point.x, point.y)
                        }
                    }
                }
                // 선 색깔이 배경화면 색깔에 따라 바뀌어야함.(배경화면 고정도 방법)
                // 이후에 색 지정하는 기능을 추가하는 것을 목표로 설정.
                drawPath(path, Color.White)
            }
        }
    }
}