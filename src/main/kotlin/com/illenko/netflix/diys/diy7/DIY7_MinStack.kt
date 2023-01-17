package com.illenko.netflix.diys.diy7 // ktlint-disable filename

class MinStack(private var maxSize: Int) {

    private var mainStack: Stack<Int> = Stack(maxSize)
    private var minStack: Stack<Int> = Stack(maxSize)

    fun pop(): Int {
        minStack.pop()
        val max = mainStack.top()
        mainStack.pop()
        return max ?: Int.MIN_VALUE
    }

    fun push(value: Int) {
        mainStack.push(value)
        if (!minStack.isEmpty && minStack.top()!! < value) {
            minStack.push(minStack.top()!!)
        } else minStack.push(value)
    }

    fun min(): Int {
        return minStack.top()!!
    }
}
