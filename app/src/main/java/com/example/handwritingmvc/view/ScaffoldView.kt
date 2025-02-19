package com.example.handwritingmvc.view

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun ScaffoldView(content: @Composable (PaddingValues) -> Unit) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { ScaffoldTopAppBar() },
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Icon(imageVector = Icons.Rounded.Edit, contentDescription = null)
            }
        }
    ) { innerPadding ->
        content(innerPadding)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldTopAppBar() {
    TopAppBar(
        title = { Text("필기를 작성하세요") },
        actions = {
            TopBarIconButtons(Icons.Rounded.Check) { }
            TopBarIconButtons(Icons.Rounded.Delete) { }
        }
    )
}

@Composable
fun TopBarIconButtons(icon: ImageVector, onClick: () -> Unit) {
    IconButton(
        onClick = onClick
    ) {
        Icon(imageVector = icon, contentDescription = null)
    }
}