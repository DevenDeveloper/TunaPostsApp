package com.deven.post.utils.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisallowComposableCalls
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.remember

/**
 * Representation of an entry in the back stack.
 */
@Immutable
interface NavStackEntry<STATE : Any> {
    /**
     * The current state of the destination
     */
    val state: STATE

    /**
     * If value is calculated with the [key], it returns it. Otherwise computes new value with
     * [compute] and stores it. The lifecycle of the computed value will be valid for the lifetime
     * of this destination on the back stack. When the state is popped of, [onDispose] will be
     * invoked for performing cleanup stuff.
     */
    fun <T : Any> getOrPut(key: Any, compute: () -> T, onDispose: (T) -> Unit): T
}

/**
 * Remembers the value computed by [compute] with the specified [key] for the destination of this
 * [NavStackEntry].
 *
 * If value is calculated with the [key], it returns it. Otherwise computes new value with
 * [compute] and stores it. The lifecycle of the computed value will be valid for the lifetime
 * of this destination on the back stack. When the state is popped of, [onDispose] will be
 * invoked for performing cleanup stuff.
 */
@Composable
inline fun <T : Any> NavStackEntry<*>.rememberInNavStack(
    key: Any,
    noinline compute: @DisallowComposableCalls () -> T,
    noinline onDispose: @DisallowComposableCalls (T) -> Unit = {},
): T {
    return remember(key) { getOrPut(key, compute, onDispose) }
}

/**
 * Remembers the value computed by [compute] with the specified [key] for the destination of this
 * composition's local [NavStackEntry].
 *
 * If value is calculated with the [key], it returns it. Otherwise computes new value with
 * [compute] and stores it. The lifecycle of the computed value will be valid for the lifetime
 * of this destination on the back stack. When the state is popped of, [onDispose] will be
 * invoked for performing cleanup stuff.
 */
@Composable
inline fun <T : Any> rememberInNavStack(
    key: Any,
    noinline compute: @DisallowComposableCalls () -> T,
    noinline onDispose: @DisallowComposableCalls (T) -> Unit = {},
): T {
    return LocalNavStackEntry.current.rememberInNavStack(key, compute, onDispose)
}
