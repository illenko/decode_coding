package com.illenko.netflix.features.feature1 // ktlint-disable filename

object Solution {

    fun groupTitles(titles: Array<String>): Map<String, List<String>> =
        titles.associateWith { calculateKey(it) }
            .entries
            .groupBy { it.value }
            .mapValues { entry -> entry.value.map { it.key } }

    fun calculateKey(word: String): String =
        word.lowercase()
            .toList()
            .groupingBy { it }
            .eachCount()
            .let { wordCharCounts -> ('a'..'z').map { wordCharCounts[it] ?: 0 }.joinToString("#") }
}

fun main() {
    // Driver code
    val titles = arrayOf("duel", "dule", "speed", "spede", "deul", "cars")

    Solution.groupTitles(titles)[Solution.calculateKey("speed")]?.let { println(it) }
    Solution.groupTitles(titles)[Solution.calculateKey("duel")]?.let { println(it) }
}
