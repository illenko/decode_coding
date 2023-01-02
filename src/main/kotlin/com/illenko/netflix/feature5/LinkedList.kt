package com.illenko.netflix.feature5

data class LinkedList<T : Comparable<T>>(
    var head: Node<T>? = null,
    var tail: Node<T>? = null,
    var size: Int = 0
) {
    fun append(key: T, value: T): Node<T> {
        if (isEmpty()) {
            return push(key, value)
        }

        val newNode = Node(key = key, value = value, next = null)

        tail!!.next = newNode
        newNode.prev = tail
        tail = newNode

        size++

        return tail!!
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

    fun removeHead(): Node<T>? = remove(head)

    private fun push(key: T, value: T): Node<T> {
        val newNode = Node(key = key, value = value, next = head)

        if (head == null) {
            head = newNode
            tail = head
        } else {
            head!!.prev = newNode
            head = newNode
        }
        size++
        return head!!
    }

    private fun isEmpty(): Boolean = size == 0

    override fun toString(): String = if (isEmpty()) "[]" else "[$head]"
}
