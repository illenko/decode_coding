package com.illenko.netflix.diys.diy7


// ktlint-disable filename

class MinStack(var maxSize: Int) {

    private var mainStack: Stack<Int> = Stack(maxSize)
    private var maximumStack: Stack<Int> = Stack(maxSize)

    fun pop(): Int {
        // 1. Pop element from maxStack to make it sync with mainStack,
        // 2. Pop element from mainStack and return that value
        maximumStack.pop()
        val max = mainStack.top()
        mainStack.pop()
        return max ?: Int.MIN_VALUE
    }

    // pushes value into the stack
    fun push(value: Int) {
        // 1. Push value in mainStack and check value with the top value of maxStack
        // 2. If value is greater than top, then push top in maxStack
        // else push value in maxStack
        mainStack.push(value)
        if (!maximumStack.isEmpty && maximumStack.top() ?: Int.MIN_VALUE < value) {
            maximumStack.push(maximumStack.top()!!)
        } else maximumStack.push(value)
    }

    // returns maximum value in O(1)
    fun min(): Int {
        return maximumStack.top()!!
    }
}
