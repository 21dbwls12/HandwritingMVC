package com.example.handwritingmvc.view

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import coil3.compose.AsyncImage
import com.example.handwritingmvc.controller.ImageController
import com.example.handwritingmvc.controller.InkController
import com.example.handwritingmvc.controller.LiveInkController

@Composable
fun NoteView(imageController: ImageController) {

    val inkController = remember { InkController() }
    val line = inkController.inkBuilder
    val liveInkController = remember { LiveInkController() }

    // point 위치 추적을 위한 State
    var point by remember { mutableStateOf(Offset.Zero) }
    // 새로 그려지는 path 표시하기 위한 points State
    val points = remember { mutableListOf<Offset>() }
    // 새로 그려지고 있는 중인 획 State
    var path by remember { mutableStateOf(Path()) }

    val paths by liveInkController.paths.observeAsState()

    AsyncImage(
        model = imageController.selectedImagePainter,
        contentDescription = null,
        modifier = Modifier.fillMaxSize()
    )

    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectDragGestures(
                    onDragStart = { offset ->
                        point = offset
                        points.add(point)
                    },
                    onDrag = { _, dragAmount ->
                        point += dragAmount
                        points.add(point)
                        // onDrag가 호출 될 때마다 바로 그려지는 획 표시
                        path = Path()
                        points.forEachIndexed { index, point ->
                            if (index == 0) {
                                // 획의 시작 지점을 해당 좌표로 옮기기
                                path.moveTo(point.x, point.y)
                            } else {
                                // 처음 클릭한 것이 아니라면 직선 추가
                                path.lineTo(point.x, point.y)
                            }
                        }
                    },
                    onDragEnd = {
//                        InkController()
                        liveInkController.addPath(Pair(path, Stroke(1f)))
                        points.clear()
                        path = Path()

                    }
                )
            }
    ) {
        paths?.forEach {
            drawPath(path = it.first, Color.White, style = it.second)
        }

        drawPath(path, Color.White, style = Stroke(1f))
    }
}

// 실시간으로 그려지는 선이 보이지 않고 선을 다 그린 후에 나타남.
// 처음에 작성한 코드
//@OptIn(ExperimentalComposeUiApi::class)
//Canvas(
//    modifier = Modifier
//        .fillMaxSize()
//        .pointerInteropFilter {
//            inkController.addNewTouchEvent(it)
//            true
//        }
//) {
//    line.build().strokes.forEach { stroke ->
//        val path = Path().apply {
//            stroke.points.forEachIndexed { index, point ->
//                if (index == 0) {
//                    // 획의 시작지점을 해당 좌표로 옮기기
//                    moveTo(point.x, point.y)
//                } else {
//                    // 처음 클릭한 것이 아니라면 직선 추가
//                    lineTo(point.x, point.y)
//                }
//            }
//        }
//        // 선 색깔이 배경화면 색깔에 따라 바뀌어야함.(배경화면 고정도 방법)
//        // 이후에 색 지정하는 기능을 추가하는 것을 목표로 설정.
//        drawPath(path, Color.White)
//    }
//}
