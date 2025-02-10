package com.example.handwritingmvc.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.example.handwritingmvc.Greeting

@Composable
fun ScaffoldView() {
    Scaffold(modifier = Modifier.fillMaxSize(), topBar = { ScaffoldTopAppBar() }) { innerPadding ->
        Greeting(
            name = "Android",
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldTopAppBar() {
    CenterAlignedTopAppBar(
        title = { Text("필기") },
        actions = {
            TopBarIconButtons(Icons.Rounded.Add) { }
        }
    )
}

@Composable
fun TopBarIconButtons(icon: ImageVector, onClick: () -> Unit) {
    IconButton(
        onClick = onClick
    ) {
        Icon(imageVector = icon,contentDescription = null)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFunction() {
    ScaffoldView()
}