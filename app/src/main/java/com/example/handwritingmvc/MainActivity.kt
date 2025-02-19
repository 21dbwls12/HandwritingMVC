package com.example.handwritingmvc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.handwritingmvc.ui.theme.HandwritingMVCTheme
import com.example.handwritingmvc.view.NoteView
import com.example.handwritingmvc.view.ScaffoldView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HandwritingMVCTheme {
                ScaffoldView {
                    NoteView()
                }
            }
        }
    }
}