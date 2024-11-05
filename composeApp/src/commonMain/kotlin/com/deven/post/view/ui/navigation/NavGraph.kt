package com.deven.post.view.ui.navigation

import androidx.compose.runtime.Composable
import com.deven.post.utils.navigation.NavHost
import com.deven.post.utils.navigation.OnState
import com.deven.post.utils.navigation.rememberNavigationController
import com.deven.post.view.ui.screens.post.PostScreen

@Composable
fun NavGraph() {
    val navController = rememberScreenNavController()

    NavHost(navController, initialState = Screen.Home) {
        OnState<Screen.Home> {
            PostScreen()
        }
    }
}

@Composable
fun rememberScreenNavController() = rememberNavigationController<Screen, Map<String, String>>(
    onSave = { screen -> screen.asSavable() },
    onRestore = { savable -> buildScreenFromSavable(savable) },
)
