package com.deven.post.utils.navigation

import androidx.compose.runtime.Composable
import kotlin.reflect.KClass

/**
 * Scope for [NavHost] which will be used to create the destination states in the navigation graph.
 */
interface NavHostScope<STATE : Any> {
    /**
     * Define the Composable [block] for the State [S] in the navigation graph.
     *
     * @param key Class representation of [S]
     */
    fun <S : STATE> OnState(
        key: KClass<S>,
        block: @Composable (entry: NavStackEntry<S>) -> Unit,
    )
}

/**
 * Define the Composable [block] for the State [S] in the navigation graph.
 */
inline fun <reified STATE : Any> NavHostScope<in STATE>.OnState(
    noinline block: @Composable (state: NavStackEntry<STATE>) -> Unit,
) {
    OnState(STATE::class, block)
}
