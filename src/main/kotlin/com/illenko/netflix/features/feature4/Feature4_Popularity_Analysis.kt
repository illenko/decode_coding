package com.illenko.netflix.features.feature4 // ktlint-disable filename

internal object Solution {

    fun analyze(scores: List<Int>) {
        identifyTitles(scores).let {
            if (it.increasing && it.decreasing) {
                println("Title Score Static")
            } else if (!it.increasing && !it.decreasing) {
                println("Title Score Fluctuating")
            } else if (it.increasing) {
                println("Title Score Increasing")
            } else {
                println("Title Score Decreasing")
            }
        }
    }

    private fun identifyTitles(scores: List<Int>): IdentityResult {
        val identityResult = IdentityResult()
        for (i in 0 until scores.size - 1) {
            if (scores[i] > scores[i + 1]) identityResult.increasing = false
            else if (scores[i] < scores[i + 1]) identityResult.decreasing = false
        }
        return identityResult
    }

    private data class IdentityResult(var increasing: Boolean = true, var decreasing: Boolean = true)
}

fun main() {
    listOf(
        listOf(1, 2, 2, 3),
        listOf(1, 1, 1, 1),
        listOf(4, 5, 6, 3, 4),
        listOf(8, 8, 7, 6, 5, 4, 4, 1)
    ).forEach(Solution::analyze)
}
