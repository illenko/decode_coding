package com.illenko.netflix.features.feature11 // ktlint-disable filename

import java.util.*

internal object Solution {
    fun generatePermutations(movies: List<String>): List<List<String>> =
        backTrack(size = movies.size, movies = movies.toMutableList())

    private fun backTrack(first: Int = 0, size: Int, movies: List<String>): List<List<String>> =
        if (first == size) listOf(ArrayList(movies))
        else {
            (first until size).map { index ->
                Collections.swap(movies, first, index)
                backTrack(first + 1, size, movies)
                    .also { Collections.swap(movies, first, index) }
            }.flatten().toList()
        }
}

fun main() {
    // Example #1
    println("Output 1: ${Solution.generatePermutations(listOf("Frozen", "Dune", "Coco"))}")

    // Example #2
    println("Output 2: ${Solution.generatePermutations(listOf("Frozen", "Dune", "Coco", "Melificient"))}")

    // Example #3
    println("Output 3: ${Solution.generatePermutations(listOf("Dune", "Coco"))}")
}
