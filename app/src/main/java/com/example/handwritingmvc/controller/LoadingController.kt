package com.example.handwritingmvc.controller

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import coil3.compose.AsyncImagePainter
import coil3.compose.LocalPlatformContext
import coil3.compose.rememberAsyncImagePainter
import coil3.request.ImageRequest
import com.example.handwritingmvc.model.LoadingModel

class LoadingController {
    // 사진선택도구로 이미지 불러오는 전체 controller
    @Composable
    fun controlImage(): AsyncImagePainter {
        var selectedUri by remember { mutableStateOf<Uri?>(null) }
        var selectedImagePainter by remember { mutableStateOf<AsyncImagePainter?>(null) }

        selectedUri = getUri()
        selectedImagePainter = sendImage(selectedUri)
        return selectedImagePainter!!
    }

    // model에서 uri 가져오는 함수
    @Composable
    private fun getUri(): Uri? {
        return LoadingModel().loadImage()
    }

    // coil에서 uri를 painter로 변환하고 반환하는 함수
    @Composable
    private fun sendImage(uri: Uri?): AsyncImagePainter {
        val painter = rememberAsyncImagePainter(
            model = ImageRequest.Builder(LocalPlatformContext.current)
                .data(uri)
                .build(),
        )

        return painter
    }
}