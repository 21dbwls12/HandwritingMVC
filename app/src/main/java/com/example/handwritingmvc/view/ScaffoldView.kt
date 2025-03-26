package com.example.handwritingmvc.view

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.handwritingmvc.controller.ImageController

@Composable
fun ScaffoldView(imageController: ImageController, content: @Composable (PaddingValues) -> Unit) {
    val pickMedia =
        rememberLauncherForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
            uri.let {
                imageController.updateImagePickerResult(it)
            }
        }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { ScaffoldTopAppBar(imageController) },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
                }
            ) {
                Icon(imageVector = Icons.Rounded.Edit, contentDescription = null)
            }
        }
    ) { innerPadding ->
        if (imageController.isDeleteWritingClicked) {
            DialogForDeleteImage(imageController)
        }
        content(innerPadding)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ScaffoldTopAppBar(imageController: ImageController) {
    TopAppBar(
        title = { Text("필기를 작성하세요") },
        actions = {
            TopBarIconButtons(Icons.Rounded.Check) { }
            TopBarIconButtons(Icons.Rounded.Delete) { imageController.openDialogForDeleting() }
        }
    )
}

@Composable
private fun TopBarIconButtons(icon: ImageVector, onClick: () -> Unit) {
    IconButton(
        onClick = onClick
    ) {
        Icon(imageVector = icon, contentDescription = null)
    }
}

@Composable
private fun DialogForDeleteImage(imageController: ImageController) {
    AlertDialog(
        onDismissRequest = { imageController.closeDialogForDeleting() },
        confirmButton = {
            DialogTextButton("예") { imageController.deleteImageAndWriting(true) }
        },
        dismissButton = {
            DialogTextButton("아니오") { imageController.deleteImageAndWriting(false) }
        },
        icon = { Icon(imageVector = Icons.Rounded.Info, contentDescription = null) },
        text = { Text("이미지도 같이 삭제하시겠습니까?") }
    )
}

@Composable
private fun DialogTextButton(dialog: String, onClick: () -> Unit) {
    TextButton(
        onClick = onClick
    ) { Text(dialog) }
}