package com.illenko.netflix.feature9 // ktlint-disable filename

internal class Solution(private val movies: HashMap<String, List<String>>) {

    // Declaring the combinations variable
    private var combinations: MutableList<String> = ArrayList()

    fun letterCombinations(categories: Array<String>): String {
        combinations.clear()
        // Return empty array if input is empty
        if (categories.isEmpty()) {
            return ""
        }

        // Initiate backtracking with an empty path and starting index of 0
        val path: MutableList<String> = ArrayList()
        backTrack(0, path, categories)
        return "\"${combinations.joinToString("\",\"")}\""
    }

    // Use backTrack function to generate all possible combinations
    private fun backTrack(index: Int, path: MutableList<String>, genre: Array<String>) {
        // If the length of path and genre is same,
        // we have a complete combinations
        if (path.size == genre.size) {
            combinations.add(path.joinToString(""))
            return
        }

        // Using the index and genre[index], get the list of movies
        movies[genre[index]]?.let {
            for (i in it.indices) {
                // Add the movie to our current path
                path.add(it[i] + ";")
                // Move on to the next category
                backTrack(index + 1, path, genre)
                // Before moving onto the next movie,
                // backTrack by removing the movie from the path
                if (path.size > 0) { // RemoveIndex is used to remove the element from the path
                    path.removeAt(path.size - 1)
                }
            }
        }
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
    val categories = arrayOf("Action")
    println("Output 1: ${solution.letterCombinations(categories)}")

    // Example 2;
    val categories2 = arrayOf("Family", "Action")
    println("Output 2: ${solution.letterCombinations(categories2)}")

    // Example 3;
    val categories3 = arrayOf("Horror", "Comedy")
    println("Output 3: ${solution.letterCombinations(categories3)}")

    // Example 4;
    val categories4 = arrayOf("Horror", "Fantasy", "Comedy", "Family")
    println("Output 4: ${solution.letterCombinations(categories4)}")
}
