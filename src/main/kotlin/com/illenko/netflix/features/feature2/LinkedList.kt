package com.illenko.netflix.features.feature2

class LinkedList<T : Comparable<T>> {

    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var size = 0

    fun merge(otherList: LinkedList<T>) {
        var left = head
        var right = otherList.head
        val dummy = Node<T>()
        var prev = dummy
        size = 0

        while (left != null && right != null) {
            if (left.value!! <= right.value!!) {
                prev.next = left
                left = left.next
            } else {
                prev.next = right
                right = right.next
            }
            prev = prev.next!!
            size++
        }

        while (left != null) {
            prev.next = left
            left = left.next
            prev = prev.next!!
            size++
        }

        while (right != null) {
            prev.next = right
            right = right.next
            prev = prev.next!!
            size++
        }

        head = dummy.next
    }

    private fun append(value: T) {
        if (isEmpty()) {
            push(value)
            return
        }

        tail?.next = Node(value = value)

        tail = tail?.next
        size++
    }

    private fun isEmpty(): Boolean = size == 0

    private fun push(value: T): LinkedList<T> {
        head = Node(value = value, next = head)
        if (tail == null) {
            tail = head
        }
        size++
        return this
    }

    override fun toString(): String = if (isEmpty()) "[]" else "[$head]"

    companion object {
        operator fun <T : Comparable<T>> invoke(list: List<T>): LinkedList<T> {
            val linkedList = LinkedList<T>()
            list.forEach(linkedList::append)
            return linkedList
        }
    }
}
