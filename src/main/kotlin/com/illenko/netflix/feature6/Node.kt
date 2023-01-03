package com.illenko.netflix.feature6

data class Node<T>(
    val key: T,
    var value: T,
    var freq: Int,
    var next: Node<T>? = null,
    var prev: Node<T>? = null
) {
    override fun toString(): String = "($key, $value, $freq)"
}
