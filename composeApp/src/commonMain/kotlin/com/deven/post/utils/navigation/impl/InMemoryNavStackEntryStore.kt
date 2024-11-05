package com.deven.post.utils.navigation.impl

import com.deven.post.utils.navigation.NavStackEntry

/**
 * The key-value store (in memory) for backstack state destinations
 */
class InMemoryNavStackEntryStore<STATE : Any> {

    /**
     * Returns [NavStackEntry] for the [forState].
     */
    @Suppress("UNCHECKED_CAST")
    fun get(forState: STATE): NavStackEntry<STATE> {
        return inMemoryValueStore.getOrPut(forState) {
            NavStackEntryImpl(forState)
        } as NavStackEntry<STATE>
    }

    /**
     * Disposes store for [forState]
     */
    fun dispose(forState: STATE) {
        inMemoryValueStore[forState]?.dispose()
        inMemoryValueStore.remove(forState)
    }

    companion object {
        private val inMemoryValueStore = mutableMapOf<Any, NavStackEntryImpl<Any>>()
    }
}
