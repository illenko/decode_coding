package com.illenko.netflix.feature2 // ktlint-disable filename

object Solution {
    fun <T : Comparable<T>> mergeLists(lists: List<LinkedList<T>>): LinkedList<T> {
        if (lists.isEmpty()) return LinkedList(emptyList())
        val initial = lists.first()
        for (i in 1 until lists.size) initial.merge(lists[i])
        return initial
    }
}

fun main() {
    val list1 = LinkedList(listOf(11, 41, 51))
    val list2 = LinkedList(listOf(21, 23, 42))
    val list3 = LinkedList(listOf(25, 56, 66, 72))

    Solution.mergeLists(listOf(list1, list2, list3))

    println(list1)
}
