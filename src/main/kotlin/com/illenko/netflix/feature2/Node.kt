package com.illenko.netflix.feature2

data class Node<T>(var value: T? = null, var next: Node<T>? = null) {
    override fun toString(): String {
        return if (next != null) {
            "$value -> $next"
        } else {
            "$value"
        }
    }
}
