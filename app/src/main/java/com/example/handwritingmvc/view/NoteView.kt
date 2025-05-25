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
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.pointerInteropFilter
import coil3.compose.AsyncImage
import com.example.handwritingmvc.controller.ImageController
import com.example.handwritingmvc.controller.InkController

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun NoteView(imageController: ImageController) {
    // point 위치 추적
    var point by remember { mutableStateOf(Offset.Zero) }
    // 새로 그려지는 획의 점을 저장하는 리스트
    val points = remember { mutableListOf<Offset>() }
    // 새로 그려지고 있는 중인 획
    var path by remember { mutableStateOf(Path()) }
    // 다 그려진 획들을 저장하는 리스트
    val paths = remember { mutableListOf<Path>() }

    val inkController = InkController()

    Box(
        modifier = Modifier.pointerInteropFilter {
            inkController.addNewTouchEvent(it)
            true
        }
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
        inkController.inkBuilder
    }
}