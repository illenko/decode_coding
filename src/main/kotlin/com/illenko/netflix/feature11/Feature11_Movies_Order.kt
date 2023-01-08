package com.illenko.netflix.feature11 // ktlint-disable filename

import java.util.*

internal object Solution {
    fun generatePermutations(movies: List<String>): List<List<String>> {
        val output = LinkedList<List<String>>()
        val size = movies.size

        // convert movies into list since the output is a list of lists
        val moviesList = mutableListOf<String>()
        moviesList.addAll(movies)
        backTrack(0, size, moviesList, output)
        return output
    }

    private fun backTrack(first: Int, size: Int, moviesList: List<String>, output: MutableList<List<String>>) {
        // If all strings of given array `moviesList` are used and
        // and Backtracking is performed add the permutations to output array.
        if (first == size) {
            output.add(ArrayList(moviesList))
        }

        // Perform Backtracking for the size of a given array.
        (first until size).forEach {
            // Swap: In the current permutation place i-th integer first.
            Collections.swap(moviesList, first, it)

            // Complete permutations using the next integers.
            backTrack(first + 1, size, moviesList, output)

            // Swap
            Collections.swap(moviesList, first, it)
        }
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
