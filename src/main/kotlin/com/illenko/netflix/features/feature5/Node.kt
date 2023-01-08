package com.illenko.netflix.features.feature5

data class Node<T>(
    val key: T,
    val value: T,
    var next: Node<T>? = null,
    var prev: Node<T>? = null
) {
    override fun toString(): String {
        return if (next != null) {
            "($key, $value) -> $next"
        } else {
            "($key, $value)"
        }
    }
}
