package com.illenko.netflix.diys.diy6 // ktlint-disable filename

internal class LFUCache(var capacity: Int) {
    var size = 0
    var minFreq = 0

    // LinkedListNode holds key and value pairs
    private var keysMap = HashMap<Int, LinkedListNode>(capacity)
    private var freqMap = HashMap<Int, MyLinkedList>(capacity)

    fun Get(key: Int): Int {
        if (!keysMap.containsKey(key)) {
            return -1
        }
        val temp = keysMap[key]
        freqMap[temp!!.freq]!!.deleteNode(temp)
        if (freqMap[keysMap[key]!!.freq] == null) {
            freqMap.remove(keysMap[key]!!.freq)
            if (minFreq == keysMap[key]!!.freq) {
                minFreq += 1
            }
        }
        keysMap[key]!!.freq += 1
        if (!freqMap.containsKey(keysMap[key]!!.freq)) {
            freqMap[keysMap[key]!!.freq] = MyLinkedList()
        }
        freqMap[keysMap[key]!!.freq]!!.append(keysMap[key]!!)
        return keysMap[key]?.`val` ?: -1
    }

    fun Set(key: Int, data: Int) {
        if (Get(key) != -1) {
            keysMap[key]!!.`val` = data
            return
        }
        if (size == capacity) {
            keysMap.remove(freqMap[minFreq]!!.head!!.key)
            freqMap[minFreq]!!.deleteNode(freqMap[minFreq]!!.head!!)
            if (freqMap[minFreq]!!.head == null) {
                freqMap.remove(minFreq)
            }
            size--
        }
        minFreq = 1
        keysMap[key] = LinkedListNode(key = key, `val` = data, freq = minFreq)

        freqMap.computeIfAbsent(keysMap[key]!!.freq) { MyLinkedList() }.append(keysMap[key]!!)

        size++
    }

    fun print(): String {
        var result = ""
        for ((key, value) in keysMap) {
            result += "(" + key + "," + value.`val` + ")"
        }
        return result
    }
}

fun main() {
    val lfu = LFUCache(2) // Initialize the cache
    lfu.Set(10, 20) // Set the key 10 with value 20
    lfu.Get(10) // Get the value against key 10
    println(lfu.print()) // Return the cached key-value pairs
}
