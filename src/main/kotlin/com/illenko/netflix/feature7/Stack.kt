package com.illenko.netflix.feature7

import java.util.Stack

class Stack<T : Comparable<T>> {
    private var mainStack: Stack<T> = Stack()
    private var maximumStack: Stack<T> = Stack()

    fun pop(): T {
        // 1. Pop element from maxStack to make it sync with mainStack,
        // 2. Pop element from mainStack and return that value
        maximumStack.pop()
        val top = mainStack.peek()
        mainStack.pop()
        return top
    }

    // pushes value into the stack
    fun push(value: T) {
        // 1. Push value in mainStack and check value with the top value of maxStack
        // 2. If value is greater than top, then push top in maxStack
        // else push value in maxStack
        mainStack.push(value)
        if (!maximumStack.empty() && maximumStack.peek() > value) {
            maximumStack.push(maximumStack.peek())
        } else maximumStack.push(value)
    }

    // returns maximum value in O(1)
    fun maxRating(): T {
        return maximumStack.peek()
    }
}
