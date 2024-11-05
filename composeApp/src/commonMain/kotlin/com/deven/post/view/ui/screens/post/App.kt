package com.deven.post.view.ui.screens.post

import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.deven.post.view.ui.navigation.NavGraph
import com.deven.post.view.ui.theme.AppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {

    AppTheme {
        Surface {
            NavGraph()
        }
    }
}