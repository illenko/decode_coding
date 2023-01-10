package com.illenko.netflix.diys.diy5

class MyLinkedList {
    var head: LinkedListNode? = null
    var tail: LinkedListNode? = null
    var size = 0
    fun insertAtHead(key: Int, data: Int) {
        val newNode = LinkedListNode(key, data)
        if (head == null) {
            head = newNode
            tail = newNode
        } else {
            newNode.next = head
            head!!.prev = newNode
            head = newNode
        }
        size++
    }

    fun insertAtTail(key: Int, data: Int) {
        val newNode = LinkedListNode(key, data)
        if (tail == null) {
            tail = newNode
            head = newNode
            newNode.next = null
            newNode.prev = null
        } else {
            tail!!.next = newNode
            newNode.prev = tail
            tail = newNode
            newNode.next = null
        }
        size++
    }

    fun removeNode(node: LinkedListNode?): LinkedListNode? {
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

    fun remove(data: Int) {
        var i: LinkedListNode? = head
        while (i != null) {
            if (i.data == data) {
                removeNode(i)
            }
            i = i.next
        }
    }

    fun removeHead(): LinkedListNode? {
        return removeNode(head)
    }

    fun removeTail(): LinkedListNode? {
        return removeNode(tail)
    }
}
