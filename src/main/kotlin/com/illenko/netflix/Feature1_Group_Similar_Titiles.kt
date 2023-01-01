package com.illenko.netflix // ktlint-disable filename

internal object Solution {
    fun groupTitles(strs: Array<String>): Map<String, MutableList<String>> {
        val res = mutableMapOf<String, MutableList<String>>()

        strs.forEach {
            val key = calculateKey(it)
            if (!res.contains(key)) res[key] = ArrayList()
            res[key]!!.add(it)
        }

        return res
    }

    fun calculateKey(str: String): String =
        str.toList()
            .groupingBy { it }
            .eachCount()
            .toSortedMap()
            .values
            .joinToString("#")
}

fun main() {
    // Driver code
    val titles = arrayOf("duel", "dule", "speed", "spede", "deul", "cars")

    Solution.groupTitles(titles)[Solution.calculateKey("speed")]?.let { println(it) }
    Solution.groupTitles(titles)[Solution.calculateKey("duel")]?.let { println(it) }
}
