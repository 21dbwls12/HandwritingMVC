package com.example.handwritingmvc.view

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.input.pointer.pointerInteropFilter
import coil3.compose.AsyncImage
import com.example.handwritingmvc.controller.ImageController
import com.example.handwritingmvc.controller.InkController

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun NoteView(imageController: ImageController) {

    val inkController = remember { InkController() }
    val line = inkController.inkBuilder


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
            line.build().strokes.forEach { stroke ->
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