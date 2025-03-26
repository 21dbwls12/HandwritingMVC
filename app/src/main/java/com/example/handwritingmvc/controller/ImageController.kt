package com.example.handwritingmvc.controller

import android.content.Context
import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import coil3.compose.AsyncImagePainter
import coil3.compose.LocalPlatformContext
import coil3.compose.rememberAsyncImagePainter
import coil3.request.ImageRequest
import com.example.handwritingmvc.model.ImageModel

class ImageController(private val imageModel: ImageModel) {
    // _: backing properties 명명 규칙
    // 값이 class 내부에서만 변경될 수 있고 외부에서는 읽기만 가능하도록 선언
    private var _selectedImagePainter = mutableStateOf(imageModel.savedUri)
    val selectedImagePainter by _selectedImagePainter

    private var _isDeleteWritingClicked = mutableStateOf(false)
    val isDeleteWritingClicked by _isDeleteWritingClicked

    // ScaffoldView에서 사진선택도구 실행하고 결과값을 Model에서 관리할 수 있도록 연결하는 함수
    // 지금은 직접 연결하는데 추후에는 버튼이 클릭되었을 때 Boolean값을 받아서 사진선택도구를 여기서 실행할 수 있도록 변경해야 함
    fun updateImagePickerResult(uri: Uri?) {
        imageModel.updateUri(uri)
        _selectedImagePainter.value = uri
    }



    @Composable
    private fun createPainter(context: Context, uri: Uri): AsyncImagePainter {
        return rememberAsyncImagePainter(
            model = ImageRequest.Builder(context)
                .data(uri)
                .build(),
        )
    }

    // coil에서 uri를 painter로 변환하고 반환하는 함수
    @Composable
    fun sendImage(): AsyncImagePainter {
        val painter = rememberAsyncImagePainter(
            model = ImageRequest.Builder(LocalPlatformContext.current)
                .data(selectedImagePainter)
                .build(),
        )

        return painter
    }
}