package com.illenko.netflix.feature9 // ktlint-disable filename

internal class Solution(private val moviesPerGenre: HashMap<String, List<String>>) {

    fun letterCombinations(categories: List<String>): String =
        if (categories.isEmpty()) ""
        else "\"${backTrack(0, mutableListOf(), categories).joinToString("\", \"")}\""

    private fun backTrack(index: Int, path: MutableList<String>, genre: List<String>): List<String> =
        if (path.size == genre.size) {
            listOf(path.joinToString("; "))
        } else {
            val combinations = mutableListOf<String>()
            moviesPerGenre[genre[index]]?.let { movies ->
                movies.forEach {
                    path.add(it)
                    combinations.addAll(backTrack(index + 1, path, genre))
                    if (path.isNotEmpty()) path.removeLast()
                }
            }
            combinations
        }
}

fun main() {
    val solution = Solution(
        hashMapOf(
            "Family" to listOf("Frozen", "Kung fu Panda", "Ice Age"),
            "Action" to listOf("Iron Man", "Wonder Woman", "Avengers"),
            "Fantasy" to listOf("Jumangi", "Lion King", "Tarzan"),
            "Comedy" to listOf("Coco", "The Croods", "Vivi", "Pets"),
            "Horror" to listOf("Oculus", "Sinister", "Insidious", "Annebelle")
        )
    )

    // Example 1
    val categories = listOf("Action")
    println("Output 1: ${solution.letterCombinations(categories)}")

    // Example 2;
    val categories2 = listOf("Family", "Action")
    println("Output 2: ${solution.letterCombinations(categories2)}")

    // Example 3;
    val categories3 = listOf("Horror", "Comedy")
    println("Output 3: ${solution.letterCombinations(categories3)}")

    // Example 4;
    val categories4 = listOf("Horror", "Fantasy", "Comedy", "Family")
    println("Output 4: ${solution.letterCombinations(categories4)}")
}
