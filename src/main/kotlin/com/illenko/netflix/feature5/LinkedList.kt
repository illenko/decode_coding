package com.illenko.netflix.feature5

data class LinkedList<T : Comparable<T>>(
    var head: Node<T>? = null,
    var tail: Node<T>? = null,
    var size: Int = 0
) {

    fun push(key: T, value: T): LinkedList<T> {
        val newNode = Node(key = key, value = value, next = head)

        if (head == null) {
            head = newNode
            tail = head
        } else {
            head!!.prev = newNode
            head = newNode
        }
        size++
        return this
    }

    fun append(key: T, value: T) {
        if (isEmpty()) {
            push(key, value)
            return
        }

        val newNode = Node(key = key, value = value, next = null)

        tail!!.next = newNode
        newNode.prev = tail
        tail = newNode
        newNode.next = null

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

    fun remove(value: T) {
        var i = head
        while (i != null) {
            if (i.value == value) {
                remove(i)
            }
            i = i.next
        }
    }

    fun removeHead(): Node<T>? {
        return remove(head)
    }

    fun removeTail(): Node<T>? {
        return remove(tail)
    }

    private fun isEmpty(): Boolean = size == 0

    override fun toString(): String = if (isEmpty()) "[]" else "[$head]"
}
