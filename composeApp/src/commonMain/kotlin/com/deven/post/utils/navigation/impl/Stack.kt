package com.deven.post.utils.navigation.impl

/**
 * The stack data structure
 */
class Stack<E : Any>(initialItems: Collection<E> = emptyList()) {
    private val queue = ArrayDeque<E>(initialItems)

    /**
     * Items in this stack
     */
    val items: List<E> get() = queue.toList()

    /**
     * Top element of this stack.
     */
    val top: E? get() = queue.lastOrNull()

    /**
     * Size of this stack.
     */
    val size: Int get() = queue.size

    /**
     * Pushes [element] onto the stack.
     */
    fun push(element: E) {
        queue.addLast(element)
    }

    /**
     * Pops element out of the stack and returns popped element.
     */
    fun pop(): E {
        return queue.removeLast()
    }
    fun pop1() {
        return queue.clear()
    }

    fun popAll(lastElement: E): E {
//        queue.removeLast()
        queue.forEach {
            if (it != lastElement) {
                queue.remove(it)
            }
        }
        return queue.removeLast()
    }
}
