package com.illenko.netflix.diys.diy2

import java.util.*

class LinkedListNode {
    var key = 0
    var data: Int
    var next: LinkedListNode?
    var arbitraryPointer: LinkedListNode? = null

    constructor(data: Int) {
        this.data = data
        next = null
    }

    constructor(key: Int, data: Int) {
        this.key = key
        this.data = data
        next = null
    }

    constructor(data: Int, next: LinkedListNode?) {
        this.data = data
        this.next = next
    }

    constructor(data: Int, next: LinkedListNode?, arbitraryPointer: LinkedListNode?) {
        this.data = data
        this.next = next
        this.arbitraryPointer = arbitraryPointer
    }
}

object LinkedList {
    fun insertAtHead(head: LinkedListNode?, data: Int): LinkedListNode {
        val newNode = LinkedListNode(data)
        newNode.next = head
        return newNode
    }

    fun insertAtTail(head: LinkedListNode?, data: Int): LinkedListNode {
        val newNode = LinkedListNode(data)
        if (head == null) {
            return newNode
        }
        var temp = head
        while (temp!!.next != null) {
            temp = temp.next
        }
        temp.next = newNode
        return head
    }

    fun insertAtTail(head: LinkedListNode?, node: LinkedListNode): LinkedListNode {
        if (head == null) {
            return node
        }
        var temp = head
        while (temp!!.next != null) {
            temp = temp.next
        }
        temp.next = node
        return head
    }

    fun createLinkedList(lst: ArrayList<Int>): LinkedListNode? {
        var head: LinkedListNode? = null
        var tail: LinkedListNode? = null
        for (x in lst) {
            val newNode = LinkedListNode(x)
            if (head == null) {
                head = newNode
            } else {
                tail!!.next = newNode
            }
            tail = newNode
        }
        return head
    }

    fun createLinkedList(arr: IntArray): LinkedListNode? {
        var head: LinkedListNode? = null
        var tail: LinkedListNode? = null
        for (i in arr.indices) {
            val newNode = LinkedListNode(arr[i])
            if (head == null) {
                head = newNode
            } else {
                tail!!.next = newNode
            }
            tail = newNode
        }
        return head
    }

    fun createRandomList(length: Int): LinkedListNode? {
        var listHead: LinkedListNode? = null
        val generator = Random()
        for (i in 0 until length) {
            listHead = insertAtHead(listHead, generator.nextInt(100))
        }
        return listHead
    }

    fun toList(head: LinkedListNode?): ArrayList<Int> {
        val lst = ArrayList<Int>()
        var temp = head
        while (temp != null) {
            lst.add(temp.data)
            temp = temp.next
        }
        return lst
    }

    fun display(head: LinkedListNode?) {
        var temp = head
        while (temp != null) {
            System.out.printf("%d", temp.data)
            temp = temp.next
            if (temp != null) {
                System.out.printf(", ")
            }
        }
        println()
    }

    fun mergeAlternating(list1_: LinkedListNode?, list2_: LinkedListNode?): LinkedListNode? {
        var list1 = list1_
        var list2 = list2_
        if (list1 == null) {
            return list2
        }
        if (list2 == null) {
            return list1
        }
        val head: LinkedListNode = list1
        while (list1!!.next != null && list2 != null) {
            val temp: LinkedListNode = list2
            list2 = list2.next
            temp.next = list1.next
            list1.next = temp
            list1 = temp.next
        }
        if (list1.next == null) {
            list1.next = list2
        }
        return head
    }

    fun isEqual(list1_: LinkedListNode?, list2_: LinkedListNode?): Boolean {
        var list1 = list1_
        var list2 = list2_
        if (list1 === list2) {
            return true
        }
        while (list1 != null && list2 != null) {
            if (list1.data != list2.data) {
                return false
            }
            list1 = list1.next
            list2 = list2.next
        }
        return list1 === list2
    }
}
