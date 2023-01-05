package com.illenko.netflix.feature7 // ktlint-disable filename

fun main() {
    val stack = Stack<Int>()

    stack.push(5)
    stack.push(0)
    stack.push(2)
    stack.push(4)
    stack.push(6)
    stack.push(3)
    stack.push(10)

    println("Maximum Rating: ${stack.maxRating()}")

    stack.pop()

    println("After clicking back button")

    println("Maximum Rating: ${stack.maxRating()}")
}
