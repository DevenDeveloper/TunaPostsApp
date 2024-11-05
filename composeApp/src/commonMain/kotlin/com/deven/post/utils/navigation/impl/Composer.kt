package com.deven.post.utils.navigation.impl

import androidx.compose.runtime.Composable
import com.deven.post.utils.navigation.NavStackEntry

/**
 * Composer of the destination [STATE] in the navigation graph.
 * [STATE] is a super type of [BASE] state.
 */
fun interface Composer<STATE : BASE, BASE : Any> {
    /**
     * Composes destination with the [entry]
     */
    @Composable
    fun compose(entry: NavStackEntry<STATE>)
}

/**
 * Composer of the destination [BASE] in the navigation graph.
 * [BASE] is a super type of [BASE] state.
 */
fun <STATE : BASE, BASE : Any> Composer(
    block: @Composable (NavStackEntry<STATE>) -> Unit,
): Composer<STATE, BASE> {
    return ComposerImpl(block)
}

/**
 * Default implementation of [Composer]
 */
class ComposerImpl<STATE : BASE, BASE : Any>(
    val block: @Composable (NavStackEntry<STATE>) -> Unit,
) : Composer<STATE, BASE> {
    @Composable
    override fun compose(entry: NavStackEntry<STATE>) {
        block(entry)
    }
}
