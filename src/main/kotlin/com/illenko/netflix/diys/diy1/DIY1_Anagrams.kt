package com.illenko.netflix.diys.diy1 // ktlint-disable filename

internal object Solution {
    fun groupAnagrams(strs: List<String>): List<List<String>> =
        mutableMapOf<String, MutableList<String>>().let { map ->
            strs.forEach { map.computeIfAbsent(calculateKey(it)) { mutableListOf() }.add(it) }
            map.values.toList()
        }

    private fun calculateKey(word: String): String =
        word.lowercase()
            .toList()
            .groupingBy { it }
            .eachCount()
            .let { wordCharCounts -> ('a'..'z').map { wordCharCounts[it] ?: 0 }.joinToString("#") }
}

fun main() {
    println(Solution.groupAnagrams(listOf("word", "sword", "drow", "rowd", "iced", "dice")))
}
