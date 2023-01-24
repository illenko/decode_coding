package com.illenko.facebook.features.feature1 // ktlint-disable filename

internal object Solution {

    fun friendCircles(friends: Array<BooleanArray>): Int {
        var numCircles = 0
        val visited = BooleanArray(friends.size)

        for (i in friends.indices) {
            if (!visited[i]) {
                visited[i] = true
                DFS(friends, visited, i)
                numCircles += 1
            }
        }
        return numCircles
    }

    private fun DFS(friends: Array<BooleanArray>, visited: BooleanArray, v: Int) {
        for (i in friends.indices) {
            if (friends[v][i] && !visited[i] && i != v) {
                visited[i] = true
                DFS(friends, visited, i)
            }
        }
    }
}

fun main() {
    val friends = arrayOf(
        booleanArrayOf(true, true, false, false),
        booleanArrayOf(true, true, true, false),
        booleanArrayOf(false, true, true, false),
        booleanArrayOf(false, false, false, true)
    )
    println("Number of friends circles: ${Solution.friendCircles(friends)}")
}
