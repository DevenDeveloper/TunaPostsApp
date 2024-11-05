package com.deven.post.view.ui.navigation

import androidx.compose.runtime.Immutable

/**
 * Screens used in the app
 */
@Immutable
sealed interface Screen {
    /**
     * Home screen i.e.
     */
    @Immutable
    object Home : Screen {
        override fun equals(other: Any?): Boolean {
            return other === Home
        }

        override fun hashCode(): Int {
            return this::class.simpleName.hashCode()
        }
    }

    @Immutable
    data object PostScreen : Screen

}
