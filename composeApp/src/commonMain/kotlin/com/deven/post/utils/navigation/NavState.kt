package com.deven.post.utils.navigation

import androidx.compose.runtime.Immutable

/**
 * Navigation state with animation details for navigation
 */
@Immutable
data class NavState<STATE : Any>(
    val state: STATE?,
    val animation: NavigationAnimation,
)
