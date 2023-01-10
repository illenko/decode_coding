package com.illenko.netflix.diys.diy5

class LinkedListNode {
    var key = 0
    var data: Int
    var next: LinkedListNode?
    var prev: LinkedListNode? = null

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

    constructor(data: Int, next: LinkedListNode?, prev: LinkedListNode?) {
        this.data = data
        this.next = next
        this.prev = prev
    }
}
