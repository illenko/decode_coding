package com.illenko.netflix.diys.diy5 // ktlint-disable filename

internal class LRUCache(private var capacity: Int) {
    // LinkedListNode holds key and value pairs
    private var cache: HashMap<Int, LinkedListNode> = HashMap(capacity)
    private var cacheVals: MyLinkedList = MyLinkedList()

    fun Get(key: Int): Int {
        return if (cache.containsKey(key)) {
            val value = cache[key]!!.data
            cacheVals.removeNode(cache[key])
            cacheVals.insertAtTail(key, value)
            cacheVals.tail?.data ?: -1
        } else {
            -1
        }
    }

    fun Set(key: Int, value: Int) {
        if (cache.containsKey(key)) cacheVals.removeNode(cache[key]) else evictIfNeeded()
        cacheVals.insertAtTail(key, value)
        cache[key] = cacheVals.tail!!
    }

    private fun evictIfNeeded() {
        if (cacheVals.size >= capacity) {
            val node = cacheVals.removeHead()
            cache.remove(node?.key)
        }
    }

    fun print(): String {
        var result = ""
        var node: LinkedListNode? = cacheVals.head
        while (node != null) {
            result += "(" + node.key.toString() + "," + node.data.toString() + ")"
            node = node.next
        }
        return result
    }
}
