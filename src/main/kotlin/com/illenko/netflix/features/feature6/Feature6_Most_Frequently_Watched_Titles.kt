package com.illenko.netflix.features.feature6 // ktlint-disable filename

internal class LFUCache(private var capacity: Int) {
    private var size = 0
    private var minFreq = 0

    // LinkedListNode holds key and value pairs
    private var keysMap = HashMap<Int, Node<Int>>(capacity)
    private var freqMap = HashMap<Int, LinkedList<Int>>(capacity)

    fun get(key: Int): Node<Int>? {
        if (!keysMap.containsKey(key)) {
            return null
        }
        val temp = keysMap[key]
        freqMap[temp!!.freq]!!.remove(temp)
        if (freqMap[keysMap[key]!!.freq] == null) {
            freqMap.remove(keysMap[key]!!.freq)
            if (minFreq == keysMap[key]!!.freq) {
                minFreq += 1
            }
        }
        keysMap[key]!!.freq += 1
        if (!freqMap.containsKey(keysMap[key]!!.freq)) {
            freqMap[keysMap[key]!!.freq] = LinkedList()
        }
        freqMap[keysMap[key]!!.freq]!!.append(keysMap[key]!!)
        return keysMap[key]
    }

    fun set(key: Int, value: Int) {
        if (get(key) != null) {
            keysMap[key]!!.value = value
            return
        }
        if (size == capacity) {
            keysMap.remove(freqMap[minFreq]!!.head!!.key)
            freqMap[minFreq]!!.remove(freqMap[minFreq]!!.head!!)
            if (freqMap[minFreq] == null) {
                freqMap.remove(minFreq)
            }
            size--
        }
        minFreq = 1
        keysMap[key] = Node(key = key, value = value, freq = minFreq)

        freqMap.computeIfAbsent(keysMap[key]!!.freq) { LinkedList() }.append(keysMap[key]!!)

        size++
    }

    fun print() {
        keysMap.forEach { print("(${it.key}, ${it.value})") }
        println()
    }
}

fun main() {
    val cache = LFUCache(2)
    print("The most frequently watched titles are: (key, value)\n")
    cache.set(1, 1)
    cache.set(2, 2)
    cache.print()
    cache.get(1)
    cache.set(3, 3)
    cache.print()
    cache.get(2)
    cache.set(4, 4)
    cache.get(1)
    cache.get(3)
    cache.get(4)
    cache.print()
}
