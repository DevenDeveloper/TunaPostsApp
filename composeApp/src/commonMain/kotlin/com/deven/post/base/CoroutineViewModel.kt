package com.deven.post.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.StateFlow

/**
 * The base state-holder model for the UI for performing UI-business operations
 *
 * @property viewModelScope The coroutine scope which will be bound with the UI lifecycle
 */
abstract class CoroutineViewModel<STATE>(protected val viewModelScope: CoroutineScope) {
    /**
     * The reactive state of a UI
     */
    abstract val state: StateFlow<STATE>

    /**
     * Invoked when the [CoroutineViewModel] is no longer needed. Do clean-up stuff here.
     */
    open fun onCleared() {
        viewModelScope.cancel()
    }
}

/**
 * The factory for creating instance of [CoroutineViewModel] in the composition.
 *
 * THIS APPROACH IS NOT LOOKING MUCH GOOD. SO NEED TO FIND SOMETHING WHICH MIGHT BE RELIABLE.
 * TILL THE TIME, LET THIS BE THE EXPERIMENTAL IMPLEMENTATION.
 * TODO: Use something better approach
 *
 * @param provideViewModel Lambda factory for creating ViewModel
 */
fun <VM : CoroutineViewModel<STATE>, STATE> viewModelFactory(provideViewModel: (CoroutineScope) -> VM): VM {
    val viewModelScope = ViewModelCoroutineScope()
    return provideViewModel(viewModelScope)
}
