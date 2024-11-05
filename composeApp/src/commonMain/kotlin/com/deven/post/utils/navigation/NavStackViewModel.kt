package com.deven.post.utils.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisallowComposableCalls
import com.deven.post.base.CoroutineViewModel
import com.deven.post.base.viewModelFactory
import kotlinx.coroutines.CoroutineScope

@Composable
inline fun <VM : CoroutineViewModel<STATE>, STATE> NavStackEntry<*>.navStackViewModel(
    key: Any? = null,
    noinline provider: @DisallowComposableCalls (CoroutineScope) -> VM,
): VM {
    val vmkey = "viewModel-${key?.toString() ?: ""}"
    return rememberInNavStack(
        key = vmkey,
        compute = { viewModelFactory(provider) },
        onDispose = { vm -> vm.onCleared() },
    )
}
