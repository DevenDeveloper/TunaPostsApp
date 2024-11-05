package com.deven.post.utils.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import kotlinx.coroutines.flow.SharedFlow
import com.deven.post.utils.navigation.impl.NavigationControllerImpl
import com.deven.post.utils.navigation.impl.NavigationEvents
import com.deven.post.utils.navigation.impl.Stack

/**
 * NavController manages app navigation within a [NavHost].
 */
interface NavigationController<STATE> {
    /**
     * Count of items in the backstack
     */
    val backStackSize: Int

    /**
     * The current destination state in the navigation graph
     */
    val currentState: STATE?

    /**
     * Navigate to a [newState] in the current Navigation graph
     */
    fun navigateTo(newState: STATE)
    fun navigationClear(newState: STATE)

    fun navigateUp()

    /**
     * Reactive stream for [NavigationEvents]
     */
    val events: SharedFlow<NavigationEvents<STATE>>
}

/**
 * Remembers the navigation controller in this composition scope.
 * Across process-death or screen configuration change, compose will lose state. In order to
 * preserve states, [onSave] will be used to save the current state and [onRestore] will be used
 * to re-construct the state to maintain the previous state of navigation.
 */
@Composable
fun <STATE : Any, SAVABLE> rememberNavigationController(
    onSave: (STATE) -> SAVABLE,
    onRestore: (SAVABLE) -> STATE,
): NavigationController<STATE> {
    return rememberSaveable(
        Unit,
        saver = listSaver(
            save = { it.backStack.map { state -> onSave(state) } },
            restore = { savables ->
                NavigationControllerImpl(stack = Stack(savables.map { onRestore(it) }))
            },
        ),
    ) { NavigationControllerImpl() }
}
