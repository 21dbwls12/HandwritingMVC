package com.example.handwritingmvc.view

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import coil3.compose.AsyncImage
import com.example.handwritingmvc.controller.ImageController
import com.example.handwritingmvc.controller.LiveInkController
import com.example.handwritingmvc.model.InkModel

@Composable
fun NoteView(imageController: ImageController, inkController: LiveInkController) {
    // view에서 model을 직접 접근하지 않고 controller를 통해서만 접근하도록 설정
    val liveInkController = remember { inkController }

    // 드래그하고 있는 상태를 실시간으로 추적하기 위한 변수
    val refactorPath by liveInkController.refactorPath.observeAsState()

    val paths by liveInkController.paths.observeAsState()

    val strokeColor = if (isSystemInDarkTheme()) Color.White else Color.Black

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
                        liveInkController.onDragStart(offset)
                    },
                    onDrag = { _, dragAmount ->
                        liveInkController.onDrag(dragAmount)
                    },
                    onDragEnd = {
                        liveInkController.onDragEnd()
                    }
                )
            }
    ) {
        // 그린 모든 선을 화면에 보여주기 위해 사용
        paths?.forEach {
            drawPath(path = it.first, strokeColor, style = it.second)
        }

        // 선이 드래그하는 동안 실시간으로 보여주기 위해서 사용
        drawPath(refactorPath!!, strokeColor, style = Stroke(1f))
    }
}

// 실시간으로 그려지는 선이 보이지 않고 선을 다 그린 후에 나타남.
// 처음에 작성한 코드
//val inkController = remember { InkController() }
//val line = inkController.inkBuilder

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

// 실시간으로 그리는 선을 화면에 표시
//val liveInkController = remember { LiveInkController() }

//// point 위치 추적을 위한 State
//var point by remember { mutableStateOf(Offset.Zero) }
//// 새로 그려지는 path 표시하기 위한 points State
//val points = remember { mutableListOf<Offset>() }
//// 새로 그려지고 있는 중인 획 State
//var path by remember { mutableStateOf(Path()) }

//val paths by liveInkController.paths.observeAsState()

//Canvas(
//modifier = Modifier
//.fillMaxSize()
//.pointerInput(Unit) {
//    detectDragGestures(
//        onDragStart = { offset ->
//            point = offset
//            points.add(point)
//        },
//        onDrag = { _, dragAmount ->
//            point += dragAmount
//            points.add(point)
//            // onDrag가 호출 될 때마다 바로 그려지는 획 표시
//            path = Path()
//            points.forEachIndexed { index, point ->
//                if (index == 0) {
//                    // 획의 시작 지점을 해당 좌표로 옮기기
//                    path.moveTo(point.x, point.y)
//                } else {
//                    // 처음 클릭한 것이 아니라면 직선 추가
//                    path.lineTo(point.x, point.y)
//                }
//            }
//        },
//        onDragEnd = {
//            liveInkController.addPath(Pair(path, Stroke(1f)))
//            points.clear()
//            path = Path()
//
//        }
//    )
//}
//) {
//    // 그린 모든 선을 화면에 보여주기 위해 사용
//    paths?.forEach {
//        drawPath(path = it.first, Color.Black, style = it.second)
//    }
//
//    // 선이 드래그하는 동안 실시간으로 보여주기 위해서 사용
//    drawPath(path, Color.White, style = Stroke(1f))
//}