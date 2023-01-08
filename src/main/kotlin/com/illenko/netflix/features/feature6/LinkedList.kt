package com.illenko.netflix.features.feature6

data class LinkedList<T : Comparable<T>>(
    var head: Node<T>? = null,
    var tail: Node<T>? = null,
    var size: Int = 0
) {
    fun append(node: Node<T>) {
        node.next = null
        node.prev = null
        if (head == null) {
            head = node
        } else {
            tail!!.next = node
            node.prev = tail
        }
        tail = node
        size++
    }

    fun remove(node: Node<T>?): Node<T>? {
        if (node == null) {
            return null
        }
        if (node.prev != null) {
            node.prev!!.next = node.next
        }
        if (node.next != null) {
            node.next!!.prev = node.prev
        }
        if (node === head) {
            head = head!!.next
        }
        if (node === tail) {
            tail = tail!!.prev
        }
        size--
        return node
    }

    private fun isEmpty(): Boolean = size == 0

    override fun toString(): String = if (isEmpty()) "[]" else "[$head]"
}
