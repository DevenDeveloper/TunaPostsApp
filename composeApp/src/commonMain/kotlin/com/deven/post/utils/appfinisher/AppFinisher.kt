package com.deven.post.utils.appfinisher

import androidx.compose.runtime.compositionLocalOf

/**
 * The controller for exiting from application
 */
interface AppFinisher {
    /**
     * Finishes the activity and exits
     */
    fun finish()
}

val LocalAppFinisher = compositionLocalOf<AppFinisher> { error("Implementation not provided") }
