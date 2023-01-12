package com.illenko.netflix.diys.diy7

class Stack<V>( // returns the maximum size capacity
    val maxSize: Int
) {
    private var top: Int
    private val array: Array<V?>
    var currentSize: Int
        private set

    // returns true if Stack is empty
    val isEmpty: Boolean
        get() = top == -1

    // returns true if Stack is full
    val isFull: Boolean
        get() = top == maxSize - 1

    // returns the value at top of Stack
    fun top(): V? {
        return if (isEmpty) null else array[top]
    }

    // inserts a value to the top of Stack
    fun push(value: V) {
        if (isFull) {
            System.err.println("Stack is Full!")
            return
        }
        array[++top] = value // increments the top and adds value to updated top
        currentSize++
    }

    // removes a value from top of Stack and returns
    fun pop(): V? {
        if (isEmpty) return null
        currentSize--
        return array[top--] // returns value and top and decrements the top
    }

    init {
        top = -1 // initially when stack is empty
        @Suppress("UNCHECKED_CAST")
        array = arrayOfNulls<Any>(maxSize) as Array<V?> // type casting Object[] to V[]
        currentSize = 0
    }
}
