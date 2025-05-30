package com.example.handwritingmvc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.handwritingmvc.controller.ImageController
import com.example.handwritingmvc.model.ImageModel
import com.example.handwritingmvc.ui.theme.HandwritingMVCTheme
import com.example.handwritingmvc.view.NoteView
import com.example.handwritingmvc.view.ScaffoldView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val imageModel = ImageModel()
        val imageController = ImageController(imageModel)

        setContent {
            HandwritingMVCTheme {
                ScaffoldView(imageController) {
                    NoteView(imageController)
                }
            }
        }
    }
}