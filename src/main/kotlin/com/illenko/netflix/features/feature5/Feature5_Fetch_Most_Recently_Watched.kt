package com.illenko.netflix.features.feature5 // ktlint-disable filename

internal class LRUCache<T : Comparable<T>>(private var capacity: Int) {

    private var cache: HashMap<T, Node<T>> = HashMap(capacity)
    private var cacheValues: LinkedList<T> = LinkedList()

    fun get(key: T): Node<T>? {
        return if (cache.containsKey(key)) {
            val value = cache[key]!!.value
            cacheValues.remove(cache[key])
            cacheValues.append(key, value)
            cacheValues.tail
        } else {
            null
        }
    }

    fun set(key: T, value: T) {
        if (cache.containsKey(key)) cacheValues.remove(cache[key]) else evictIfNeeded()
        cache[key] = cacheValues.append(key, value)
    }

    private fun evictIfNeeded() {
        if (cacheValues.size >= capacity) {
            val node = cacheValues.removeHead()
            cache.remove(node?.key)
        }
    }

    fun print() = println(cacheValues.head)
}

fun main() {
    val cache = LRUCache<Int>(3)
    println("The most recently watched titles are: (key, value)")
    cache.set(10, 20)
    cache.print()
    cache.set(15, 25)
    cache.print()
    cache.set(20, 30)
    cache.print()
    cache.set(25, 35)
    cache.print()
    cache.set(5, 40)
    cache.print()
    cache.get(25)
    cache.print()
}
