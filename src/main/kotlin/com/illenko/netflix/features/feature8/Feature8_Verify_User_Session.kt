package com.illenko.netflix.features.feature8 // ktlint-disable filename

class Stack<T> {

    private var head: Node<T>? = null
    private var size: Int = 0

    private class Node<T>(var value: T) {
        var next: Node<T>? = null
    }

    fun push(item: T) {
        val new = Node(item)
        new.next = head
        head = new
        size++
    }

    fun top(): T {
        if (isEmpty()) throw NoSuchElementException()
        return head!!.value
    }

    fun pop(): T {
        if (isEmpty()) throw NoSuchElementException()
        val old = head!!
        head = old.next
        size--
        return old.value
    }

    fun isEmpty(): Boolean = size == 0

    fun contains(element: T): Boolean {
        for (obj in this) {
            if (obj == element) return true
        }
        return false
    }

    operator fun iterator(): Iterator<T> {
        return object : Iterator<T> {
            var node = head

            override fun hasNext(): Boolean = node != null

            override fun next(): T {
                if (!hasNext()) throw NoSuchElementException()
                val current = node!!
                node = current.next
                return current.value
            }
        }
    }
}

fun verifySession(pushSequence: List<Int>, popSequence: List<Int>): Boolean {
    val localStack = Stack<Int>()
    var i = 0
    pushSequence.forEach {
        localStack.push(it)

        while (!localStack.isEmpty() && localStack.top() == popSequence[i]) {
            localStack.pop()
            i++
        }
    }

    return localStack.isEmpty()
}

fun main() {
    val pushSequence = listOf(1, 2, 3, 4, 5, 6)
    val popSequence = listOf(5, 6, 3, 4, 1, 2)

    if (verifySession(pushSequence, popSequence)) {
        println("Session was successful")
    } else println("Session was faulty")

    val pushSequence2 = listOf(1, 2, 3, 4, 5, 6)
    val popSequence2 = listOf(5, 6, 4, 3, 2, 1)

    if (verifySession(pushSequence2, popSequence2)) {
        println("Session was successful")
    } else println("Session was faulty")
}
