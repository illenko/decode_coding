package com.illenko.netflix.diys.diy9 // ktlint-disable filename

internal object Solution {
    fun letterCombinations(digits: String): List<String> =
        if (digits.isEmpty() || digits.contains('1') || digits.length > 4) listOf()
        else backTrack(
            0,
            mutableListOf(),
            digits.toCharArray(),
            mapOf(
                '2' to "abc",
                '3' to "def",
                '4' to "ghi",
                '5' to "jkl",
                '6' to "mno",
                '7' to "pqrs",
                '8' to "tuv",
                '9' to "wxyz"
            )
        )

    private fun backTrack(
        index: Int,
        path: MutableList<String>,
        chars: CharArray,
        values: Map<Char, String>
    ): List<String> =
        if (path.size == chars.size) {
            listOf(path.joinToString(""))
        } else {
            val combinations = mutableListOf<String>()
            values[chars[index]]?.let { value ->
                value.toList().forEach {
                    path.add(it.toString())
                    combinations.addAll(backTrack(index + 1, path, chars, values))
                    if (path.isNotEmpty()) path.removeLast()
                }
            }
            combinations
        }
}
