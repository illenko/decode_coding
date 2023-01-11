package com.illenko.netflix.diys.diy6

class MyLinkedList {
    var head: LinkedListNode? = null
    var tail: LinkedListNode? = null
    fun append(node: LinkedListNode) {
        node.next = null
        node.prev = null
        if (head == null) {
            head = node
        } else {
            tail!!.next = node
            node.prev = tail
        }
        tail = node
    }

    fun deleteNode(node: LinkedListNode) {
        if (node.prev != null) {
            node.prev!!.next = node.next
        } else {
            head = node.next
        }
        if (node.next != null) {
            node.next!!.prev = node.prev
        } else {
            tail = node.prev
        }
        node.next = null
        node.prev = null
    }
}
