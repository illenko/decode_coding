package com.illenko.netflix.diys.diy5 // ktlint-disable filename

internal class LRUCache(private var capacity: Int) {

    private var cache = HashMap<Int, LinkedListNode>(capacity)
    private var cacheValues = MyLinkedList()

    fun Get(key: Int): Int {
        return if (cache.containsKey(key)) {
            val value = cache[key]!!.data
            cacheValues.removeNode(cache[key])
            cacheValues.insertAtTail(key, value)
            cacheValues.tail?.data ?: -1
        } else {
            -1
        }
    }

    fun Set(key: Int, value: Int) {
        if (cache.containsKey(key)) cacheValues.removeNode(cache[key]) else evictIfNeeded()
        cacheValues.insertAtTail(key, value)
        cache[key] = cacheValues.tail!!
    }

    private fun evictIfNeeded() {
        if (cacheValues.size >= capacity) {
            val node = cacheValues.removeHead()
            cache.remove(node?.key)
        }
    }

    fun print(): String {
        var result = ""
        var node = cacheValues.head
        while (node != null) {
            result += "(" + node.key.toString() + "," + node.data.toString() + ")"
            node = node.next
        }
        return result
    }
}
