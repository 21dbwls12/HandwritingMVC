package com.example.handwritingmvc.model

import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class ImageModel {
    // 이미지 uri를 저장
    var savedUri by mutableStateOf<Uri?> (null)
        // 위에 선언된 uri값이 외부에서 접근할 수 있지만 수정은 불가능하게 해줌
        private set

    // 변경된 uri값을 저장하는 함수
    fun updateUri(uri: Uri?) {
        savedUri = uri
    }

    // uri값을 기본값으로 변경하는 함수
    fun deleteUri() {
        savedUri = null
    }
}